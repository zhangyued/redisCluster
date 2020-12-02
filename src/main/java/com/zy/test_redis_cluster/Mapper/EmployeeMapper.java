package com.zy.test_redis_cluster.Mapper;

import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    /**
     * 查询员工
     * @param searchEmployeeRequestDto
     * @return
     */
    List<SearchEmployeeResponseDto> searchEmployee(@Param("searchEmployeeRequestDto")SearchEmployeeRequestDto searchEmployeeRequestDto);
}
