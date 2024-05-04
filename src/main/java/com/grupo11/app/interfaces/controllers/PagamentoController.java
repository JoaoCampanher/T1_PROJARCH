package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.application.DTOs.PagamentoDTO;
import com.grupo11.app.application.DTOs.RespostaPagamentoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    @PostMapping("/registrarpagamento")
    public RespostaPagamentoDTO registrarPagamento(@RequestBody PagamentoDTO pagamentoDTO){
        return null;
    }

}
