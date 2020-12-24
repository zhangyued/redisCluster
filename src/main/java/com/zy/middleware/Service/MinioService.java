package com.zy.middleware.Service;

import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObject.UploadObjectRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObject.UploadObjectResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObjectByStream.UploadObjectByStreamRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.uploadObjectByStream.UploadObjectByStreamResponseDto;

public interface MinioService {
    /**
     * 增加捅名
     * @param addBucketRequestDto
     * @return
     */
    AddBucketResponseDto addBucket(AddBucketRequestDto addBucketRequestDto);

    /**
     * 删除桶名
     * @param removeBucketRequestDto
     * @return
     */
    RemoveBucketResponseDto removeBucket(RemoveBucketRequestDto removeBucketRequestDto);

    /**
     * 上传资源-文件名称
     * @param uploadObjectRequestDto
     * @return
     */
    UploadObjectResponseDto uploadObjectByFileName(UploadObjectRequestDto uploadObjectRequestDto);

    /**
     * 上传资源-数据流
     * @param uploadObjectRequestDto
     * @return
     */
    UploadObjectByStreamResponseDto uploadObjectByStream(UploadObjectByStreamRequestDto uploadObjectRequestDto);
}
