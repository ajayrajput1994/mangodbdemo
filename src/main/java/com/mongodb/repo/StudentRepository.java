package com.mongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.model.Student;


public interface StudentRepository extends MongoRepository<Student, Long> {

}
