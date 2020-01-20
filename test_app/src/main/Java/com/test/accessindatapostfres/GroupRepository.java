package com.test.accessindatapostfres;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    Group findByName(String name);
}
