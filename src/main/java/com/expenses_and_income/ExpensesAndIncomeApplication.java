package com.expenses_and_income;

import com.expenses_and_income.Client.Client;
import com.expenses_and_income.Client.ClientRepository;
import com.expenses_and_income.Payment.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ExpensesAndIncomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpensesAndIncomeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
		return args -> {
			Client polina = new Client("Polina", "Guk", "pg@inbox.ru", "12");
			Client serg = new Client("Sergey", "Chaliy", "s@inbox.ru", "gfjnb");

			Payment pay1 = new Payment(60, "expense", "Транспорт",1);
			Payment pay2 = new Payment(2000,"income", "Зарплата",1);
			Payment pay3 = new Payment(100,"expense", "Супермаркеты", 1);

			pay1.setDate_of_create(LocalDate.of(2022, LocalDate.now().getMonth(), 1));
			pay3.setDate_of_create(LocalDate.of(2022, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()-3));

			polina.setPayments(List.of(pay1, pay2, pay3));
			clientRepository.saveAll(List.of(polina, serg));
		};
	}
}


