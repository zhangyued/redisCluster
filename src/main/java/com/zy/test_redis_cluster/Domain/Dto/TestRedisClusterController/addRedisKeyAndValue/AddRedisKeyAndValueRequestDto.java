package com.zy.test_redis_cluster.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * 增加redis键值对请求dto
 */
public class AddRedisKeyAndValueRequestDto {
    @ApiModelProperty(value = "键")
    private String key;

    @ApiModelProperty(value = "值")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
