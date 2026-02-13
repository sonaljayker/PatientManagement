package com.project.patientmanagement.Service;


import com.project.patientmanagement.dto.PatientRequestDTO;
import com.project.patientmanagement.dto.PatientResponseDTO;
import com.project.patientmanagement.mapper.PatientMapper;
import com.project.patientmanagement.model.Patient;
import com.project.patientmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patients=patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient patient=Patient.builder()
                .name(patientRequestDTO.getName())
                .email(patientRequestDTO.getEmail())
                .address(patientRequestDTO.getAddress())
                .dateOfBirth(patientRequestDTO.getDateOfBirth())
                .registeredDate(patientRequestDTO.getRegisteredDate())
                .build();
        Patient add=patientRepository.save(patient);

        return new PatientResponseDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getDateOfBirth(),
                patient.getAddress()
        );
    }


}
