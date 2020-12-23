package com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket;

import io.swagger.annotations.ApiModelProperty;

public class RemoveBucketRequestDto {

    @ApiModelProperty(value = "桶名")
    private String bucketName;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
