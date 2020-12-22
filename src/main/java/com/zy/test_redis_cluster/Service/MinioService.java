package com.zy.test_redis_cluster.Service;

import com.zy.test_redis_cluster.Domain.Dto.TestMinioController.addBucket.AddBucketRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMinioController.addBucket.AddBucketResponseDto;

public interface MinioService {
    /**
     * 增加捅名
     * @param addBucketRequestDto
     * @return
     */
    AddBucketResponseDto addBucket(AddBucketRequestDto addBucketRequestDto);
}
