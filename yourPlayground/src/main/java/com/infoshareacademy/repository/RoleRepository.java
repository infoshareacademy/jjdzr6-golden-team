package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Transactional
    Optional<Role> findByName(String name);
}
