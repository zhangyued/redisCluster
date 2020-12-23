package com.zy.test_redis_cluster.Exception.TestMinioController;

import com.zy.test_redis_cluster.Contstant.TestMinioController_Constant;
import com.zy.test_redis_cluster.Exception.BaseException;
import org.springframework.util.StringUtils;

public class PutObjectException extends BaseException {
    public PutObjectException(String code, String messageKey, Object[] parameters) {
        super(StringUtils.isEmpty(code) ? TestMinioController_Constant.addBucketName_Code.putObject_Code : code,
                StringUtils.isEmpty(messageKey) ? TestMinioController_Constant.addBucketName_Msg.putObject_Msg :
                        TestMinioController_Constant.addBucketName_Msg.putObject_Msg + ":" + messageKey, parameters);
    }

    public PutObjectException(String messageKey) {
        super(messageKey);
    }
}
