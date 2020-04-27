package com.xebia.shoppingcart.paymentservice.api;
import com.xebia.shoppingcart.paymentservice.model.CardDetails;
import com.xebia.shoppingcart.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcart/payment")
public class PaymentResource {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    private ResponseEntity<Double> totalAmount() {
        double amount = paymentService.getTotalAmount();
        return ResponseEntity.status(HttpStatus.OK).body(amount);
    }

    //mention return type
    @PostMapping
    private ResponseEntity<Void> cardDetails(@RequestBody CardDetails cardDetails){
        paymentService.saveCardDetails(cardDetails);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
