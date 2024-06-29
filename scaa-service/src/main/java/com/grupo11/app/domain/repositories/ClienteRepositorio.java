package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, UUID> {

}
