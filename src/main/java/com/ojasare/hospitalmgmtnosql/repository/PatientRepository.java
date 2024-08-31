package com.ojasare.hospitalmgmtnosql.repository;

import com.ojasare.hospitalmgmtnosql.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {
}
