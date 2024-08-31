package com.ojasare.hospitalmgmtnosql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO extends EmployeeDTO {
    private String speciality;
}