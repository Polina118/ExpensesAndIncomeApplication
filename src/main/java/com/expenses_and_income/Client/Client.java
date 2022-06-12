package com.expenses_and_income.Client;

import com.expenses_and_income.Payment.Payment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(uniqueConstraints = {
        @UniqueConstraint(name = "login_unique", columnNames = "login") })
@Entity(name = "client")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private Integer password;

    public Client(){}

    public Client(String firstname, String lastname, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password.hashCode();
    }

    public Client(String firstname, String lastname, String login, String password, List<Payment> pays) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password.hashCode();
        //this.payments = pays;
    }

    public Client(Long id, String firstname, String lastname, String login) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    @Override
    public String toString() {
        return "Client {" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + "'}";
    }
}
