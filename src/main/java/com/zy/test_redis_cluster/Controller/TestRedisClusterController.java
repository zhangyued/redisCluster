package com.zy.test_redis_cluster.Controller;

import com.zy.test_redis_cluster.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueResponseDto;
import com.zy.test_redis_cluster.Service.RedisClusterService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TestRedisClusterController.v1")
@RequestMapping("/redisCluster")
public class TestRedisClusterController{

    @Autowired
    private RedisClusterService redisClusterService;

    @ApiModelProperty(value = "redis增加键值对操作")
    @PostMapping("/addRedisKeyAndValue")
    public AddRedisKeyAndValueResponseDto addRedisKeyAndValue(AddRedisKeyAndValueRequestDto addRedisKeyAndValueRequestDto){
        AddRedisKeyAndValueResponseDto addRedisKeyAndValueResponseDto = redisClusterService.addRedisKeyAndValue(addRedisKeyAndValueRequestDto);
        return addRedisKeyAndValueResponseDto;
    }
}
