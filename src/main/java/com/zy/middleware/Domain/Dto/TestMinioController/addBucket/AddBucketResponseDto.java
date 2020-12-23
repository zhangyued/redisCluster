package com.zy.middleware.Domain.Dto.TestMinioController.addBucket;

import io.swagger.annotations.ApiModelProperty;

public class AddBucketResponseDto {

    @ApiModelProperty(value = "返回标识")
    private String returnCode;

    @ApiModelProperty(value = "返回信息")
    private String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
