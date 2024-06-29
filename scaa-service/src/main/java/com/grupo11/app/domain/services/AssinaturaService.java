package com.grupo11.app.domain.services;

import com.grupo11.app.application.DTOs.CriaAssinaturaDTO;
import com.grupo11.app.domain.entity.Aplicativo;
import com.grupo11.app.domain.entity.Assinatura;
import com.grupo11.app.domain.entity.Cliente;
import com.grupo11.app.domain.entity.enums.Status;
import com.grupo11.app.domain.entity.enums.StatusAssinatura;
import com.grupo11.app.domain.repositories.AplicativoRepositorio;
import com.grupo11.app.domain.repositories.AssinaturaRepositorio;
import com.grupo11.app.domain.repositories.ClienteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AssinaturaService {

    private final AssinaturaRepositorio assinaturaRepositorio;

    private final AplicativoRepositorio aplicativoRepositorio;

    private final ClienteRepositorio clienteRepositorio;

    public AssinaturaService(AssinaturaRepositorio assinaturaRepositorio, AplicativoRepositorio aplicativoRepositorio, ClienteRepositorio clienteRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.aplicativoRepositorio = aplicativoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public Assinatura criarAssinatura(CriaAssinaturaDTO criaAssinaturaDTO) {
        Assinatura assinatura = new Assinatura();

        Aplicativo aplicativo = aplicativoRepositorio.findById(criaAssinaturaDTO.id_aplicativo()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aplicativo não encontrado"));
        Cliente cliente = clienteRepositorio.findById(criaAssinaturaDTO.id_cliente()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        boolean b = assinaturaRepositorio.existsByCliente_idClienteAndAplicativo_idAplicativo(cliente.getIdCliente(), aplicativo.getIdAplicativo());

        if(b){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente já possui assinatura para esse aplicativo");
        }

        assinatura.setAplicativo(aplicativo);
        assinatura.setCliente(cliente);
        assinatura.setInicio_vigencia(LocalDate.now());
        assinatura.setFim_vigencia(LocalDate.now().plusMonths(1));
        assinatura.setStatusAssinatura(Status.ATIVA);
        return assinaturaRepositorio.save(assinatura);
    }

    public List<Assinatura> getAssinaturasPorTipo(StatusAssinatura statusAssinatura){
        switch (statusAssinatura) {
            case TODAS:
                return assinaturaRepositorio.findAll();
            case ATIVAS:
                return assinaturaRepositorio.findAllByStatusAssinatura(Status.ATIVA);
            case CANCELADAS:
                return assinaturaRepositorio.findAllByStatusAssinatura(Status.CANCELADA);
            default:
                return null;
        }
    }

    public List<Assinatura> getAssinaturasPorCliente(UUID codcli){
        Cliente cliente = clienteRepositorio.findById(codcli).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        return assinaturaRepositorio.findAllByCliente(cliente);
    }

    public List<Assinatura> getAssinaturasPorAplicativo(UUID codapp){
        Aplicativo aplicativo = aplicativoRepositorio.findById(codapp).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aplicativo não encontrado"));
        return assinaturaRepositorio.findAllByAplicativo(aplicativo);
    }

public Assinatura validaAssinatura(UUID codass){
    return assinaturaRepositorio.findById(codass).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assinatura não encontrada"));
    }


}
