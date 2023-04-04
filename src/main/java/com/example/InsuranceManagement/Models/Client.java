package com.example.InsuranceManagement.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String mobileNum;

    @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL)
    private List<InsurancePolicy> insurancePolicyList=new ArrayList<>();
}
