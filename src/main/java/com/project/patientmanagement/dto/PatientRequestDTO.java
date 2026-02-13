package com.project.patientmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {

    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private LocalDate registeredDate;
}
