package com.zy.test_redis_cluster.Controller;

import com.alibaba.fastjson.JSON;
import com.zy.test_redis_cluster.Domain.Dto.TestMinioController.addBucket.AddBucketRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMinioController.addBucket.AddBucketResponseDto;
import com.zy.test_redis_cluster.Service.MinioService;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TestMinipController.v1")
@RequestMapping("/minio")
public class TestMinipController {

    private static final Logger log = LoggerFactory.getLogger(TestMinipController.class);

    @Autowired
    private MinioService minioService;

    @ApiModelProperty(value = "增加桶名")
    @PostMapping("/addBucketName")
    public AddBucketResponseDto addBucket(@RequestBody AddBucketRequestDto addBucketRequestDto){
        log.debug("请求dto：" + addBucketRequestDto);
        AddBucketResponseDto addBucketResponseDto = minioService.addBucket(addBucketRequestDto);
        log.debug("响应dto：" + JSON.toJSONString(addBucketResponseDto));
        return addBucketResponseDto;
    }

}
