package com.expenses_and_income.Payment;

public class Request {

    private Integer year;
    private String status;
    private Long client_id;

    public Request(){}

    public Request(Integer year, String status, Long client_id) {
        this.year = year;
        this.status = status;
        this.client_id = client_id;
    }

    public Request(Integer year, String status) {
        this.year = year;
        this.status = status;
    }

    public Integer getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }

    public Long getClient_id(){
        return client_id;
    }
}
