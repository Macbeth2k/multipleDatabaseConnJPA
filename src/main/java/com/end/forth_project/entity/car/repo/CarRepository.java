package com.end.forth_project.entity.car.repo;

import com.end.forth_project.entity.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Override
    Optional<Car> findById(Long aLong);
}