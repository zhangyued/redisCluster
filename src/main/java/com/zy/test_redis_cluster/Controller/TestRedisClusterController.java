package com.zy.test_redis_cluster.Controller;

import com.zy.test_redis_cluster.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueRequestDto;
import com.zy.test_redis_cluster.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueResponseDto;
import com.zy.test_redis_cluster.Service.RedisClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TestRedisClusterController.v1")
@RequestMapping("/redisCluster")
public class TestRedisClusterController{

    @Autowired
    private RedisClusterService redisClusterService;

    @PostMapping("/addRedisKeyAndValue")
    public AddRedisKeyAndValueResponseDto addRedisKeyAndValue(AddRedisKeyAndValueRequestDto addRedisKeyAndValueRequestDto){
        AddRedisKeyAndValueResponseDto addRedisKeyAndValueResponseDto = redisClusterService.addRedisKeyAndValue(addRedisKeyAndValueRequestDto);
        return addRedisKeyAndValueResponseDto;
    }
}
