package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Transactional
    Optional<Location> findByTown(String town);
}
