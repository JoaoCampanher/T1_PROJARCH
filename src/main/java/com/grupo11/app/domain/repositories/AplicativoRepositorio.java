package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AplicativoRepositorio extends JpaRepository<Aplicativo, UUID> {
}
