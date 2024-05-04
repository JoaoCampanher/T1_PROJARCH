package com.grupo11.app.domain.repositories;

import com.grupo11.app.domain.entity.Aplicativo;
import com.grupo11.app.domain.entity.Assinatura;
import com.grupo11.app.domain.entity.Cliente;
import com.grupo11.app.domain.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AssinaturaRepositorio extends JpaRepository<Assinatura, UUID> {

    List<Assinatura> findAllByStatusAssinatura(Status statusAssinatura);

    List<Assinatura> findAllByCliente(Cliente cliente);

    List<Assinatura> findAllByAplicativo(Aplicativo aplicativo);
    boolean existsByCliente_idClienteAndAplicativo_idAplicativo(UUID clienteId, UUID aplicativoId);

}
