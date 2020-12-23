package com.zy.middleware.Service;

import com.zy.middleware.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueRequestDto;
import com.zy.middleware.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueResponseDto;

public interface RedisClusterService {
    /**
     * 增加redis键值对
     * @param addRedisKeyAndValueRequestDto
     * @return
     */
    AddRedisKeyAndValueResponseDto addRedisKeyAndValue(AddRedisKeyAndValueRequestDto addRedisKeyAndValueRequestDto);
}
