package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.application.DTOs.PagamentoDTO;
import com.grupo11.app.application.DTOs.RespostaPagamentoDTO;
import com.grupo11.app.domain.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/registrarpagamento")
    public ResponseEntity<RespostaPagamentoDTO > registrarPagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO){
        RespostaPagamentoDTO respostaPagamentoDTO = pagamentoService.registrarPagamento(pagamentoDTO);
        return ResponseEntity.ok(respostaPagamentoDTO);
    }

}
