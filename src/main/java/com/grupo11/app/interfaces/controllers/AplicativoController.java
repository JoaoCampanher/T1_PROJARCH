package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.domain.entity.Aplicativo;
import com.grupo11.app.domain.services.AplicativoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
public class AplicativoController {

    private final AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    @GetMapping("/servcad/aplicativos")
    public ResponseEntity<List<Aplicativo>> getTodosAplicativos(){
        List<Aplicativo> aplicativos = aplicativoService.listaTodosAplicativos();
        return ResponseEntity.ok(aplicativos);
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public ResponseEntity<Aplicativo> atualizaCustoAplicativo(@PathVariable("idAplicativo") UUID idAplicativo, @RequestBody BigDecimal valor){
        Aplicativo aplicativo = aplicativoService.atualizaCustoAplicativo(idAplicativo, valor);
        return ResponseEntity.ok(aplicativo);
    }

}
