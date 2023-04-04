package com.example.InsuranceManagement.Services;

import com.example.InsuranceManagement.DTOs.ClientRequestDto;
import com.example.InsuranceManagement.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.InsuranceManagement.Models.Client;

import java.util.List;

@Service
public class ClientService {
     @Autowired
     ClientRepository clientRepository;
     public List<Client> getClients(){
          return clientRepository.findAll();
     }
     public Client getClient(int id) throws Exception{
          return clientRepository.findById(id).get();
     }
     public String addClient(ClientRequestDto clientRequestDto){
          Client client=Client.builder().name(clientRequestDto
                  .getName()).dateOfBirth(clientRequestDto.getDateOfBirth())
                  .address(clientRequestDto.getAddress())
                  .mobileNum(clientRequestDto.getMobileNum())
                  .build();
          clientRepository.save(client);
          return "Client Created Successfully";
     }
     public String updateClient(int id,String mobileNum)throws Exception{
        Client client=clientRepository.findById(id).get();
        client.setMobileNum(mobileNum);
        clientRepository.save(client);
        return "Client Updated";
     }
     public String deleteClient(int id) throws Exception{
          Client client=clientRepository.findById(id).get();
          if(client!=null)
            clientRepository.deleteById(id);
          return "Client Deleted";
     }
}
