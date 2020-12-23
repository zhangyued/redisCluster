package com.zy.middleware.Exception;

public interface IBaseException {

    String getCode();

    String getMessageKey();

    Object[] getParameters();

    void setCode(String code);

    void setMessageKey(String messageKey);

    void setParameters(Object[] parameters);

}
