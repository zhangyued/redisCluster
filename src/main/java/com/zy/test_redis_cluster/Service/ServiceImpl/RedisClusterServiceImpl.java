package com.zy.test_redis_cluster.Service.ServiceImpl;

import com.zy.test_redis_cluster.Contstant.TestRedisClusterController_Contstant;
import com.zy.test_redis_cluster.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueRequestDto;
import com.zy.test_redis_cluster.Dto.TestRedisClusterController.addRedisKeyAndValue.AddRedisKeyAndValueResponseDto;
import com.zy.test_redis_cluster.Service.RedisClusterService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisClusterServiceImpl implements RedisClusterService {

    @Autowired
    private RedisClusterService redisClusterService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public AddRedisKeyAndValueResponseDto addRedisKeyAndValue(AddRedisKeyAndValueRequestDto addRedisKeyAndValueRequestDto) {
        AddRedisKeyAndValueResponseDto addRedisKeyAndValueResponseDto = new AddRedisKeyAndValueResponseDto();
        if(null == addRedisKeyAndValueRequestDto){
            return initReturn(addRedisKeyAndValueResponseDto, TestRedisClusterController_Contstant.addRedisKeyAndValue_Code.Fail_CODE,TestRedisClusterController_Contstant.addRedisKeyAndValue_Msg.Fail_MSG + ":请求空");
        }
        if(StringUtil.isNullOrEmpty(addRedisKeyAndValueRequestDto.getKey()) && StringUtil.isNullOrEmpty(addRedisKeyAndValueRequestDto.getValue())){
            return initReturn(addRedisKeyAndValueResponseDto, TestRedisClusterController_Contstant.addRedisKeyAndValue_Code.Fail_CODE,TestRedisClusterController_Contstant.addRedisKeyAndValue_Msg.Fail_MSG + ":请求内容空");
        }
        try{
            stringRedisTemplate.opsForValue().set(addRedisKeyAndValueRequestDto.getKey(), addRedisKeyAndValueRequestDto.getValue());
            return initReturn(addRedisKeyAndValueResponseDto, TestRedisClusterController_Contstant.addRedisKeyAndValue_Code.SUCCESS_CODE,TestRedisClusterController_Contstant.addRedisKeyAndValue_Msg.SUCCESS_MSG);
        }catch (Exception e){
            e.printStackTrace();
            return initReturn(addRedisKeyAndValueResponseDto, TestRedisClusterController_Contstant.addRedisKeyAndValue_Code.Fail_CODE,TestRedisClusterController_Contstant.addRedisKeyAndValue_Msg.Fail_MSG + ":存储发生异常，" + e.getMessage());
        }
    }

    /**
     * 初始化返回
     * @param addRedisKeyAndValueResponseDto
     * @param returnCode
     * @param returnMsg
     * @return
     */
    public AddRedisKeyAndValueResponseDto initReturn(AddRedisKeyAndValueResponseDto addRedisKeyAndValueResponseDto,String returnCode,String returnMsg){
        addRedisKeyAndValueResponseDto.setReturnCode(returnCode);
        addRedisKeyAndValueResponseDto.setReturnMsg(returnMsg);
        return addRedisKeyAndValueResponseDto;
    }
}
