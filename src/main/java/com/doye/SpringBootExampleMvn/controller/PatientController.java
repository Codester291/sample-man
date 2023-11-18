package com.doye.SpringBootExampleMvn.controller;

import com.doye.SpringBootExampleMvn.dto.PatientDTO;
import com.doye.SpringBootExampleMvn.service.PatientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    // CRUD Create Read Update Delete
    //POST
    @PostMapping(value = "/patient/create")
    public Object createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    //GET
    @GetMapping("/patient")
    public Object getPatients() {
        return patientService.getPatients();
    }

    //PUT
    @PutMapping("/patient/{id}")
    public Object updatePatient(@RequestBody PatientDTO patientDTO, @PathVariable long id) {
        return patientService.updatePatient(patientDTO, id);
    }

    //DELETE
    @DeleteMapping("/patient/{id}")
    public Object deletePatient(@PathVariable long id) {
        return patientService.deletePatient(id);
    }
}
