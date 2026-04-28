package com.projeto.meu_app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.meu_app.models.ImoveisModels;
import com.projeto.meu_app.repositories.ImoveisRepository;
import com.projeto.meu_app.repositories.ClienteRepository;

@Service
public class ImoveisService {

    // Injeção do repositório de Imóveis para salvar e buscar dados de imóveis
    @Autowired
    private ImoveisRepository repository;

    // repositório de Clientes para validar se o proprietário existe
    @Autowired
    private ClienteRepository clienteRepository;

    // Método para listar todos os imóveis cadastrados
    public List<ImoveisModels> listarTodos() {
        return repository.findAll();
    }

    // Método para buscar um imóvel específico pelo seu ID
    public ImoveisModels buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Método para cadastrar um novo imóvel
    public ImoveisModels cadastrarImovel(ImoveisModels imovel) {
    // 1. Verifica se a lista de donos não está vazia
    if (imovel.getProprietario() != null && !imovel.getProprietario().isEmpty()) {
        
        // 2. Pega o ID do primeiro dono da lista
        Integer idDono = imovel.getProprietario().get(0).getId();

        // 3. Verifica se esse dono existe no banco
        if (clienteRepository.existsById(idDono)) {
            return repository.save(imovel);
        }
    }
    return null;
  }

    // Método para deletar um imóvel
    public boolean deletarImovel(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}