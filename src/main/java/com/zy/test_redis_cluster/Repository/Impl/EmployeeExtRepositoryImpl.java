package com.zy.test_redis_cluster.Repository.Impl;

import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
import com.zy.test_redis_cluster.Mapper.EmployeeMapper;
import com.zy.test_redis_cluster.Repository.EmployeeExtRepository;
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
}
