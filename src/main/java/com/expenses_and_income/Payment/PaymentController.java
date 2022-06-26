package com.expenses_and_income.Payment;

import com.expenses_and_income.Client.Client;
import com.expenses_and_income.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @PostMapping(path = "/getinfo{clientid}")
    public List<Payment> getInfo(@PathVariable("clientid") Long clienid){
        return paymentRepository.findAllByClientId(clienid);
    }

    @PostMapping("/addingPayment")
    public Long addPay(@RequestBody Payment payment){
        Client client = clientRepository.findById(payment.getClient_id()).orElseThrow(() ->
                new IllegalStateException((" --!incorrect client id!-- ")));
        paymentRepository.save(payment);
        client.addPayment(payment);
        return payment.getId();
    }

    @DeleteMapping(path = "{payId}")
    public String deletePayment(@PathVariable("payId") Long id) {
        boolean exists = paymentRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException("payment with id " + id + "does not exists");
        paymentRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path = "/sortByDirection")
    public List<Payment> Sort(@RequestBody Request request){
        return paymentRepository.findAllByDirection(request.getDirection(), request.getClient_id());
    }
}
