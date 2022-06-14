package com.expenses_and_income.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM payment p WHERE p.client_id = ?1")
    List<Payment> findAllByClientId(Long client_id);

    @Query("SELECT p FROM payment p WHERE p.status = ?1 and p.client_id=?2 and p.year=?3")
    List<Payment> findAllByRequest(String status, Long id, int year);
}
//p.date_of_create BETWEEN ?2 AND ?3