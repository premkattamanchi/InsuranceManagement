package com.example.InsuranceManagement.Services;

import com.example.InsuranceManagement.DTOs.PolicyRequestDto;
import com.example.InsuranceManagement.Enums.PremiumType;
import com.example.InsuranceManagement.Models.Claim;
import com.example.InsuranceManagement.Models.Client;
import com.example.InsuranceManagement.Models.InsurancePolicy;
import com.example.InsuranceManagement.Repositories.ClaimRepository;
import com.example.InsuranceManagement.Repositories.ClientRepository;
import com.example.InsuranceManagement.Repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClaimRepository claimRepository;
    public List<InsurancePolicy> getPolicies(){
        return insurancePolicyRepository.findAll();
    }
    public InsurancePolicy getPolicy(int id) throws Exception{
       return insurancePolicyRepository.findById(id).get();
    }
    public String addPolicy(PolicyRequestDto policyRequestDto){
        Client client=clientRepository.findById(policyRequestDto.getClientId()).get();
       InsurancePolicy insurancePolicy=InsurancePolicy.builder().type(policyRequestDto.getType())
               .coverageAmount(policyRequestDto.getCoverageAmount())
               .premium(policyRequestDto.getPremium())
               .startDate(policyRequestDto.getStartDate())
               .endDate(policyRequestDto.getEndDate())
               .client(client).build();
       client.getInsurancePolicyList().add(insurancePolicy);
       clientRepository.save(client);
       return "Policy Added Successfully";
    }
    public String updatePolicy(int id, PremiumType premiumType) throws Exception{
        InsurancePolicy insurancePolicy=insurancePolicyRepository.findById(id).get();
        insurancePolicy.setPremium(premiumType);
        insurancePolicyRepository.save(insurancePolicy);
       return "Policy Updated";
    }
    public String deletePolicy(int id) throws Exception{
        InsurancePolicy insurancePolicy=insurancePolicyRepository.findById(id).get();
        Client client=insurancePolicy.getClient();
        List<InsurancePolicy> policies=client.getInsurancePolicyList();
        for(InsurancePolicy ip:policies){
            if(insurancePolicy.getPolicyNum()==ip.getPolicyNum())
                policies.remove(ip);
        }
        client.setInsurancePolicyList(policies);
        clientRepository.save(client);
        insurancePolicyRepository.deleteById(id);
        return "Policy deleted";
    }
}
