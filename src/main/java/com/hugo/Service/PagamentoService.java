package com.hugo.service;

import java.util.List;

import com.hugo.model.Pagamento;
import com.hugo.model.PagamentoStatus;

public interface PagamentoService {

    Pagamento createPayment(Pagamento pagamento);

    Pagamento updatePaymentStatus(Long pagamentoId, PagamentoStatus newStatus);

    List<Pagamento> getAllPagamento();

    Pagamento searchPagamentoByCodigo(Long codigo);

    List<Pagamento> searchPagamentoByCpfCnpj(String cpfCnpj);

    List<Pagamento> searchPagamentoByStatus(String pagamentoStatus);

    void deletePagamento(Long pagamentoId);

    Pagamento updatePagamento(Long pagamentoId, Pagamento updatedPagamento);
}
