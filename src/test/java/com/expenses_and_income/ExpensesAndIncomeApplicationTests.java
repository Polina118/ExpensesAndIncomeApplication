package com.expenses_and_income;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ExpensesAndIncomeApplicationTests {
	Calculator underTest = new Calculator();

	@Test
	void itShouldADDNumbers() {
		// given
		int one = 10;
		int two = 20;

		//when
		int result = underTest.add(one, two);

		//then
		assertThat(result).isEqualTo(30);
	}

	class Calculator{
		int add (int a, int b){
			return a+b;
		}
	}

}
