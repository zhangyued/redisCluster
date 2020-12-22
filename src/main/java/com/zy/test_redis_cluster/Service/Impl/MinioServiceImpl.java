package com.zy.test_redis_cluster.Service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.zy.test_redis_cluster.Contstant.CommonContstant;
import com.zy.test_redis_cluster.Domain.Dto.TestMinioController.addBucket.AddBucketRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMinioController.addBucket.AddBucketResponseDto;
import com.zy.test_redis_cluster.Exception.TestMinioController.BucketMakeException;
import com.zy.test_redis_cluster.Exception.TestMinioController.MinioClientInitException;
import com.zy.test_redis_cluster.Service.MinioService;
import com.zy.test_redis_cluster.Util.MinioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinioServiceImpl implements MinioService {

    private static final Logger log = LoggerFactory.getLogger(MinioServiceImpl.class);

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public AddBucketResponseDto addBucket(AddBucketRequestDto addBucketRequestDto) {
        AddBucketResponseDto addBucketResponseDto = new AddBucketResponseDto();
        try{
            minioUtil.getInstance();
            if (!StringUtils.isEmpty(addBucketRequestDto.getBucketName())) {
                if (minioUtil.makeBucket(addBucketRequestDto.getBucketName())){
                    return initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.SUCCESS_CODE,CommonContstant.commonReturn_Msg.SUCCESS_MSG);
                }else{
                    return initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG);
                }
            }else{
                return initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + "桶名为空");
            }
        }catch (MinioClientInitException e){
            log.debug("MinioClient初始化异常");
            return initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }catch (BucketMakeException e){
            log.debug("桶创建异常");
            return initReturn(addBucketResponseDto, CommonContstant.commonReturn_Code.Fail_CODE,CommonContstant.commonReturn_Msg.Fail_MSG + e.getMessage());
        }
    }

    /**
     * 返回报文
     * @param addBucketResponseDto
     * @return
     */
    public AddBucketResponseDto initReturn (AddBucketResponseDto addBucketResponseDto,String returnCode,String returnMsg){
        addBucketResponseDto.setReturnCode(returnCode);
        addBucketResponseDto.setReturnMsg(returnMsg);
        return addBucketResponseDto;
    }
}
