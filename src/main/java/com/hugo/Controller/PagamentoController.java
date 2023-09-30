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

import com.hugo.exeception.ResourceNotFoundException;
import com.hugo.model.Pagamento;
import com.hugo.repository.PagamentoRepository;


@RestController
@RequestMapping("/api/pagamento")

public class PagamentoController {

    
    private final PagamentoRepository pagamentoRepository;

    public PagamentoController(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pagamento getPagamentoById(@PathVariable Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado com ID " + id));
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento updatePagamento(@PathVariable Long id, @RequestBody Pagamento updatedPagamento) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> {
                    pagamento.setMetodoPagamento(updatedPagamento.getMetodoPagamento());
                    pagamento.setValor(updatedPagamento.getValor());
                    return pagamentoRepository.save(pagamento);
                })
                .orElseThrow(() -> new ResourceNotFoundException("\r\n" + //
                        "Pagamento não encontrado com ID " + id));
    }

    @DeleteMapping("/{id}")
    public void deletePagamento(@PathVariable Long id) {
        pagamentoRepository.deleteById(id);
    }
}
