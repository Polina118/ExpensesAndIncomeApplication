package com.expenses_and_income.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/v1/client")
@CrossOrigin()
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
    public String RegisterNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
        return "Success";
    }

    @PostMapping(path = "/authorization")
    @ResponseBody
    public Client AuthorizationClient(@RequestBody LoginForm loginForm){
        Client client = clientService.getByLogin(loginForm.getLogin());
        if(!Objects.equals(client.getPassword(), loginForm.getPassword()))
            throw new IllegalStateException((" --!incorrect password!-- "));
        return new Client(
                client.getId(),
                client.getFirstname(),
                client.getLastname());
    }

    @DeleteMapping(path = "/delete{id}")
    public String DeleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return "Deleted";
    }
}

