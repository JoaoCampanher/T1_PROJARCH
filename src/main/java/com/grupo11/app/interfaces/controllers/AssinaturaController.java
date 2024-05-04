package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.application.DTOs.CriaAssinaturaDTO;
import com.grupo11.app.domain.entity.Assinatura;
import com.grupo11.app.domain.entity.enums.StatusAssinatura;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AssinaturaController {

    @PostMapping("/servcad/assinaturas")
    public ResponseEntity<Assinatura> criarAssinatura(@Valid @RequestBody CriaAssinaturaDTO assinaturaDTO){
        return null;
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public ResponseEntity<List<Assinatura>> getAssinaturasPorTipo(@RequestParam("tipo") StatusAssinatura statusAssinatura){
        return null;
    }

    @GetMapping("/servcad/asscli/{codcli}")
    public List<Assinatura> getAssinaturasPorCliente(@PathVariable("codcli") UUID codcli){
        return null;
    }

    @GetMapping("/servcad/assapp/{codapp}")
    public List<Assinatura> getAssinaturasPorAplicativo(@PathVariable("codapp") UUID codapp){
        return null;
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean validaAssinatura(@PathVariable("codass") UUID codass){
        return false;
    }


}
