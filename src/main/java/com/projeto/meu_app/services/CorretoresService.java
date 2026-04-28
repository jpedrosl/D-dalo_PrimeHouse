package com.projeto.meu_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.meu_app.models.CorretoresModels;
import com.projeto.meu_app.repositories.CorretoresRepository;

@Service
public class CorretoresService {

    
    @Autowired
    private CorretoresRepository corretoresRepository;

    public List<CorretoresModels> listarCorretores(){
        return corretoresRepository.findAll();    
    }

    public CorretoresModels buscarCorretorPorId(Integer id){
        return corretoresRepository.findById(id).orElse(null);
    }

    public CorretoresModels cadastroCorretor(CorretoresModels corretor) {
        if (corretor != null) {
            return corretoresRepository.save(corretor);
        }
        return null;
    }

    public boolean deletarCorretor(Integer id){
        if(corretoresRepository.existsById(id)){
           corretoresRepository.deleteById(id);
           return true;
        }
        return false;
    }






}
    

