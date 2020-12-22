package com.zy.test_redis_cluster.Exception.TestMinioController;

import com.zy.test_redis_cluster.Contstant.TestMinioController_Constant;
import com.zy.test_redis_cluster.Exception.BaseException;
import org.springframework.util.StringUtils;

/**
 * MinioClient初始化异常类
 */
public class MinioClientInitException extends BaseException {

    public MinioClientInitException(String code, String messageKey, Object[] parameters) {
        super(StringUtils.isEmpty(code) ? TestMinioController_Constant.addBucketName_Code.minioClientInit_Code : code,
                StringUtils.isEmpty(messageKey) ? TestMinioController_Constant.addBucketName_Msg.minioClientInit_Msg :
                        TestMinioController_Constant.addBucketName_Msg.minioClientInit_Msg + ":" + messageKey, parameters);
    }

    public MinioClientInitException(String messageKey) {
        super(messageKey);
    }
}
