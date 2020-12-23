package com.zy.middleware.Service;

import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketResponseDto;

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
}
