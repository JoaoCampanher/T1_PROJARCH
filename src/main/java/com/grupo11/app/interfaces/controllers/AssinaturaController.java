package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.application.DTOs.CriaAssinaturaDTO;
import com.grupo11.app.domain.entity.Assinatura;
import com.grupo11.app.domain.entity.enums.StatusAssinatura;
import com.grupo11.app.domain.services.AssinaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @PostMapping("/servcad/assinaturas")
    public ResponseEntity<Assinatura> criarAssinatura(@Valid @RequestBody CriaAssinaturaDTO assinaturaDTO){
        Assinatura assinatura = assinaturaService.criarAssinatura(assinaturaDTO);
        return ResponseEntity.status(201).body(assinatura);
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public ResponseEntity<List<Assinatura>> getAssinaturasPorTipo(@PathVariable("tipo") StatusAssinatura statusAssinatura){
        List<Assinatura> assinaturasPorTipo = assinaturaService.getAssinaturasPorTipo(statusAssinatura);
        return ResponseEntity.ok(assinaturasPorTipo);
    }

    @GetMapping("/servcad/asscli/{codcli}")
    public ResponseEntity<List<Assinatura>> getAssinaturasPorCliente(@PathVariable("codcli") UUID codcli){
        List<Assinatura> assinaturasPorCliente = assinaturaService.getAssinaturasPorCliente(codcli);
        return ResponseEntity.ok(assinaturasPorCliente);
    }

    @GetMapping("/servcad/assapp/{codapp}")
    public ResponseEntity<List<Assinatura>> getAssinaturasPorAplicativo(@PathVariable("codapp") UUID codapp){
        List<Assinatura> assinaturasPorAplicativo = assinaturaService.getAssinaturasPorAplicativo(codapp);
        return ResponseEntity.ok(assinaturasPorAplicativo);
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean validaAssinatura(@PathVariable("codass") UUID codass){
        return assinaturaService.validaAssinatura(codass);
    }

}
