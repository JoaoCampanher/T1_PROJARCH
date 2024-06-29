package com.grupo11.app.interfaces.controllers;

import com.grupo11.app.domain.entity.Cliente;
import com.grupo11.app.domain.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/servcad/clientes")
    public ResponseEntity<List<Cliente>> getTodosClientes(){
        List<Cliente> todosClientes = clienteService.getTodosClientes();
        return ResponseEntity.ok(todosClientes);
    }

}
