package com.project.patientmanagement.Service;


import com.project.patientmanagement.dto.PatientResponseDTO;
import com.project.patientmanagement.mapper.PatientMapper;
import com.project.patientmanagement.model.Patient;
import com.project.patientmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patients=patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

}
