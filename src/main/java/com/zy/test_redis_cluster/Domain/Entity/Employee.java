package com.zy.test_redis_cluster.Domain.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Table(name = "employee")
@Entity
public class Employee {
    @Id	//主键id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略
    private Integer id;

    @ApiModelProperty("名字")
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
