package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AssinaturaRepositorio extends JpaRepository<Assinatura, UUID> {
}
