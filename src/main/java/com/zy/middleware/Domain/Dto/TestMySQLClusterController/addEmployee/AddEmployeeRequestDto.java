package com.zy.middleware.Domain.Dto.TestMySQLClusterController.addEmployee;

import io.swagger.annotations.ApiModelProperty;

public class AddEmployeeRequestDto {
    @ApiModelProperty(value = "员工名称")
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
