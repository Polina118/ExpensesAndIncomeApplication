package com.expenses_and_income.Payment;

public class Request {

    private String direction;

    private Long client_id;

    Request(){}

    Request(String direction, Long client_id){
        this.direction = direction;
        this.client_id = client_id;
    }

    public String getDirection() {
        return direction;
    }

    public Long getClient_id() {
        return client_id;
    }
}
