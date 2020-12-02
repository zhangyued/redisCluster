package com.zy.test_redis_cluster.Service;

import com.zy.test_redis_cluster.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueResponseDto;

public interface RedisClusterService {
    /**
     * 增加redis键值对
     * @param addRedisKeyAndValueRequestDto
     * @return
     */
    AddRedisKeyAndValueResponseDto addRedisKeyAndValue(AddRedisKeyAndValueRequestDto addRedisKeyAndValueRequestDto);
}
