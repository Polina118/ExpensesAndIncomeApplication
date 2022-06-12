package com.expenses_and_income.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/v1/client")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping(path = "/registration")
    @ResponseBody
    public Client RegisterNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
        return new Client(client.getId(), client.getFirstname(), client.getLastname(), client.getLogin());
    }

    @PostMapping(path = "/authorization")
    @ResponseBody
    public Client AuthorizationClient(@RequestBody LoginForm loginForm){
        Client client = clientService.getByLogin(loginForm.getLogin());
        return new Client(client.getId(), client.getFirstname(), client.getLastname(), client.getLogin());
    }

    @DeleteMapping(path = "{clientId}")
    public void DeleteClient(@PathVariable("clientId") Long id) {
        clientService.deleteClient(id);
    }

//    @PutMapping(path = "{clientId}")
//    public void UpdateClient(
//            @PathVariable("clientId") Long Id,
//            @RequestParam(required = false) String firstname,
//            @RequestParam(required = false) String lastname,
//            @RequestParam(required = false) String login,
//            @RequestParam(required = false) String password) {
//        clientService.updateClient(Id, firstname, lastname, login, password);
//    }
}

