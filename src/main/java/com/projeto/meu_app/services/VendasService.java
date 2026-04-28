package com.projeto.meu_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.meu_app.models.VendasModels;
import com.projeto.meu_app.repositories.ClienteRepository;
import com.projeto.meu_app.repositories.CorretoresRepository;
import com.projeto.meu_app.repositories.ImoveisRepository;
import com.projeto.meu_app.repositories.VendasRepository;

@Service
public class VendasService {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CorretoresRepository corretoresRepository;

    @Autowired
    private ImoveisRepository imoveisRepository;

    // Listar todas as vendas
    public List<VendasModels> listarVendas(){
        return vendasRepository.findAll();
    }

    // Buscar venda por ID
    public VendasModels buscarVendaPorId(Integer id){
        return vendasRepository.findById(id).orElse(null);
    }

    public VendasModels cadastrarVenda(VendasModels venda){
        Integer idCliente = venda.getComprador().getId();
        Integer idCorretor = venda.getCorretor().getId();
        Integer idImovel = venda.getImovel().getId();
        boolean clienteExiste = clienteRepository.existsById(idCliente);
        boolean corretorExiste = corretoresRepository.existsById(idCorretor);
        boolean imovelExiste = imoveisRepository.existsById(idImovel);

        if (clienteExiste && corretorExiste && imovelExiste) {
            return vendasRepository.save(venda);
        }

        return null;

    }
    







}
