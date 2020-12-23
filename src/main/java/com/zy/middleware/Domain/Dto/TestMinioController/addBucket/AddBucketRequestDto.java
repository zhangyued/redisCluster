package com.zy.middleware.Domain.Dto.TestMinioController.addBucket;


import io.swagger.annotations.ApiModelProperty;

public class AddBucketRequestDto {

    @ApiModelProperty(value = "桶名")
    private String bucketName;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
