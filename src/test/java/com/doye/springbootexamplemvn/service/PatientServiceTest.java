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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
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
        assertNotNull(patient);
    }

    @Test
    void getPatients() {
        // First: Mock the operation
        when(patientRepository.findAll()).thenReturn(List.of(patient));

        // call the method
        List<Patient> patients = patientService.getPatients();

        // test cases on the method
        assertNotNull(patients);
    }

    @Test
    void updatePatient() {
        // First: mock find operation
        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(patient));

        // Second: mock save operation
        when(patientRepository.save(patient)).thenReturn(patient);

        //call the service
        Patient patientTest = patientService.updatePatient(patientDTO, 1);

        //test cases
        assertNotNull(patientTest);
    }

    @Test
    void deletePatient() {
        // first: mock find operation
        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(patient));

        // second: mock delete operation
        doNothing().when(patientRepository).delete(patient);

        // call the method
        String deleteResponse = patientService.deletePatient(1L);
        String expectedResponse = "Patient has been deleted";

        // test cases
        assertNotNull(deleteResponse);
        assertEquals(expectedResponse, deleteResponse);
    }
}