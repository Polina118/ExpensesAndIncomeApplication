package com.expenses_and_income.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
        Optional<Client> clientOptional =
                clientRepository.findClientByLogin(client.getLogin());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("login is taken");
        }
        clientRepository.save(client);
        throw new IllegalStateException("Id of client is " + client.getId());
    }

    public void deleteClient(Long id) {
        boolean exists = clientRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("client with id " + id + "does not exists");
        }
        clientRepository.deleteById(id);
    }

    @Transactional
    public void updateClient(Long Id, String firstname, String lastname, String login, String password) {
        Client client = clientRepository.findById(Id).
                orElseThrow(() -> new IllegalStateException(("client with id " + Id + "does not exists")));
        if (firstname != null && firstname.length() > 0 && !Objects.equals(client.getFirstname(), firstname))
            client.setFirstname(firstname);

        if (lastname != null && lastname.length() > 0 && !Objects.equals(client.getLastname(), lastname))
            client.setLastname(lastname);

        if (login != null && login.length() > 0 && !Objects.equals(client.getLogin(), login)) {
            Optional<Client> optionalClient = clientRepository.findClientByLogin(login);
            if (optionalClient.isPresent())
                throw new IllegalStateException("login taken");
            client.setLogin(login);
        }

        if (password != null && password.length() > 0 && !Objects.equals(client.getPassword(), password.hashCode()))
            client.setPassword(password);
    }
}