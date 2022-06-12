package com.expenses_and_income.Payment;

public class Request {

    private Integer income;
    private String direction;
    private Long client_id;

    public Request(){}

    public Request(Integer income, String direction, Long client_id) {
        this.income = income;
        this.direction = direction;
        this.client_id = client_id;
    }

    public Request(Integer income, String direction) {
        this.income = income;
        this.direction = direction;
    }

    public Integer getIncome() {
        return income;
    }

    public String getDirection() {
        return direction;
    }

    public Long getClient_id(){
        return client_id;
    }
}
