package com.zy.test_redis_cluster.Repository;

import com.zy.test_redis_cluster.Domain.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
