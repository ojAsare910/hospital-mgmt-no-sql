package com.ojasare.hospitalmgmtnosql.repository;

import com.ojasare.hospitalmgmtnosql.dto.DoctorDTO;
import com.ojasare.hospitalmgmtnosql.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

    @Query(value = "{ 'speciality' : ?0 }", fields = "{'id': 1,'firstName': 1 ,'surname': 1, 'address': 1, 'telephoneNumber' : 1, 'speciality': 1}")
    List<DoctorDTO> findingBySpeciality(String speciality);
}
