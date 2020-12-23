package com.zy.test_redis_cluster.Exception.TestMinioController;

import com.zy.test_redis_cluster.Contstant.TestMinioController_Constant;
import com.zy.test_redis_cluster.Exception.BaseException;
import org.springframework.util.StringUtils;

public class RemoveBucketException extends BaseException {
    public RemoveBucketException(String code, String messageKey, Object[] parameters) {
        super(StringUtils.isEmpty(code) ? TestMinioController_Constant.addBucketName_Code.removeBucket_Code : code,
                StringUtils.isEmpty(messageKey) ? TestMinioController_Constant.addBucketName_Msg.removeBucket_Msg :
                        TestMinioController_Constant.addBucketName_Msg.removeBucket_Msg + ":" + messageKey, parameters);
    }

    public RemoveBucketException(String messageKey) {
        super(messageKey);
    }
}
