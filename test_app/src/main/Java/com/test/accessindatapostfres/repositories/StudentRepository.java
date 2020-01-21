package com.test.accessindatapostfres.repositories;

import com.test.accessindatapostfres.entities.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Integer> {

}
