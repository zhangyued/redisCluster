package com.zy.middleware.Exception.TestMinioController;

import com.zy.middleware.Contstant.TestMinioController_Constant;
import com.zy.middleware.Exception.BaseException;
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
