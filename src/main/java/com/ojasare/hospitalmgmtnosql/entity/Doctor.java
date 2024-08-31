package com.ojasare.hospitalmgmtnosql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document(collection = "doctors")
public class Doctor extends Employee {
    private String speciality;

    @JsonIgnore
    @DBRef
    private Set<Department> departments;

    @JsonIgnore
    @DBRef
    private Set<Patient> patients;
}
