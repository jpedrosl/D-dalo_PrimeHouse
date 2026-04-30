package com.projeto.meu_app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projeto.meu_app.models.ImoveisModels;
import com.projeto.meu_app.services.ImoveisService;

@RestController
@RequestMapping("/imoveis")
public class ImoveisController {

    @Autowired
    private ImoveisService imoveisService;

    @GetMapping
    public List<ImoveisModels> listarTodos() {
        return imoveisService.listarTodos();
    }

    @GetMapping("/{id}")
    public ImoveisModels buscarPorId(@PathVariable Integer id) {
        return imoveisService.buscarPorId(id);
    }

    @PostMapping
    public ImoveisModels salvar(@RequestBody ImoveisModels imovel) {
        return imoveisService.cadastrarImovel(imovel);
    }

    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Integer id) {
        return imoveisService.deletarImovel(id);
    }
}