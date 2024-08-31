package com.ojasare.hospitalmgmtnosql.repository;

import com.ojasare.hospitalmgmtnosql.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
