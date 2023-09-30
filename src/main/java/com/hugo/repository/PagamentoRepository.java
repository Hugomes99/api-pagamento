package com.hugo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByCpfCnpj(String cpfCnpj);

    List<Pagamento> findByStatus(String pagamentoStatus);

}