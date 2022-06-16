package com.expenses_and_income.Payment;

import com.expenses_and_income.Client.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Table
@Entity(name = "payment")
public class Payment {

    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    @Column(updatable = false)
    private Long Id;

    @Column(nullable = false)
    private Integer sum;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private final LocalDate date_of_create = LocalDate.now();

    private Long client_id;

    public Payment(){}

    public Payment(Integer sum, String status, String direction, Integer client_id) {
        this.sum = sum;
        this.status = status;
        this.direction = direction;
        this.client_id = Long.valueOf(client_id);
    }

    public Long getId() {
        return Id;
    }

    public Integer getSum() {
        return sum;
    }

    public String getDirection() {
        return direction;
    }

    public LocalDate getDate_of_create(){
        return date_of_create;
    }

    public String getStatus() {
        return status;
    }

    public Long getClient_id() {
        return client_id;
    }
}
