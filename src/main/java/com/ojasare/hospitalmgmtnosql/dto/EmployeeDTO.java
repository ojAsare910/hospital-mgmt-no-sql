package com.ojasare.hospitalmgmtnosql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
}
