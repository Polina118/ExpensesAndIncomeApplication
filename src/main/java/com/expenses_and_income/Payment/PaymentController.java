package com.expenses_and_income.Payment;

import com.expenses_and_income.Client.Client;
import com.expenses_and_income.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/client/pay")
@CrossOrigin()
public class PaymentController {

    PaymentRepository paymentRepository;
    ClientRepository clientRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/addingPayment")
    public String addPay(@RequestBody Payment payment){
        Client client = clientRepository.findById(payment.getClient_id()).orElseThrow(() ->
                new IllegalStateException((" --!incorrect client id!-- ")));
        paymentRepository.save(payment);
        client.addPayment(payment);
        return "added payment with client_id " + payment.getClient_id();
    }

    @PostMapping("/finding")
    public List<Payment> Find(@RequestBody Request request){
        return paymentRepository.findAllByRequest(
                request.getStatus(),
                request.getClient_id(),
                request.getYear());
    }

    @DeleteMapping(path = "{payId}")
    public void DeletePayment(@PathVariable("payId") Long id) {
        boolean exists = clientRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException("payment with id " + id + "does not exists");
        paymentRepository.deleteById(id);
    }
}
