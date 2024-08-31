package com.ojasare.hospitalmgmtnosql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private String id;
    private String name;
    private String code;
    private String building;
    private String directorId;
}
