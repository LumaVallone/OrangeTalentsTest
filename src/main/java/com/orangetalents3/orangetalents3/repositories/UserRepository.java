package com.orangetalents3.orangetalents3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents3.orangetalents3.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {}

