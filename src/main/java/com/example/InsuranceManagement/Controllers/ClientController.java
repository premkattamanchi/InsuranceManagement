package com.example.InsuranceManagement.Controllers;

import com.example.InsuranceManagement.DTOs.ClientRequestDto;
import com.example.InsuranceManagement.Models.Client;
import com.example.InsuranceManagement.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/get-clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }
    @GetMapping("/get-client/{id}")
    public Client getClient(@PathVariable int id){
        Client client=null;
        try{
            client=clientService.getClient(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return client;
    }
    @PostMapping("/add-client")
    public String addClient(@RequestBody ClientRequestDto clientRequestDto){
        return clientService.addClient(clientRequestDto);
    }
    @PutMapping("/update-client/{id}")
    public String updateClient(@PathVariable int id,@RequestParam String mobileNum){
        String s="client not found";
        try {
            s = clientService.updateClient(id,mobileNum);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
    @DeleteMapping("/delete-client/{id}")
    public String deleteClient(@PathVariable int id){
        String s="client not found";
        try {
            s = clientService.deleteClient(id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
}
