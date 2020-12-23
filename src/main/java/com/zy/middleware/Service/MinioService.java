package com.zy.middleware.Service;

import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.AddBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.AddBucketResponseDto;

public interface MinioService {
    /**
     * 增加捅名
     * @param addBucketRequestDto
     * @return
     */
    AddBucketResponseDto addBucket(AddBucketRequestDto addBucketRequestDto);
}
