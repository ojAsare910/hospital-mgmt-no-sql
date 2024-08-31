package com.ojasare.hospitalmgmtnosql.service.impl;

import com.ojasare.hospitalmgmtnosql.dto.DoctorDTO;
import com.ojasare.hospitalmgmtnosql.dto.NurseDTO;
import com.ojasare.hospitalmgmtnosql.entity.Department;
import com.ojasare.hospitalmgmtnosql.entity.Doctor;
import com.ojasare.hospitalmgmtnosql.entity.Nurse;
import com.ojasare.hospitalmgmtnosql.repository.DoctorRepository;
import com.ojasare.hospitalmgmtnosql.repository.NurseRepository;
import com.ojasare.hospitalmgmtnosql.service.DepartmentService;
import com.ojasare.hospitalmgmtnosql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final DepartmentService departmentService;

    @Transactional
    @Override
    public Doctor createDoctor(DoctorDTO doctorDTO) {
        if (doctorDTO.getSpeciality().isBlank() || doctorDTO.getSpeciality().isEmpty()
                || doctorDTO.getFirstName().isEmpty() || doctorDTO.getFirstName().isBlank()
        ) {
            throw new IllegalArgumentException("These fields cannot be empty!");
        }
        Doctor doctor = Doctor.builder()
                .firstName(doctorDTO.getFirstName())
                .surname(doctorDTO.getSurname())
                .address(doctorDTO.getAddress())
                .telephoneNumber(doctorDTO.getTelephoneNumber())
                .speciality(doctorDTO.getSpeciality())
                .build();
        return doctorRepository.save(doctor);
    }

    @Transactional
    @Override
    public Doctor updateDoctor(String doctorId, DoctorDTO doctorDTO) {
        return doctorRepository.findById(doctorId).map(doctor -> {
            doctor.setFirstName(doctorDTO.getFirstName());
            doctor.setSurname(doctorDTO.getSurname());
            doctor.setAddress(doctorDTO.getAddress());
            doctor.setTelephoneNumber(doctorDTO.getTelephoneNumber());
            doctor.setSpeciality(doctorDTO.getSpeciality());
            return doctorRepository.save(doctor);
        }).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
    }

    @Cacheable(value = "doctorsBySpeciality", key = "#speciality", unless = "#result.isEmpty()")
    @Override
    public List<DoctorDTO> findDoctorsBySpeciality(String speciality) {
        return doctorRepository.findingBySpeciality(speciality);
    }

    @Transactional
    @Override
    public Nurse createNurse(NurseDTO nurseDTO) {
        Department department = departmentService.getDepartmentById(nurseDTO.getDepartmentId());
        Nurse nurse = Nurse.builder()
                .firstName(nurseDTO.getFirstName())
                .surname(nurseDTO.getSurname())
                .address(nurseDTO.getAddress())
                .telephoneNumber(nurseDTO.getTelephoneNumber())
                .department(department)
                .salary(nurseDTO.getSalary())
                .rotation(nurseDTO.getRotation())
                .build();
        return nurseRepository.save(nurse);
    }

    @Override
    public Nurse updateNurse(String nurseId, NurseDTO nurseDTO) {
        return nurseRepository.findById(nurseId).map(nurse -> {
            nurse.setFirstName(nurseDTO.getFirstName());
            nurse.setSurname(nurseDTO.getSurname());
            nurse.setAddress(nurseDTO.getAddress());
            nurse.setTelephoneNumber(nurseDTO.getTelephoneNumber());
            nurse.setDepartment(departmentService.getDepartmentById(nurseDTO.getDepartmentId()));
            nurse.setSalary(nurseDTO.getSalary());
            nurse.setRotation(nurseDTO.getRotation());
            return nurseRepository.save(nurse);
        }).orElseThrow(() -> new IllegalArgumentException("Nurse not found"));
    }

    @Override
    public Doctor getDoctorById(String doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Nurse getNurseById(String nurseId) {
        return nurseRepository.findById(nurseId)
                .orElseThrow(() -> new IllegalArgumentException("Nurse not found"));
    }
}
