package com.zy.test_redis_cluster.Controller;

import com.alibaba.fastjson.JSON;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeResponseDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdResponseDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
import com.zy.test_redis_cluster.Repository.EmployeeRepository;
import com.zy.test_redis_cluster.Service.MySQLClusterService;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("TestMySQLClusterController.v1")
@RequestMapping("/mysqlCluster")
public class TestMySQLClusterController {

    private static final Logger log = LoggerFactory.getLogger(TestMySQLClusterController.class);
    @Autowired
    private MySQLClusterService mySQLClusterService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @ApiModelProperty(value = "员工信息查询接口")
    @PostMapping("/searchEmployee")
    public List<SearchEmployeeResponseDto> searchEmployee(@RequestBody SearchEmployeeRequestDto searchEmployeeRequestDto){
        log.debug("请求dto：" + searchEmployeeRequestDto);
        List<SearchEmployeeResponseDto> searchEmployeeResponseDtoList = mySQLClusterService.searchEmployee(searchEmployeeRequestDto);
        log.debug("响应dto：" + JSON.toJSONString(searchEmployeeResponseDtoList));
        return searchEmployeeResponseDtoList;
    }

    @ApiModelProperty(value = "员工信息新增接口")
    @PostMapping("/addEmployee")
    public AddEmployeeResponseDto addEmployee(@RequestBody AddEmployeeRequestDto addEmployeeRequestDto){
        log.debug("请求dto：" + addEmployeeRequestDto);
        AddEmployeeResponseDto addEmployeeResponseDto = mySQLClusterService.addEmployee(addEmployeeRequestDto);
        log.debug("响应dto：" + JSON.toJSONString(addEmployeeResponseDto));
        return addEmployeeResponseDto;
    }

    @ApiModelProperty(value = "根据id查")
    @GetMapping("/findById")
    public FindEmployeeByIdResponseDto findEmployeeById(FindEmployeeByIdRequestDto findEmployeeByIdRequestDto){
        log.debug("请求dto：" + findEmployeeByIdRequestDto);
        FindEmployeeByIdResponseDto findEmployeeByIdResponseDto = mySQLClusterService.findEmployeeById(findEmployeeByIdRequestDto);
        log.debug("响应dto：" + JSON.toJSONString(findEmployeeByIdResponseDto));
        return findEmployeeByIdResponseDto;
    }

    @ApiModelProperty(value = "查和更新")
    @GetMapping("/findAndUpdate")
    public FindAndUpdateResponseDto findAndUpdate(FindAndUpdateRequestDto findAndUpdateRequestDto){
        log.debug("请求dto：" + findAndUpdateRequestDto);
        FindAndUpdateResponseDto findAndUpdateResponseDto = mySQLClusterService.findAndUpdate(findAndUpdateRequestDto);
        log.debug("响应dto：" + JSON.toJSONString(findAndUpdateResponseDto));
        return findAndUpdateResponseDto;
    }
}
