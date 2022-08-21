package com.infoshareacademy.repository;

import com.infoshareacademy.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByTown(String town);

}
