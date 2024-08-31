package com.ojasare.hospitalmgmtnosql.service;

import com.ojasare.hospitalmgmtnosql.entity.Patient;
import org.springframework.transaction.annotation.Transactional;


public interface PatientService {
    @Transactional
    Patient createPatient(Patient patient);

    Patient getPatient(String id);

    Iterable<Patient> getAllPatients();

    Patient updatePatient(String id, Patient patient);
}
