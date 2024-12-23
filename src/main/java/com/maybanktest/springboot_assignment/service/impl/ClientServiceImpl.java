package com.maybanktest.springboot_assignment.service.impl;

import com.maybanktest.springboot_assignment.entities.ClientEntity;
import com.maybanktest.springboot_assignment.models.ClientDTO;
import com.maybanktest.springboot_assignment.repo.ClientRepo;
import com.maybanktest.springboot_assignment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepo clientRepo;

    @Autowired
    private ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Page<ClientDTO> getClientsByPage(int page, int size) {
        return clientRepo.findAllAsDto(PageRequest.of(page, size));

    }

    @Transactional
    public String createClient(ClientDTO clientDTO) {
        try {
            ClientEntity clientEntity = new ClientEntity();
            clientEntity.setUsername(clientDTO.getUsername());
            clientEntity.setFullName(clientDTO.getFullName());
            clientEntity.setAddress(clientDTO.getAddress());
            clientEntity.setEmail(clientDTO.getEmail());
            clientEntity.setContactNumber(clientDTO.getContactNumber());
            clientRepo.save(clientEntity);
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }

    @Transactional
    public ClientDTO updateRecord(String username, ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("Username does not exist"));

        clientEntity.setFullName(clientDTO.getFullName());
        clientEntity.setAddress(clientDTO.getAddress());
        clientEntity.setEmail(clientDTO.getEmail());
        clientEntity.setContactNumber(clientDTO.getContactNumber());
        clientRepo.save(clientEntity);
        return clientDTO;
    }
}
