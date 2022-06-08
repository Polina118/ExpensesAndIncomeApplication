package com.expenses_and_income.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public List<Client> getStudents() {
        return clientService.getClients();
    }

    @PostMapping(path = "/register")
    public void RegisterNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public void DeleteClient(@PathVariable("studentId") Long id) {
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{clientId}")
    public void UpdateClient(
            @PathVariable("clientId") Long Id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String password) {
        clientService.updateClient(Id, firstname, lastname, login, password);
    }
}

