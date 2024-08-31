package com.ojasare.hospitalmgmtnosql.service;

import com.ojasare.hospitalmgmtnosql.dto.DepartmentDTO;
import com.ojasare.hospitalmgmtnosql.entity.Department;

public interface DepartmentService {
    Department getDepartmentById(String id);

    Department createDepartment(DepartmentDTO departmentDTO);
}
