package com.doye.springbootexamplemvn.repository;

import com.doye.springbootexamplemvn.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
