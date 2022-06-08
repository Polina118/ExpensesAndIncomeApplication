package com.expenses_and_income;


import com.expenses_and_income.Client.Client;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity(name = "payment")
public class Payment {

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
    private Integer income;

    @Column(nullable = false)
    private LocalDate date_of_create;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private Long client_id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;


}
