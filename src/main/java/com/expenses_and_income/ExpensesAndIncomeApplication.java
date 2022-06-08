package com.expenses_and_income;

import com.expenses_and_income.Client.Client;
import com.expenses_and_income.Client.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ExpensesAndIncomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpensesAndIncomeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository){
		return args -> {
			Client polina = new Client("Polina", "Guk", "pg", "12");
			Client serg = new Client("Sergey", "Chaliy", "Sergey", "gfjnb");
			clientRepository.saveAll(List.of(polina, serg));
		};
	}

}
//@Table
//@Entity(name = "payment")
//public class Payment {
//
//	@Id
//	@SequenceGenerator(
//			name = "client_sequence",
//			sequenceName = "client_sequence",
//			allocationSize = 1
//	)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "client_sequence"
//	)
//	@Column(updatable = false)
//	private Long id;
//
//	@Column(nullable = false)
//	private Integer income;
//
//	@Column(nullable = false)
//	private LocalDate date_of_create;
//
//	@Column(nullable = false)
//	private String direction;
//
//	@Column(nullable = false)
//	private Long client_id;
//
//	@ManyToOne
//	@JoinColumn(name="client_id", nullable=false)
//	private Client client;

