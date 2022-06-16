package com.expenses_and_income.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByLogin(client.getLogin());
        if (clientOptional.isPresent())
            throw new IllegalStateException("login is taken");
        clientRepository.save(client);
    }

    public Client getByLogin(String login) {
        return clientRepository.findClientByLogin(login).
                orElseThrow(() -> new IllegalStateException((" --!incorrect login!-- ")));
    }

    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id))
            throw new IllegalStateException("client with id " + id + " does not exists");
        clientRepository.deleteById(id);
    }
}
