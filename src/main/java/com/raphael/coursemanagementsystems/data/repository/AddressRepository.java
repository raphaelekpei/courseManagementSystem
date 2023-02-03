package com.raphael.coursemanagementsystems.data.repository;

import com.raphael.coursemanagementsystems.data.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AddressRepository extends MongoRepository<Address, String> {
}
