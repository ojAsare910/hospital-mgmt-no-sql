package com.ojasare.hospitalmgmtnosql.service.impl;

import com.ojasare.hospitalmgmtnosql.dto.DepartmentDTO;
import com.ojasare.hospitalmgmtnosql.entity.Department;
import com.ojasare.hospitalmgmtnosql.entity.Doctor;
import com.ojasare.hospitalmgmtnosql.repository.DepartmentRepository;
import com.ojasare.hospitalmgmtnosql.repository.DoctorRepository;
import com.ojasare.hospitalmgmtnosql.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Invalid department Id"));
    }

    @Override
    public Department createDepartment(DepartmentDTO departmentDTO) {
        Doctor doctor = doctorRepository.findById(departmentDTO.getDirectorId()).orElseThrow(() -> new IllegalArgumentException("Invalid Director Id"));
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .code(departmentDTO.getCode())
                .director(doctor)
                .building(departmentDTO.getBuilding())
                .build();
        return departmentRepository.save(department);
    }
}