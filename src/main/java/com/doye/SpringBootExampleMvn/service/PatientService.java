package com.doye.SpringBootExampleMvn.service;


import com.doye.SpringBootExampleMvn.dto.PatientDTO;
import com.doye.SpringBootExampleMvn.model.Patient;
import com.doye.SpringBootExampleMvn.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create
    public Object createPatient(PatientDTO patientDTO) {
        // create an instance of Patient
        Patient patient = new Patient();

        // we map necessary fields
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setMiddleName(patientDTO.getMiddleName());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());

        // save the data
        return patientRepository.save(patient);
    }

    // Read
    public Object getPatients() {
        return patientRepository.findAll();
    }

    // Update
    public Object updatePatient(PatientDTO patientDTO, long id) {
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
    public Object deletePatient(long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patientRepository.delete(patient);
        return "Patient has been deleted";
    }
}
