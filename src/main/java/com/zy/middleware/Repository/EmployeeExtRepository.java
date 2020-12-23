package com.zy.middleware.Repository;

import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;

import java.util.List;

public interface EmployeeExtRepository {
    List<SearchEmployeeResponseDto> searchEmployee(SearchEmployeeRequestDto searchEmployeeRequestDto);

    FindAndUpdateResponseDto findEmployeeById(FindAndUpdateRequestDto findAndUpdateRequestDto);
}
