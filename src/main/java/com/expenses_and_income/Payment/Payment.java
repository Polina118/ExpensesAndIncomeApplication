package com.expenses_and_income.Payment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate date_of_create = LocalDate.now();

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

    public void setDate_of_create(LocalDate date){
        this.date_of_create = date;
    }

    public String getStatus() {
        return status;
    }

    public Long getClient_id() {
        return client_id;
    }
}
