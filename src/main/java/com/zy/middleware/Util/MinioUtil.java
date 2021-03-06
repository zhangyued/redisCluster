package com.zy.middleware.Util;

import com.alibaba.druid.util.StringUtils;
import com.zy.middleware.Exception.TestMinioController.BucketMakeException;
import com.zy.middleware.Exception.TestMinioController.MinioClientInitException;
import com.zy.middleware.Exception.TestMinioController.PutObjectException;
import com.zy.middleware.Exception.TestMinioController.RemoveBucketException;
import com.zy.middleware.Properties.MinioProperty;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PutObjectOptions;
import io.minio.Result;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteError;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class MinioUtil {

    @Autowired
    private MinioProperty minioProperty;

    private static final int DEFAULT_EXPIRY_TIME = 7 * 24 * 3600;

    private static MinioClient minioClient;

    /**
     * 初始化minioClient
     * @return
     * @throws Exception
     */
    public MinioClient getInstance() {
        try{
            if (minioClient == null) {
                minioClient = new MinioClient(minioProperty.getEndpoint(),minioProperty.getAccessKey(),minioProperty.getSecretKey());
            }
        }catch (Exception e){
            throw new MinioClientInitException(e.getMessage());
        }
        return minioClient;
    }

    /**
     * 创建存储桶
     * @param bucketName
     * @return
     * @throws Exception
     */
    public boolean makeBucket(String bucketName) {
        try{
            if (!bucketExists(bucketName)) {
                minioClient.makeBucket(bucketName);
                return true;
            }
        }catch (Exception e){
            throw new BucketMakeException(e.getMessage());
        }
        return false;
    }

    /**
     * 检查存储桶是否存在
     * @param bucketName 存储桶名称
     * @return
     */
    public boolean bucketExists(String bucketName) throws Exception {
        if (minioClient.bucketExists(bucketName)) {
            return true;
        }
        return false;
    }

    /**
     * 列出所有存储桶
     * @return
     * @throws Exception
     */
    public List<Bucket> listBuckets() throws Exception{
        return minioClient.listBuckets();
    }

    /**
     * 列出所有存储桶名称
     * @return
     * @throws Exception
     */
    public List<String> listBucketNames() throws Exception{
        List<Bucket> bucketList = listBuckets();
        List<String> bucketListName = new ArrayList<>();
        for (Bucket bucket : bucketList) {
            bucketListName.add(bucket.name());
        }
        return bucketListName;
    }

    /**
     * 列出存储桶中的所有对象
     * @param bucketName
     * @return
     * @throws Exception
     */
    public Iterable<Result<Item>> listObjects(String bucketName) throws Exception{
        boolean flag = bucketExists(bucketName);
        if (flag) {
            return minioClient.listObjects(bucketName);
        }
        return null;
    }

    /**
     * 列出存储桶中的所有对象名称
     * @param bucketName
     * @return
     */
    public List<String> listObjectNames(String bucketName) throws Exception{
        List<String> listObjectNames = new ArrayList<>();
        boolean flag = bucketExists(bucketName);
        if (flag) {
            Iterable<Result<Item>> myObjects = listObjects(bucketName);
            for (Result<Item> result : myObjects) {
                Item item = result.get();
                listObjectNames.add(item.objectName());
            }
        }
        return listObjectNames;
    }

    /**
     * 删除存储桶
     * @param bucketName
     * @return
     * @throws Exception
     */
    public boolean removeBucket(String bucketName) {
        try{
            if (bucketExists(bucketName)) {
                Iterable<Result<Item>> myObjects = listObjects(bucketName);
                for (Result<Item> result : myObjects) {
                    // 有对象文件，则删除失败
                    if (result.get().size() > 0) {
                        return false;
                    }
                }
                // 删除存储桶，注意，只有存储桶为空时才能删除成功。
                minioClient.removeBucket(bucketName);
                return true;
            }
        }catch (Exception e){
            throw new RemoveBucketException(e.getMessage());
        }
        return false;
    }

    /**
     * 获取对象的元数据
     * @param bucketName
     * @param objectName
     * @return
     */
    public ObjectStat statObject(String bucketName, String objectName) throws Exception{
        if (bucketExists(bucketName)) {
            ObjectStat statObject = minioClient.statObject(bucketName, objectName);
            return statObject;
        }
        return null;
    }

    /**
     * 通过文件上传到对象
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称。
     * @param fileName File name
     * @return
     * @throws Exception
     */
    public boolean putObject(String bucketName, String objectName, String fileName) {
        try{
            //若桶不存在，则创建新的桶
            if (!bucketExists(bucketName)) {
                makeBucket(bucketName);
            }
            minioClient.putObject(bucketName, objectName, fileName, null);
            ObjectStat statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                return true;
            }
        }catch (Exception e){
            throw new PutObjectException(e.getMessage());
        }
        return false;
    }

    /**
     * 文件上传
     * @param bucketName
     * @param multipartFile
     * @param filename
     */
    public void putObject(String bucketName, MultipartFile multipartFile, String filename) throws Exception{
        PutObjectOptions putObjectOptions = new PutObjectOptions(multipartFile.getSize(), PutObjectOptions.MIN_MULTIPART_SIZE);
        putObjectOptions.setContentType(multipartFile.getContentType());
        minioClient.putObject(bucketName, filename, multipartFile.getInputStream(), putObjectOptions);
    }

    /**
     * 通过InputStream上传对象
     * @param bucketName
     * @param objectName
     * @param stream
     * @return
     */
    public boolean putObject(String bucketName, String objectName, InputStream stream) throws IOException {
        try{
            if (!bucketExists(bucketName)) {
                makeBucket(bucketName);
            }
            minioClient.putObject(bucketName, objectName, stream, new PutObjectOptions(stream.available(), -1));
            ObjectStat statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                return true;
            }
        }catch (Exception e){
            throw new PutObjectException(e.getMessage());
        }finally {
            stream.close();
        }
        return false;
    }

    /**
     * 以流的形式获取一个文件对象
     * @param bucketName
     * @param objectName
     * @return
     */
    public InputStream getObject(String bucketName, String objectName) throws Exception{
        boolean flag = bucketExists(bucketName);
        if (flag) {
            ObjectStat statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                InputStream stream = minioClient.getObject(bucketName, objectName);
                return stream;
            }
        }
        return null;
    }

    /**
     * 以流的形式获取一个文件对象（断点下载）
     * @param bucketName
     * @param objectName
     * @param offset
     * @param length
     * @return
     * @throws Exception
     */
    public InputStream getObject(String bucketName, String objectName, long offset, Long length) throws Exception{
        boolean flag = bucketExists(bucketName);
        if (flag) {
            ObjectStat statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                InputStream stream = minioClient.getObject(bucketName, objectName, offset, length);
                return stream;
            }
        }
        return null;
    }

    /**
     * 下载并将文件保存到本地
     * @param bucketName
     * @param objectName
     * @param fileName
     * @return
     */
    public boolean getObject(String bucketName, String objectName, String fileName) throws Exception{
        boolean flag = bucketExists(bucketName);
        if (flag) {
            ObjectStat statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                minioClient.getObject(bucketName, objectName, fileName);
                return true;
            }
        }
        return false;
    }

    /**
     * 删除一个对象
     * @param bucketName
     * @param objectName
     * @return
     */
    public boolean removeObject(String bucketName, String objectName) throws Exception{
        boolean flag = bucketExists(bucketName);
        if (flag) {
            minioClient.removeObject(bucketName, objectName);
            return true;
        }
        return false;
    }

    /**
     * 删除指定桶的多个文件对象,返回删除错误的对象列表，全部删除成功，返回空列表
     * @param bucketName 存储桶名称
     * @param objectNames 含有要删除的多个object名称的迭代器对象
     * @return
     */
    public List<String> removeObject(String bucketName, List<String> objectNames) throws Exception{
        List<String> deleteErrorNames = new ArrayList<>();
        boolean flag = bucketExists(bucketName);
        if (flag) {
            Iterable<Result<DeleteError>> results = minioClient.removeObjects(bucketName, objectNames);
            for (Result<DeleteError> result : results) {
                DeleteError error = result.get();
                deleteErrorNames.add(error.objectName());
            }
        }
        return deleteErrorNames;
    }

    /**
     * 生成一个给HTTP GET请求用的presigned URL。
     * 浏览器/移动端的客户端可以用这个URL进行下载，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天。
     *
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称
     * @param expires    失效时间（以秒为单位），默认是7天，不得大于七天
     * @return
     */
    public String presignedGetObject(String bucketName, String objectName, Integer expires) throws Exception{
        boolean flag = bucketExists(bucketName);
        String url = "";
        if (flag) {
            if (expires < 1 || expires > DEFAULT_EXPIRY_TIME) {
                throw new InvalidExpiresRangeException(expires,
                        "expires must be in range of 1 to " + DEFAULT_EXPIRY_TIME);
            }
            url = minioClient.presignedGetObject(bucketName, objectName, expires);
        }
        return url;
    }

    /**
     * 生成一个给HTTP PUT请求用的presigned URL。
     * 浏览器/移动端的客户端可以用这个URL进行上传，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天。
     *
     * @param bucketName 存储桶名称
     * @param objectName 存储桶里的对象名称
     * @param expires    失效时间（以秒为单位），默认是7天，不得大于七天
     * @return
     */
    public String presignedPutObject(String bucketName, String objectName, Integer expires) throws Exception{
        boolean flag = bucketExists(bucketName);
        String url = "";
        if (flag) {
            if (expires < 1 || expires > DEFAULT_EXPIRY_TIME) {
                throw new InvalidExpiresRangeException(expires,
                        "expires must be in range of 1 to " + DEFAULT_EXPIRY_TIME);
            }
            url = minioClient.presignedPutObject(bucketName, objectName, expires);
        }
        return url;
    }

    /**
     * 文件访问路径
     * @param bucketName
     * @param objectName
     * @return
     */
    public String getObjectUrl(String bucketName, String objectName) throws Exception{
        boolean flag = bucketExists(bucketName);
        String url = "";
        if (flag) {
            url = minioClient.getObjectUrl(bucketName, objectName);
        }
        return url;
    }

    public void downloadFile(String bucketName, String fileName, String originalName, HttpServletResponse response) {
        try {
            InputStream file = minioClient.getObject(bucketName, fileName);
            String filename = new String(fileName.getBytes("ISO8859-1"), StandardCharsets.UTF_8);
            if (!StringUtils.isEmpty(originalName)) {
                fileName = originalName;
            }
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = file.read(buffer)) > 0) {
                servletOutputStream.write(buffer, 0, len);
            }
            servletOutputStream.flush();
            file.close();
            servletOutputStream.close();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
