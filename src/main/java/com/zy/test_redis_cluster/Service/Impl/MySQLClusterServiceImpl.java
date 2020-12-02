package com.zy.test_redis_cluster.Service.Impl;

import com.zy.test_redis_cluster.Contstant.TestMySQLClusterController_Constant;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeResponseDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdResponseDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
import com.zy.test_redis_cluster.Domain.Entity.Employee;
import com.zy.test_redis_cluster.Repository.EmployeeExtRepository;
import com.zy.test_redis_cluster.Repository.EmployeeRepository;
import com.zy.test_redis_cluster.Service.MySQLClusterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MySQLClusterServiceImpl implements MySQLClusterService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeExtRepository employeeExtRepository;

    @Override
    public List<SearchEmployeeResponseDto> searchEmployee(SearchEmployeeRequestDto searchEmployeeRequestDto) {
        return employeeExtRepository.searchEmployee(searchEmployeeRequestDto);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public AddEmployeeResponseDto addEmployee(AddEmployeeRequestDto addEmployeeRequestDto) {
        AddEmployeeResponseDto addEmployeeResponseDto = new AddEmployeeResponseDto();
        Employee employeeForAdd = new Employee();
        BeanUtils.copyProperties(addEmployeeRequestDto,employeeForAdd);
        employeeRepository.save(employeeForAdd);
        return initReturn(addEmployeeResponseDto, TestMySQLClusterController_Constant.addEmployee_Code.SUCCESS_CODE,TestMySQLClusterController_Constant.addEmployee_Msg.SUCCESS_MSG);
    }

    @Override
    public FindEmployeeByIdResponseDto findEmployeeById(FindEmployeeByIdRequestDto findEmployeeByIdRequestDto) {
        FindEmployeeByIdResponseDto findEmployeeByIdResponseDto = new FindEmployeeByIdResponseDto();
        try{
            Employee employee = employeeRepository.findById(findEmployeeByIdRequestDto.getId()).get();
            BeanUtils.copyProperties(employee,findEmployeeByIdResponseDto);
            return findEmployeeByIdResponseDto;
        }catch (Exception e){
            e.printStackTrace();
            return findEmployeeByIdResponseDto;
        }
    }

    /**
     * 返回
     * @param addEmployeeResponseDto
     * @return
     */
    public AddEmployeeResponseDto initReturn (AddEmployeeResponseDto addEmployeeResponseDto,String returnCode,String returnMsg){
        addEmployeeResponseDto.setReturnCode(returnCode);
        addEmployeeResponseDto.setReturnMsg(returnMsg);
        return addEmployeeResponseDto;
    }
}
