package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepositorio extends JpaRepository<Cliente, UUID> {
}
