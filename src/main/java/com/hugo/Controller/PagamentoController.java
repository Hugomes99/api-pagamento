package com.hugo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.hugo.model.Pagamento;
import com.hugo.service.PagamentoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pagamento")
@AllArgsConstructor
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> listPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.list(pagamento);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.create(pagamento);
    }

    @PutMapping()
    public ResponseEntity<Pagamento> updatePagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.update(pagamento);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletePagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.delete(pagamento);
    }

}