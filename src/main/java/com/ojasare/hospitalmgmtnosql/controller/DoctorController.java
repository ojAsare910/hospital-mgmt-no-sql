package com.ojasare.hospitalmgmtnosql.controller;

import com.ojasare.hospitalmgmtnosql.dto.DoctorDTO;
import com.ojasare.hospitalmgmtnosql.entity.Doctor;
import com.ojasare.hospitalmgmtnosql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return new ResponseEntity<>(employeeService.createDoctor(doctorDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        Doctor doctor = employeeService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/speciality")
    public ResponseEntity<List<DoctorDTO>> getDoctorsBySpeciality(@RequestParam String speciality) {
        return ResponseEntity.ok(employeeService.findDoctorsBySpeciality(speciality));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String id, @RequestBody DoctorDTO doctorDTO) {
        Doctor updatedDoctor = employeeService.updateDoctor(id, doctorDTO);
        return ResponseEntity.ok(updatedDoctor);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = employeeService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

}

