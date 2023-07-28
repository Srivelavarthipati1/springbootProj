package com.mongodb.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StuRepo extends MongoRepository<student, Integer> {

    void deleteById(Integer id);

}
