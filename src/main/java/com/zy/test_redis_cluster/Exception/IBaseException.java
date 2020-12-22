package com.zy.test_redis_cluster.Exception;

public interface IBaseException {

    String getCode();

    String getMessageKey();

    Object[] getParameters();

    void setCode(String code);

    void setMessageKey(String messageKey);

    void setParameters(Object[] parameters);

}
