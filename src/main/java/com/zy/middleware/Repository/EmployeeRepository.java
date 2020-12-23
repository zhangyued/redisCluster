package com.zy.middleware.Repository;

import com.zy.middleware.Domain.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
