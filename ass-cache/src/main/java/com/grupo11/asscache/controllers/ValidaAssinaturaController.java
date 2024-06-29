package com.grupo11.asscache.controllers;

import com.grupo11.asscache.dtos.AssinaturaStatusDTO;
import com.grupo11.asscache.services.ValidaAssinaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ValidaAssinaturaController {

    private final ValidaAssinaturaService assinaturaService;

    public ValidaAssinaturaController(ValidaAssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean validaAssinatura(@PathVariable("codass") UUID codass){
        System.out.println("Validando assinatura: " + codass);
       return assinaturaService.validaAssinatura(codass);
    }

}
