package com.expenses_and_income.Payment;

import com.expenses_and_income.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/payment")
@CrossOrigin
public class PaymentController {

    PaymentRepository paymentRepository;
    ClientRepository clientRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/getInfo")
    public List<Payment> getPayments(){
        return paymentRepository.findAll();
    }

    @PostMapping("/addingPayment")
    public Payment addPay(@RequestBody Payment payment){
        paymentRepository.save(payment);
        return payment;
    }

    @PostMapping("/finding")
    public List<Payment> Find(@RequestBody Request request){
        return paymentRepository.findAllByRequest(request.getDirection(), request.getIncome(), request.getClient_id());
    }
}
