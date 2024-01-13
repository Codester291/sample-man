package com.doye.springbootexamplemvn.service;


import com.doye.springbootexamplemvn.dto.PatientDTO;
import com.doye.springbootexamplemvn.model.Patient;
import com.doye.springbootexamplemvn.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create
    public Patient createPatient(PatientDTO patientDTO) {
        // create an instance of Patient
        Patient patient = new Patient();

        // we map necessary fields
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setMiddleName(patientDTO.getMiddleName());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());

        // save the data
        Patient save = patientRepository.save(patient);
        return patientRepository.save(patient);
    }

    // Read
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    // Update
    public Patient updatePatient(PatientDTO patientDTO, long id) {
        // find our Patient
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // update that patient we find
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setMiddleName(patientDTO.getMiddleName());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());

        return patientRepository.save(patient);
    }

    // Delete
    public String deletePatient(long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patientRepository.delete(patient);
        return "Patient has been deleted";
    }
}
