package com.expenses_and_income.Client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository repository;
    private ClientService service;

    @BeforeEach
    void setUp() {
        service = new ClientService(repository);
    }

    @Test
    void canGetClients() {
        // when
        service.getClients();
        // then
        verify(repository).findAll();
    }

    @Test
    void canAddNewClient() {
        // given
        Client client = new Client("kamila", "Mur", "k@google.com", "mur");
        // when
        service.addNewClient(client);
        // then
        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(repository).save(clientArgumentCaptor.capture());

        Client captorValue = clientArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(client);
    }

    @Test
    void throwWhenLoginIsTaken(){
        //given
        Client client = new Client("kamila", "Mur", "k@google.com", "mur");
        given(repository.selectExistsEmail(anyString())).willReturn(true);

        //when
        //then
        assertThatThrownBy(()-> service.addNewClient(client))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("login is taken");

        verify(repository, never()).save(any());
    }

    @Test
    @Disabled
    void getByLogin() {
    }

    @Test
    @Disabled
    void deleteClient() {
    }
}