package com.zy.middleware.Controller;

import com.alibaba.fastjson.JSON;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.addBucket.AddBucketResponseDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketRequestDto;
import com.zy.middleware.Domain.Dto.TestMinioController.addBucket.removeBucket.RemoveBucketResponseDto;
import com.zy.middleware.Service.MinioService;
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
public class TestMinioController {

    private static final Logger log = LoggerFactory.getLogger(TestMinioController.class);

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

    @ApiModelProperty(value = "删除桶名")
    @PostMapping("/removeBucket")
    public RemoveBucketResponseDto removeBucket(@RequestBody RemoveBucketRequestDto removeBucketRequestDto){
        log.debug("请求dto：" + removeBucketRequestDto);
        RemoveBucketResponseDto removeBucketResponseDto = minioService.removeBucket(removeBucketRequestDto);
        log.debug("响应dto：" + JSON.toJSONString(removeBucketResponseDto));
        return removeBucketResponseDto;
    }

}
