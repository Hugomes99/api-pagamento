package com.hugo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.http.ResponseEntity;

import com.hugo.model.Pagamento;
import com.hugo.model.PagamentoStatus;
import com.hugo.model.PagamentoTipo;
import com.hugo.repository.PagamentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PagamentoService {


    @Resource
    private PagamentoRepository pagamentoRepository;

        
        public PagamentoService(PagamentoRepository pagamentoRepository) {
            this.pagamentoRepository = pagamentoRepository;
        }
    
        public Pagamento createPayment(Pagamento pagamento) {
            return pagamentoRepository.save(pagamento);
        }
    
        public Pagamento updatePaymentStatus(Long pagamentoId, PagamentoStatus newStatus) {
            Pagamento pagamento = pagamentoRepository.findById(pagamentoId)
                    .orElseThrow(() -> new PaymentNotFoundException("Pagamento não encontrado com ID " + pagamentoId));
    
            if (pagamento.getPagamentoStatus() == PagamentoStatus.PROCESSADO_SUCESSO) {
                throw new InvalidPaymentStatusException("Não é possível alterar o status de um pagamento processado com sucesso.");
            }
    
            if (pagamento.getPagamentoStatus() == PagamentoStatus.PROCESSADO_FALHA &&
                newStatus != PagamentoStatus.PROCESSADO_PENDENTE) {
                throw new InvalidPaymentStatusException("
                Falha no pagamento só pode ser alterada para PROCESSADO_PENDENTE.");
            }
    
            pagamento.setPagamentoStatus(newStatus);
            return pagamentoRepository.save(pagamento);
        }
    
        public List<Pagamento> getAllPagamento() {
            return pagamentoRepository.findAll();
        }
    
        public List<Pagamento> searchPagamentoByCodigo(Long codigo) {
            return PagamentoRepository.findByCodigo(codigo);
        }
    
        public List<Pagamento> searchPagamentoByCpfCnpj(String cpfCnpj) {
            return pagamentoRepository.findByCpfCnpj(cpfCnpj);
        }
    
        public List<Pagamento> searchPagamentoByStatus(PagamentoStatus pagamentoStatus) {
            return pagamentoRepository.findByPagamentoStatus(pagamentoStatus);
        }
    }
    