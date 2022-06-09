package com.expenses_and_income.Payment;

import java.time.LocalDate;

public class Payment {
    private Long Id;

    private Integer income;

    private String direction;

    private LocalDate date_of_create;

    private Integer months;

    private Integer weeks;

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
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
