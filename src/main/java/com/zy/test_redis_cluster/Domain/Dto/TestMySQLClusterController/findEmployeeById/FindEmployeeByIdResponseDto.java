package com.zy.test_redis_cluster.Domain.Dto.TestMySQLClusterController.findEmployeeById;

import io.swagger.annotations.ApiModelProperty;

public class FindEmployeeByIdResponseDto {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "员工名称")
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
