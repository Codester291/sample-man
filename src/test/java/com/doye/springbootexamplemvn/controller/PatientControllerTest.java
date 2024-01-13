package com.doye.springbootexamplemvn.controller;

import com.doye.springbootexamplemvn.dto.PatientDTO;
import com.doye.springbootexamplemvn.model.Patient;
import com.doye.springbootexamplemvn.service.PatientService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PatientControllerTest {

    MockMvc mockMvc;

    @Mock
    PatientService patientService;

    @InjectMocks
    PatientController patientController;

    PatientDTO patientDTO;

    Gson gson;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();

        patientDTO = new PatientDTO(); // Initialization
        patientDTO.setAge(20);
        patientDTO.setGender('M');
        patientDTO.setFirstName("John");
        patientDTO.setLastName("Gojo");
        patientDTO.setMiddleName("Luffy King of the pirates");

        gson = new Gson();
    }

    // DRY -> Don't Repeat Yourself:>
    @Test
    void createPatient() throws Exception {
        when(patientService.createPatient(patientDTO)).thenReturn(new Patient());
        mockMvc.perform(post("/api/patient/create")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(gson.toJson(patientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getPatients() throws Exception {
        when(patientService.getPatients()).thenReturn(List.of(new Patient()));
        mockMvc.perform(get("/api/patient")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updatePatient() throws Exception {
        System.out.println(gson.toJson(patientDTO));
        when(patientService.updatePatient(patientDTO, 1)).thenReturn(new Patient());
        mockMvc.perform(put("/api/patient/1")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(gson.toJson(patientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deletePatient() throws Exception {
        when(patientService.deletePatient(1)).thenReturn(anyString());
        mockMvc.perform(delete("/api/patient/1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}