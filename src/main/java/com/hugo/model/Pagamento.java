package com.hugo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo_debito", nullable = false)
    private Integer codigo;

    @Column(name = "cpf_cnpj", length = 15, nullable = false)
    private String cpfCnpj;

    @Column(name = "metodo_pagamento", length = 20, nullable = false)
    private String metodoPagamento;

    @Column(name = "numero_cartao", length = 13, nullable = true)
    private String numeroCartao;

    @Column(name = "valor", nullable = false, precision = 2)
    private double valor;

    @Column(name = "status", nullable = false)
    private String status;

}