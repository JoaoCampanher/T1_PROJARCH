package com.grupo11.app.domain.services;

import com.grupo11.app.domain.entity.Cliente;
import com.grupo11.app.domain.repositories.ClienteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteService(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<Cliente> getTodosClientes() {
        return clienteRepositorio.findAll();
    }

}
