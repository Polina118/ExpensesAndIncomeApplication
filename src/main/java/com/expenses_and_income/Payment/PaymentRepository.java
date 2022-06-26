package com.expenses_and_income.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM payment p WHERE p.client_id = ?1 ORDER BY p.date_of_create DESC")
    List<Payment> findAllByClientId(Long client_id);

    @Query("SELECT p FROM payment p WHERE p.direction = ?1 AND p.client_id = ?2 ORDER BY p.date_of_create DESC")
    List<Payment> findAllByDirection(String direction, Long client_id);
}