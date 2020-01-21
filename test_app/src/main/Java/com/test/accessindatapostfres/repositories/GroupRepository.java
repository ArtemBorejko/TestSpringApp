package com.test.accessindatapostfres.repositories;

import com.test.accessindatapostfres.entities.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    Group findByName(String name);
}
