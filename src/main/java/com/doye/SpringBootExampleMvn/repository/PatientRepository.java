package com.doye.SpringBootExampleMvn.repository;

import com.doye.SpringBootExampleMvn.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
