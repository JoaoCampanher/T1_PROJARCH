package com.grupo11.app.domain.services;

import com.grupo11.app.domain.repositories.AssinaturaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService {

    private final AssinaturaRepositorio assinaturaRepositorio;

    public AssinaturaService(AssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }




}
