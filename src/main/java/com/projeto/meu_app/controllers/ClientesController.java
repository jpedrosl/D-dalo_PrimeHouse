package com.projeto.meu_app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projeto.meu_app.models.ClienteModels;
import com.projeto.meu_app.services.ClienteService; 

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService; 

    @GetMapping
    public List<ClienteModels> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteModels buscarPorId(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ClienteModels salvar(@RequestBody ClienteModels cliente) {
       
        return clienteService.cadastrar(cliente);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Integer id) {
        
        return clienteService.deletar(id);
    }
}