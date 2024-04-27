package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssinaturaRepositorio extends JpaRepository<Assinatura, UUID> {
}
