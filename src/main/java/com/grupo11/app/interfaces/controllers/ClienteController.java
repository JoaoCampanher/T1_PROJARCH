package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.domain.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/servcad/clientes")
    public ResponseEntity<List<Cliente>> getTodosClientes(){
     return null;
    }

}
