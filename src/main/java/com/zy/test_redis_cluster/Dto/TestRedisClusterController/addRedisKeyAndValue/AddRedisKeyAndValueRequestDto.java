package com.zy.test_redis_cluster.Dto.TestRedisClusterController.addRedisKeyAndValue;

public class AddRedisKeyAndValueRequestDto {
    private String key;
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
