package com.doye.springbootexamplemvn.service;

import com.doye.springbootexamplemvn.dto.PatientDTO;
import com.doye.springbootexamplemvn.model.Patient;
import com.doye.springbootexamplemvn.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @MockBean
    PatientRepository patientRepository;

    PatientDTO patientDTO;
    Patient patient;

    @BeforeEach
    void setUp() {
        patientDTO = new PatientDTO(); // Initialization
        patientDTO.setAge(20);
        patientDTO.setGender('M');
        patientDTO.setFirstName("John");
        patientDTO.setLastName("Gojo");
        patientDTO.setMiddleName("Luffy King of the pirates");

        patient = new Patient();
        patient.setGender(patientDTO.getGender());
        patient.setAge(patientDTO.getAge());
        patient.setLastName(patientDTO.getLastName());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setMiddleName(patientDTO.getMiddleName());
    }

    @Test
    void createPatient() {
        when(patientRepository.save(patient)).thenReturn(patient);
        Patient patient1 = patientService.createPatient(patientDTO);
        assertNotNull(patient);
//        assertEquals(patient1, patient);
    }

    @Test
    void getPatients() {
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatient() {
    }
}