package com.example.InsuranceManagement.Models;

import com.example.InsuranceManagement.Enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "claim")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    @Enumerated(value = EnumType.STRING)
    private ClaimStatus claimStatus;

    @OneToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;

}
