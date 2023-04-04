package com.example.InsuranceManagement.Controllers;

import com.example.InsuranceManagement.DTOs.ClaimRequestDto;
import com.example.InsuranceManagement.Enums.ClaimStatus;
import com.example.InsuranceManagement.Services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.InsuranceManagement.Models.Claim;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {
    @Autowired
    ClaimService claimService;
    @GetMapping("/get-claims")
    public List<Claim> getClaims(){
        return claimService.getClaims();
    }
    @GetMapping("/get-claim/{id}")
    public Claim getClaim(@PathVariable int id){
        Claim claim=null;
        try{
            claim=claimService.getClaim(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return claim;
    }
    @PostMapping("/add-claim")
    public String addClaim(@RequestBody ClaimRequestDto claimRequestDto){
        return claimService.addClaim(claimRequestDto);
    }
    @PutMapping("/update-claim/{id}")
    public String updateClaim(@PathVariable int id, @RequestParam ClaimStatus claimStatus){
        String s="claim not found";
        try {
            s = claimService.updateClaim(id,claimStatus);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
    @DeleteMapping("/delete-claim/{id}")
    public String deleteClaim(@PathVariable int id){
        String s="Claim not found";
        try {
            s = claimService.deleteClaim(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
}
