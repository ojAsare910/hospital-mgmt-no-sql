package com.ojasare.hospitalmgmtnosql.repository;

import com.ojasare.hospitalmgmtnosql.entity.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseRepository extends MongoRepository<Nurse, String> {
}
