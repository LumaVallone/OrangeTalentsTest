package com.orangetalents3.orangetalents3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents3.orangetalents3.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>  {}


