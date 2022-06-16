package com.expenses_and_income.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM client c WHERE c.login = ?1")
    Optional<Client> findClientByLogin(String login);
}
