package com.zy.middleware.Exception;

public abstract class BaseException extends RuntimeException implements IBaseException{

    private static final long serialVersionUID = 1L;

    private String code;

    private String messageKey;

    private Object[] parameters;

    /**
     * 不应该直接实例化,应该定义子类.
     *
     * @param code       异常 code,通常与模块CODE对应
     * @param messageKey 异常消息
     * @param parameters 如果没有参数,可以传 null
     */
    public BaseException(String code, String messageKey, Object[] parameters) {
        super(messageKey);
        this.code = code;
        this.messageKey = messageKey;
        this.parameters = parameters;
    }

    public BaseException(String messageKey) {
        super(messageKey);
        this.messageKey = messageKey;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }

    @Override
    public Object[] getParameters() {
        return parameters;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
