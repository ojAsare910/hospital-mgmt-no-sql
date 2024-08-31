package com.ojasare.hospitalmgmtnosql.service.impl;

import com.ojasare.hospitalmgmtnosql.entity.Patient;
import com.ojasare.hospitalmgmtnosql.repository.PatientRepository;
import com.ojasare.hospitalmgmtnosql.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    @Transactional
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(String id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    @Override
    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Transactional
    @Override
    public Patient updatePatient(String id, Patient patient) {
        Patient updatePatient =  patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        updatePatient.setFirstName(patient.getFirstName());
        updatePatient.setSurname(patient.getSurname());
        updatePatient.setAddress(patient.getAddress());
        updatePatient.setTelephoneNumber(patient.getTelephoneNumber());
        updatePatient.setDiagnosis(patient.getDiagnosis());
        updatePatient.setDoctorId(patient.getDoctorId());
        updatePatient.setHospitalisationId(patient.getHospitalisationId());
        return patientRepository.save(updatePatient);
    }
}