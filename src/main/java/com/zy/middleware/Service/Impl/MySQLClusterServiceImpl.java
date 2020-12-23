package com.zy.middleware.Service.Impl;

import com.zy.middleware.Contstant.TestMySQLClusterController_Constant;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
import com.zy.middleware.Domain.Entity.Employee;
import com.zy.middleware.Repository.EmployeeExtRepository;
import com.zy.middleware.Repository.EmployeeRepository;
import com.zy.middleware.Service.MySQLClusterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public FindAndUpdateResponseDto findAndUpdate(FindAndUpdateRequestDto findAndUpdateRequestDto) {
        FindAndUpdateResponseDto findAndUpdateResponseDto =  employeeExtRepository.findEmployeeById(findAndUpdateRequestDto);
        Employee employeeForUpdate = new Employee();
        BeanUtils.copyProperties(findAndUpdateResponseDto,employeeForUpdate);
        employeeForUpdate.setEmployeeName("小花");
        Employee employee = employeeRepository.saveAndFlush(employeeForUpdate);
        FindAndUpdateResponseDto findAndUpdateResponseDto2 =  employeeExtRepository.findEmployeeById(findAndUpdateRequestDto);
        return findAndUpdateResponseDto2;
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
