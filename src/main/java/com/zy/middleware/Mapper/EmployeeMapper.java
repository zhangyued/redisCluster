package com.zy.middleware.Mapper;

import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate.FindAndUpdateResponseDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeRequestDto;
import com.zy.middleware.Domain.Dto.TestMySQLClusterController.searchEmployee.SearchEmployeeResponseDto;
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

    /**
     * 查询员工
     * @param findAndUpdateRequestDto
     * @return
     */
    FindAndUpdateResponseDto findEmployeeById(@Param("findAndUpdateRequestDto")FindAndUpdateRequestDto findAndUpdateRequestDto);
}
