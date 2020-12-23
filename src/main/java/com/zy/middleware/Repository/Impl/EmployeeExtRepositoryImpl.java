package com.zy.middleware.Repository.Impl;

import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
import com.zy.middleware.Mapper.EmployeeMapper;
import com.zy.middleware.Repository.EmployeeExtRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component
public class EmployeeExtRepositoryImpl implements EmployeeExtRepository {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<SearchEmployeeResponseDto> searchEmployee(SearchEmployeeRequestDto searchEmployeeRequestDto) {
        return employeeMapper.searchEmployee(searchEmployeeRequestDto);
    }

    @Override
    public FindAndUpdateResponseDto findEmployeeById(FindAndUpdateRequestDto findAndUpdateRequestDto) {
        return employeeMapper.findEmployeeById(findAndUpdateRequestDto);
    }
}
