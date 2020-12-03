package com.zy.test_redis_cluster.Repository;

import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;

import java.util.List;

public interface EmployeeExtRepository {
    List<SearchEmployeeResponseDto> searchEmployee(SearchEmployeeRequestDto searchEmployeeRequestDto);

    FindAndUpdateResponseDto findEmployeeById(FindAndUpdateRequestDto findAndUpdateRequestDto);
}
