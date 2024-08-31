package com.ojasare.hospitalmgmtnosql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash("Patient")
public class Patient implements Serializable {
    @Id
    private String id;

    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
    private String diagnosis;
    private String doctorId;
    private String hospitalisationId;
}