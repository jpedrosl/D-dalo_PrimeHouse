package com.projeto.meu_app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projeto.meu_app.models.VendasModels;
import com.projeto.meu_app.services.VendasService;

@RestController // Avisa que isso é uma API que retorna dados (JSON)
@RequestMapping("/vendas") // O endereço base será http://localhost:8080/vendas
public class VendasController {

    @Autowired
    private VendasService vendasService; // Chama o "cérebro" que a gente criou antes

    // Rota para Listar Todas as Vendas
    @GetMapping // Quando alguém der um "GET" em /vendas
    public List<VendasModels> listarTodas() {
        return vendasService.listarVendas();
    }

    // Rota para Buscar uma Venda por ID
    @GetMapping("/{id}") // Ex: /vendas/5
    public VendasModels buscarPorId(@PathVariable Integer id) {
        return vendasService.buscarVendaPorId(id);
    }

    // Rota para Cadastrar uma Venda
    @PostMapping // Quando alguém enviar um "POST" com dados para /vendas
    public VendasModels salvar(@RequestBody VendasModels venda) {
        return vendasService.cadastrarVenda(venda);
    }

    // Rota para Deletar uma Venda
    @DeleteMapping("/{id}") // Ex: DELETE em /vendas/5
    public boolean deletar(@PathVariable Integer id) {
        return vendasService.deletarVenda(id);
    }
}