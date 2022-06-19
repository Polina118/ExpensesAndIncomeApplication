package com.expenses_and_income.Client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository underTest;

    @Test
    void findClientByLogin() {
        //given
        Client client = new Client("kamila", "Mur", "k@google.com", "mur");
        underTest.save(client);

        //when
        Boolean expected = underTest.selectExistsEmail("k@google.com");

        //then
        assertThat(expected).isEqualTo(true);
    }
}