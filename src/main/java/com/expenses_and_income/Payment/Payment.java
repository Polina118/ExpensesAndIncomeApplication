package com.expenses_and_income.Payment;

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
    private Integer income;

    @Column(nullable = false)
    private String direction;

    @Column(name = "doc", nullable = false)
    private LocalDate date_of_create;

    @Column
    private Integer months;

    @Column
    private Integer days;

    @Column(nullable = false)
    private Long client_id;

    public Payment(){}

    public Payment(Integer income, String direction, LocalDate date_of_create, Long client_id) {
        this.income = income;
        this.direction = direction;
        this.date_of_create = date_of_create;
        this.client_id = client_id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getDate_of_create() {
        return date_of_create;
    }

    public void setDate_of_create(LocalDate date_of_create) {
        this.date_of_create = date_of_create;
    }

    public Integer getMonths() {
        return Period.between(this.date_of_create, LocalDate.now()).getMonths();
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Integer getDays() {
        return Period.between(this.date_of_create, LocalDate.now()).getDays();
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
