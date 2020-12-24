package com.zy.middleware.Service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.zy.middleware.Contstant.CommonContstant;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObject.UploadObjectRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObject.UploadObjectResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObjectByStream.UploadObjectByStreamRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObjectByStream.UploadObjectByStreamResponseDto;
import com.zy.middleware.Exception.TestMinioController.BucketMakeException;
import com.zy.middleware.Exception.TestMinioController.MinioClientInitException;
import com.zy.middleware.Exception.TestMinioController.PutObjectException;
import com.zy.middleware.Exception.TestMinioController.RemoveBucketException;
import com.zy.middleware.Service.MinioService;
import com.zy.middleware.Util.MinioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Service
public class MinioServiceImpl implements MinioService {

    private static final Logger log = LoggerFactory.getLogger(MinioServiceImpl.class);

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public AddBucketResponseDto addBucket(AddBucketRequestDto addBucketRequestDto) {
        AddBucketResponseDto addBucketResponseDto = new AddBucketResponseDto();
        try{
            minioUtil.getInstance();
            if (null != addBucketRequestDto && !StringUtils.isEmpty(addBucketRequestDto.getBucketName())) {
                if (minioUtil.makeBucket(addBucketRequestDto.getBucketName())){
                    return addBucket_initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.SUCCESS_CODE,CommonContstant.commonReturn_Msg.SUCCESS_MSG);
                }else{
                    return addBucket_initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG);
                }
            }else{
                return addBucket_initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + "桶名为空");
            }
        }catch (MinioClientInitException e){
            log.debug("MinioClient初始化异常");
            e.printStackTrace();
            return addBucket_initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }catch (BucketMakeException e){
            log.debug("桶创建异常");
            e.printStackTrace();
            return addBucket_initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }catch (Exception e){
            log.debug("程序异常");
            e.printStackTrace();
            return addBucket_initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }
    }

    @Override
    public RemoveBucketResponseDto removeBucket(RemoveBucketRequestDto removeBucketRequestDto) {
        RemoveBucketResponseDto removeBucketResponseDto = new RemoveBucketResponseDto();
        try{
            minioUtil.getInstance();
            if (null != removeBucketRequestDto && !StringUtils.isEmpty(removeBucketRequestDto.getBucketName())){
                if (minioUtil.removeBucket(removeBucketRequestDto.getBucketName())){
                    return removeBucket_initReturn(removeBucketResponseDto,CommonContstant.commonReturn_Code.SUCCESS_CODE,CommonContstant.commonReturn_Msg.SUCCESS_MSG);
                }else{
                    return removeBucket_initReturn(removeBucketResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG);
                }
            }else {
                return removeBucket_initReturn(removeBucketResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + "参数为空");
            }
        }catch (RemoveBucketException e){
            log.debug("删除桶名异常");
            e.printStackTrace();
            return removeBucket_initReturn(removeBucketResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }catch (Exception e){
            log.debug("程序异常");
            e.printStackTrace();
            return removeBucket_initReturn(removeBucketResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }
    }


    /**
     * 通过文件名称上传资源
     * @param uploadObjectRequestDto
     * @return
     */
    @Override
    public UploadObjectResponseDto uploadObjectByFileName(UploadObjectRequestDto uploadObjectRequestDto) {
        UploadObjectResponseDto uploadObjectResponseDto = new UploadObjectResponseDto();
        try{
            if(null != uploadObjectRequestDto && !StringUtils.isEmpty(uploadObjectRequestDto.getBucketName())
                    && !StringUtils.isEmpty(uploadObjectRequestDto.getObjectName()) && !StringUtils.isEmpty(uploadObjectRequestDto.getFilePath())){
                minioUtil.getInstance();
                if (minioUtil.putObject(uploadObjectRequestDto.getBucketName(),uploadObjectRequestDto.getObjectName(),uploadObjectRequestDto.getFilePath())){
                    return uploadObjectByFileName_initReturn(uploadObjectResponseDto,CommonContstant.commonReturn_Code.SUCCESS_CODE,CommonContstant.commonReturn_Msg.SUCCESS_MSG);
                }else{
                    return uploadObjectByFileName_initReturn(uploadObjectResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG);
                }
            }else{
                return uploadObjectByFileName_initReturn(uploadObjectResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + "参数为空");
            }
        }catch (PutObjectException e){
            log.debug("上传异常");
            e.printStackTrace();
            return uploadObjectByFileName_initReturn(uploadObjectResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }catch (Exception e){
            log.debug("程序异常");
            e.printStackTrace();
            return uploadObjectByFileName_initReturn(uploadObjectResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }
    }

    /**
     * 资源上传-数据流
     * @param uploadObjectRequestDto
     * @return
     */
    @Override
    public UploadObjectByStreamResponseDto uploadObjectByStream(UploadObjectByStreamRequestDto uploadObjectRequestDto) {
        UploadObjectByStreamResponseDto uploadObjectByStreamResponseDto = new UploadObjectByStreamResponseDto();
        try{
            if (null != uploadObjectRequestDto && !StringUtils.isEmpty(uploadObjectRequestDto.getBucketName())
                    && !StringUtils.isEmpty(uploadObjectRequestDto.getObjectName())){
                minioUtil.getInstance();
                if (minioUtil.putObject(uploadObjectRequestDto.getBucketName(),uploadObjectRequestDto.getObjectName(),new FileInputStream(new File("test3.txt")))){
                    return uploadObjectByStream_initReturn(uploadObjectByStreamResponseDto,CommonContstant.commonReturn_Code.SUCCESS_CODE,CommonContstant.commonReturn_Msg.SUCCESS_MSG);
                }else{
                    return uploadObjectByStream_initReturn(uploadObjectByStreamResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG);
                }
            }else{
                return uploadObjectByStream_initReturn(uploadObjectByStreamResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + "参数为空");
            }
        }catch (PutObjectException e){
            log.debug("上传异常");
            e.printStackTrace();
            return uploadObjectByStream_initReturn(uploadObjectByStreamResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }catch (Exception e){
            log.debug("程序出现错误");
            e.printStackTrace();
            return uploadObjectByStream_initReturn(uploadObjectByStreamResponseDto,CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }
    }

    /**
     * addBucket返回报文
     * @param addBucketResponseDto
     * @return
     */
    public AddBucketResponseDto addBucket_initReturn (AddBucketResponseDto addBucketResponseDto,String returnCode,String returnMsg){
        addBucketResponseDto.setReturnCode(returnCode);
        addBucketResponseDto.setReturnMsg(returnMsg);
        return addBucketResponseDto;
    }
    /**
     * removeBucket返回报文
     * @param removeBucketResponseDto
     * @return
     */
    public RemoveBucketResponseDto removeBucket_initReturn (RemoveBucketResponseDto removeBucketResponseDto,String returnCode,String returnMsg){
        removeBucketResponseDto.setReturnCode(returnCode);
        removeBucketResponseDto.setReturnMsg(returnMsg);
        return removeBucketResponseDto;
    }

    /**
     * uploadObjectByFileName返回报文
     * @param uploadObjectResponseDto
     * @param returnCode
     * @param returnMsg
     * @return
     */
    public UploadObjectResponseDto uploadObjectByFileName_initReturn (UploadObjectResponseDto uploadObjectResponseDto,String returnCode,String returnMsg){
        uploadObjectResponseDto.setReturnCode(returnCode);
        uploadObjectResponseDto.setReturnMsg(returnMsg);
        return uploadObjectResponseDto;
    }

    /**
     * uploadObjectByStream返回报文
     * @param uploadObjectByStreamResponseDto
     * @param returnCode
     * @param returnMsg
     * @return
     */
    public UploadObjectByStreamResponseDto uploadObjectByStream_initReturn (UploadObjectByStreamResponseDto uploadObjectByStreamResponseDto,String returnCode,String returnMsg){
        uploadObjectByStreamResponseDto.setReturnCode(returnCode);
        uploadObjectByStreamResponseDto.setReturnMsg(returnMsg);
        return uploadObjectByStreamResponseDto;
    }
}
