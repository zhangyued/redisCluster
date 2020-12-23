package com.zy.middleware.Service;

import com.zy.middleware.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.addEmployee.AddEmployeeResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findEmployeeById.FindEmployeeByIdResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;

import java.util.List;

public interface MySQLClusterService {
    List<SearchEmployeeResponseDto> searchEmployee(SearchEmployeeRequestDto searchEmployeeRequestDto);

    AddEmployeeResponseDto addEmployee(AddEmployeeRequestDto addEmployeeRequestDto);

    FindEmployeeByIdResponseDto findEmployeeById(FindEmployeeByIdRequestDto findEmployeeByIdRequestDto);

    FindAndUpdateResponseDto findAndUpdate(FindAndUpdateRequestDto findAndUpdateRequestDto);
}
