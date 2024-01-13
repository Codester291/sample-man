package com.doye.springbootexamplemvn.controller;

import com.doye.springbootexamplemvn.dto.PatientDTO;
import com.doye.springbootexamplemvn.model.Patient;
import com.doye.springbootexamplemvn.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    //Dependency Injection
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping(value = "/patient/create")
    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    //GET
    @GetMapping("/patient")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    //PUT
    @PutMapping("/patient/{id}")
    public Patient updatePatient(@RequestBody PatientDTO patientDTO, @PathVariable long id) {
        return patientService.updatePatient(patientDTO, id);
    }

    //DELETE
    @DeleteMapping("/patient/{id}")
    public String deletePatient(@PathVariable long id) {
        return patientService.deletePatient(id);
    }
}
