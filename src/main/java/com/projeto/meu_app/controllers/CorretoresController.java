package com.projeto.meu_app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projeto.meu_app.models.CorretoresModels;
import com.projeto.meu_app.services.CorretoresService;

@RestController
@RequestMapping("/corretores")
public class CorretoresController {

    @Autowired
    private CorretoresService corretoresService;

    @GetMapping
    public List<CorretoresModels> listarTodos() {
        return corretoresService.listarCorretores();
    }

    @GetMapping("/{id}")
    public CorretoresModels buscarPorId(@PathVariable Integer id) {
        return corretoresService.buscarCorretorPorId(id);
    }

    @PostMapping
    public CorretoresModels salvar(@RequestBody CorretoresModels corretor) {
        return corretoresService.cadastroCorretor(corretor);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Integer id) {
        return corretoresService.deletarCorretor(id);
    }
}