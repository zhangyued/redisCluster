package com.zy.test_redis_cluster.Exception.TestMinioController;

import com.zy.test_redis_cluster.Contstant.TestMinioController_Constant;
import com.zy.test_redis_cluster.Exception.BaseException;
import org.springframework.util.StringUtils;

/**
 * 桶创建异常
 */
public class BucketMakeException extends BaseException {

    public BucketMakeException(String code, String messageKey, Object[] parameters) {
        super(StringUtils.isEmpty(code) ? TestMinioController_Constant.addBucketName_Code.bucketMake_Code : code,
                StringUtils.isEmpty(messageKey) ? TestMinioController_Constant.addBucketName_Msg.bucketMake_Msg :
                        TestMinioController_Constant.addBucketName_Msg.bucketMake_Msg + ":" + messageKey, parameters);
    }

    public BucketMakeException(String messageKey) {
        super(messageKey);
    }
}
