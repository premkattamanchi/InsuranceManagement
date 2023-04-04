package com.example.InsuranceManagement.DTOs;

import com.example.InsuranceManagement.Enums.PolicyType;
import com.example.InsuranceManagement.Enums.PremiumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyRequestDto {
    private int clientId;
    private PolicyType type;
    private double coverageAmount;
    private PremiumType premium;
    private LocalDate startDate;
    private LocalDate endDate;
}
