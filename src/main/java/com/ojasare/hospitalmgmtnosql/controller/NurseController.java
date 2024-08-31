package com.ojasare.hospitalmgmtnosql.controller;

import com.ojasare.hospitalmgmtnosql.dto.NurseDTO;
import com.ojasare.hospitalmgmtnosql.entity.Nurse;
import com.ojasare.hospitalmgmtnosql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nurse")
@RequiredArgsConstructor
public class NurseController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Nurse> createNurse(@RequestBody NurseDTO nurseDTO) {
        Nurse createdNurse = employeeService.createNurse(nurseDTO);
        return ResponseEntity.ok(createdNurse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable String id) {
        Nurse nurse = employeeService.getNurseById(id);
        return ResponseEntity.ok(nurse);
    }

    // Update a Nurse
    @PutMapping("/update/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable String id, @RequestBody NurseDTO nurseDTO) {
        Nurse updatedNurse = employeeService.updateNurse(id, nurseDTO);
        return ResponseEntity.ok(updatedNurse);
    }

}
