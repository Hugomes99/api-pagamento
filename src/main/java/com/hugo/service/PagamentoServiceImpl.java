package com.hugo.service;

import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.annotation.Resource;


import com.hugo.exeception.InvalidPaymentStatusException;
import com.hugo.exeception.PaymentNotFoundException;
import com.hugo.model.Pagamento;
import com.hugo.model.PagamentoStatus;
import com.hugo.repository.PagamentoRepository;


@Service
public class PagamentoServiceImpl implements PagamentoService {


    @Resource
    private PagamentoRepository pagamentoRepository;

        public Pagamento createPayment(Pagamento pagamento) {
            return pagamentoRepository.save(pagamento);
        }

        public Pagamento updatePaymentStatus(Long pagamentoId, PagamentoStatus newStatus) {
            Pagamento pagamento = pagamentoRepository.findById(pagamentoId)
                    .orElseThrow(() -> new PaymentNotFoundException("Pagamento não encontrado com ID " + pagamentoId));

            if (pagamento.getStatus().equals(PagamentoStatus.PROCESSADO_SUCESSO.toString())) {
                throw new InvalidPaymentStatusException("Não é possível alterar o status de um pagamento processado com sucesso.");
            }

            if (pagamento.getStatus().equals(PagamentoStatus.PROCESSADO_FALHA.toString()) &&
                newStatus != PagamentoStatus.PROCESSADO_PENDENTE) {
                throw new InvalidPaymentStatusException("Falha no pagamento só pode ser alterada para PROCESSADO_PENDENTE.");
            }

            pagamento.setStatus(newStatus.toString());
            return pagamentoRepository.save(pagamento);
        }

        public List<Pagamento> getAllPagamento() {
            return pagamentoRepository.findAll();
        }

        public Pagamento searchPagamentoByCodigo(Long codigo) {
            return pagamentoRepository.findById(codigo).get();
        }

        public List<Pagamento> searchPagamentoByCpfCnpj(String cpfCnpj) {
            return pagamentoRepository.findByCpfCnpj(cpfCnpj);
        }

        public List<Pagamento> searchPagamentoByStatus(String status) {
            return pagamentoRepository.findByStatus(status);
        }
    }
