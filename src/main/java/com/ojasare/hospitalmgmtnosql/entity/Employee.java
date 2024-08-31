package com.ojasare.hospitalmgmtnosql.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document
public abstract class Employee {
    @Id
    private String id;

    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
}