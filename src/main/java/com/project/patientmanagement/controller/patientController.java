package com.project.patientmanagement.controller;


import com.project.patientmanagement.Service.PatientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("//patients")
public class patientController{

    private final PatientService patientService;

    public patientController(PatientService patientService) {
        this.patientService = patientService;
    }
}
