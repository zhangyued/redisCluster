package com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.searchEmployee;

/**
 * SearchEmployee请求dto
 */
public class SearchEmployeeRequestDto {
    private Long id;

    private String employeeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
