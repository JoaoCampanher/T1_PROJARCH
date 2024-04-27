package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepositorio extends JpaRepository<Pagamento, UUID> {
}
