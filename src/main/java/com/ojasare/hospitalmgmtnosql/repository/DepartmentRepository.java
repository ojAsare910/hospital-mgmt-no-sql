package com.ojasare.hospitalmgmtnosql.repository;

import com.ojasare.hospitalmgmtnosql.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
