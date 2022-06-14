package com.expenses_and_income.Payment;

import com.expenses_and_income.Client.Client;

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
    private String status = "";

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private final LocalDate date_of_create = LocalDate.now();

    @Column(nullable = false)
    private final Integer year = date_of_create.getYear();

    private Long client_id;

    public Payment() {
    }

    public Payment(Integer sum, String status, String direction, Integer client_id) {
        this.sum = sum;
        this.status = status;
        this.direction = direction;
        this.client_id = Long.valueOf(client_id);
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getDirection() {
        return direction;
    }

    public LocalDate getDate_of_create(){
        return date_of_create;
    }

//    public Integer getMonth() {
//        return date_of_create.getMonth().getValue();
//    }
//
//    public Integer getDays(){
//        return Period.between(LocalDate.now(), date_of_create).getDays();
//    }

    public Integer getWeeks(){
        return (Period.between(LocalDate.now(), date_of_create).getDays()) / 7;
    }

    public Long getClient_id() {
        return client_id;
    }
}
