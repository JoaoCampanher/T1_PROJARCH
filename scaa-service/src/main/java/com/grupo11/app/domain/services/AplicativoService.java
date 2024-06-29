package com.grupo11.app.domain.services;

import com.grupo11.app.domain.entity.Aplicativo;
import com.grupo11.app.domain.repositories.AplicativoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class AplicativoService {

    private final AplicativoRepositorio aplicativoRepositorio;


    public AplicativoService(AplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public List<Aplicativo> listaTodosAplicativos(){
        return aplicativoRepositorio.findAll();
    }

    public Aplicativo atualizaCustoAplicativo(UUID idAplicativo , BigDecimal valor){
        Aplicativo aplicativo = aplicativoRepositorio.findById(idAplicativo).orElseThrow(() -> new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Aplicativo não encontrado"));
        aplicativo.setValor(valor);
        return aplicativoRepositorio.save(aplicativo);
    }


}
