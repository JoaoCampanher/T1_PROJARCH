package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {
}
