package com.expenses_and_income.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM payment p WHERE p.direction = ?1 AND p.income = ?2 AND p.client_id = ?3")
    List<Payment> findAllByRequest(String direction, int income, Long client_id);
}
