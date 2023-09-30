package com.hugo.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(Long pagamentoId) {
        super("Pagamento não encontrado com ID: " + pagamentoId);
    }

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
