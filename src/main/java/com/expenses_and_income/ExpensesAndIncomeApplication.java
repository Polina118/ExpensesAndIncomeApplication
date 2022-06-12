package com.expenses_and_income;

import com.expenses_and_income.Client.Client;
import com.expenses_and_income.Client.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
public class ExpensesAndIncomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpensesAndIncomeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
		return args -> {
			Client polina = new Client("Polina", "Guk", "pg", "12");
			Client serg = new Client("Sergey", "Chaliy", "Sergey", "gfjnb");
			clientRepository.saveAll(List.of(polina, serg));
		};
	}
//	@Bean
//	public WebMvcConfigurer configurer(){
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//			registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}


