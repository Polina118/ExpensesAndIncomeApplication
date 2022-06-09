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

    @PostMapping(path = "/registration")
    public Client RegisterNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }

    @GetMapping(path = "/authorization")
    public Client AuthorizationClient(@RequestParam String login, @RequestParam String password){
       return clientService.getByLoginPassword(login, password.hashCode());
    }

//    @GetMapping(path = "/authorization")
//    public Client AuthorizationClient(@RequestParam String login){
//        return clientService.getByLogin(login);
//    }

//    @GetMapping(path = "/authorization")
//    public Client AuthorizationClient(@RequestParam String password){
//        return clientService.getByPassword(password.hashCode());
//    }

//    @GetMapping(path = "/get{clientId}")
//    public void getClient(@RequestParam("clientId") Long id) {
//        clientService.getClientById(id);
//    }

    @DeleteMapping(path = "{clientId}")
    public void DeleteClient(@PathVariable("clientId") Long id) {
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

