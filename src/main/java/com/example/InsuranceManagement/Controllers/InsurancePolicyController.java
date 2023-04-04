package com.example.InsuranceManagement.Controllers;

import com.example.InsuranceManagement.DTOs.PolicyRequestDto;
import com.example.InsuranceManagement.Enums.PremiumType;
import com.example.InsuranceManagement.Models.InsurancePolicy;
import com.example.InsuranceManagement.Services.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class InsurancePolicyController {
    @Autowired
    InsurancePolicyService insurancePolicyService;
    @GetMapping("/get-policies")
    public List<InsurancePolicy> getPolicies(){
        return insurancePolicyService.getPolicies();
    }
    @GetMapping("/get-policy/{id}")
    public InsurancePolicy getPolicy(@PathVariable int id) throws Exception{
        InsurancePolicy insurancePolicy=null;
        try{
            insurancePolicy=insurancePolicyService.getPolicy(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return insurancePolicy;
    }
    @PostMapping("/add-policy")
    public String addPolicy(@RequestBody PolicyRequestDto policyRequestDto){
        return insurancePolicyService.addPolicy(policyRequestDto);
    }
    @PutMapping("/update-policy/{id}")
    public String updatePolicy(@PathVariable int id, @RequestParam PremiumType premiumType) throws Exception{
        String s="Policy not found";
        try {
            s = insurancePolicyService.updatePolicy(id,premiumType);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
    @DeleteMapping("/delete-policy/{id}")
    public String deletePolicy(@PathVariable int id) throws Exception{
        String s="Policy not found";
        try {
            s = insurancePolicyService.deletePolicy(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
}
