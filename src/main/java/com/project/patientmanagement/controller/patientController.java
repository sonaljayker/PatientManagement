package com.project.patientmanagement.controller;


import com.project.patientmanagement.Service.PatientService;
import com.project.patientmanagement.dto.PatientRequestDTO;
import com.project.patientmanagement.dto.PatientResponseDTO;
import com.project.patientmanagement.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class patientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatient() {
        return ResponseEntity.ok(patientService.getPatient());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(
            @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO=patientService.createPatient(patientRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientResponseDTO);

    }

}
