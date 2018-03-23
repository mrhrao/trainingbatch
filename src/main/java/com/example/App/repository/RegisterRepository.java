package com.example.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.App.domain.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {




}
