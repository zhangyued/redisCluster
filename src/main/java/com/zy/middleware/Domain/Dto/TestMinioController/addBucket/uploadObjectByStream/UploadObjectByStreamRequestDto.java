package com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObjectByStream;

public class UploadObjectByStreamRequestDto {

    private String bucketName;

    private String objectName;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
