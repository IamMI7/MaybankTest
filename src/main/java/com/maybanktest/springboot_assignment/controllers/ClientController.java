package com.maybanktest.springboot_assignment.controllers;

import com.maybanktest.springboot_assignment.models.ClientDTO;
import com.maybanktest.springboot_assignment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/maybank/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ClientDTO>> getClientInfo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(clientService.getClientsByPage(page, size));
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createClient(clientDTO));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> updateClient(
            @PathVariable String username,
            @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateRecord(username, clientDTO));
    }


}
