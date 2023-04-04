package com.example.InsuranceManagement.Models;

import com.example.InsuranceManagement.Enums.PolicyType;
import com.example.InsuranceManagement.Enums.PremiumType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "insurance_policies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyNum;
    @Enumerated(value = EnumType.STRING)
    private PolicyType type;
    private double coverageAmount;
    @Enumerated(value = EnumType.STRING)
    private PremiumType premium;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToOne
    @JoinColumn
    private Claim claim;
}
