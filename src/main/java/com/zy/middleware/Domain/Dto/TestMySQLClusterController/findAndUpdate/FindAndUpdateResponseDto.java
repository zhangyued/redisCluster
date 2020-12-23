package com.zy.middleware.Domain.Dto.TestMySQLClusterController.findAndUpdate;

public class FindAndUpdateResponseDto {
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
