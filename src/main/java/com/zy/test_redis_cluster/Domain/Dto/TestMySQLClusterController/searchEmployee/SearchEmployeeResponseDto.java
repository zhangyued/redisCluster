package com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee;

import java.util.List;

/**
 * SearchEmployee响应dto
 */
public class SearchEmployeeResponseDto {
    private Integer id;

    private String employeeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
