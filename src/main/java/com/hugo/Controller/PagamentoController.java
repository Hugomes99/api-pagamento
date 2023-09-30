package com.hugo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.hugo.model.Pagamento;
import com.hugo.service.PagamentoService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Resource
    private PagamentoService service;

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return service.getAllPagamento();
    }

    @GetMapping("/{id}")
    public Pagamento getPagamentoById(@PathVariable Long id) {
        return service.searchPagamentoByCodigo(id);
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return service.createPayment(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento updatePagamento(@PathVariable Long id, @RequestBody Pagamento updatedPagamento) {
        return service.searchPagamentoByCodigo(id);
    }

    @DeleteMapping("/{id}")
    public void deletePagamento(@PathVariable Long id) {
        service.searchPagamentoByCodigo(id);
    }
}
