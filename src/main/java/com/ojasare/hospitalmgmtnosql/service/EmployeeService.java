package com.ojasare.hospitalmgmtnosql.service;

import com.ojasare.hospitalmgmtnosql.dto.DoctorDTO;
import com.ojasare.hospitalmgmtnosql.dto.NurseDTO;
import com.ojasare.hospitalmgmtnosql.entity.Doctor;
import com.ojasare.hospitalmgmtnosql.entity.Nurse;

import java.util.List;

public interface EmployeeService {
    Doctor createDoctor(DoctorDTO doctorDTO);

    Doctor updateDoctor(String doctorId, DoctorDTO doctorDTO);

    List<DoctorDTO> findDoctorsBySpeciality(String speciality);

    Nurse createNurse(NurseDTO nurseDTO);

    Nurse updateNurse(String nurseId, NurseDTO nurseDTO);

    Doctor getDoctorById(String doctorId);

    List<Doctor> getAllDoctors();

    Nurse getNurseById(String nurseId);
}
