package com.zy.test_redis_cluster.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * 增加redis键值对响应dto
 */
public class AddRedisKeyAndValueResponseDto {
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
