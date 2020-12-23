package com.zy.middleware.Exception.TestMinioController;

import com.zy.middleware.Contstant.TestMinioController_Constant;
import com.zy.middleware.Exception.BaseException;
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
