package com.maybanktest.springboot_assignment.service;

import com.maybanktest.springboot_assignment.models.ClientDTO;
import org.springframework.data.domain.Page;

public interface ClientService {
    Page<ClientDTO> getClientsByPage(int page, int size);

    String createClient(ClientDTO clientDTO);

    ClientDTO updateRecord(String username, ClientDTO clientDTO);
}
