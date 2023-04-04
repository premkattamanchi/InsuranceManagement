package com.example.InsuranceManagement.DTOs;

import com.example.InsuranceManagement.Enums.ClaimStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimRequestDto {
    private int policyId;
    private String description;
    private LocalDate claimDate;
    private ClaimStatus claimStatus;
}
