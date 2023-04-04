package com.example.InsuranceManagement.Services;

import com.example.InsuranceManagement.DTOs.ClaimRequestDto;
import com.example.InsuranceManagement.Enums.ClaimStatus;
import com.example.InsuranceManagement.Models.Claim;
import com.example.InsuranceManagement.Models.InsurancePolicy;
import com.example.InsuranceManagement.Repositories.ClaimRepository;
import com.example.InsuranceManagement.Repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
     public List<Claim> getClaims(){
         return claimRepository.findAll();
     }
     public Claim getClaim(int id)throws Exception{
         return claimRepository.findById(id).get();
     }
     public String addClaim(ClaimRequestDto claimRequestDto){
         InsurancePolicy insurancePolicy=insurancePolicyRepository.findById(claimRequestDto.getPolicyId()).get();
         Claim claim=Claim.builder().description(claimRequestDto.getDescription())
                 .claimDate(claimRequestDto.getClaimDate())
                 .claimStatus(claimRequestDto.getClaimStatus())
                 .claimNumber(UUID.randomUUID().toString())
                 .insurancePolicy(insurancePolicy).build();
         claimRepository.save(claim);
         insurancePolicy.setClaim(claim);
         insurancePolicyRepository.save(insurancePolicy);
         return "Claim Added";
     }
     public String updateClaim(int id, ClaimStatus claimStatus) throws Exception{
         Claim claim=claimRepository.findById(id).get();
         claim.setClaimStatus(claimStatus);
         claimRepository.save(claim);
         return "Claim Updated";
     }
     public String deleteClaim(int id) throws Exception{
         Claim claim=claimRepository.findById(id).get();
         if(claim!=null)
           claimRepository.deleteById(id);
         return "Claim deleted";
     }
}
