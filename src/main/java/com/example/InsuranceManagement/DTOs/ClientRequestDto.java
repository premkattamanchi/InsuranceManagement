package com.example.InsuranceManagement.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String mobileNum;
}
