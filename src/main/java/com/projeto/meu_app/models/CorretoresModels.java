package com.projeto.meu_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "corretores")
public class CorretoresModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corretor")
    private Integer id;

    @Column(name = "nome_corretor", length = 100)
    private String nomeCorretor;

    public CorretoresModels() {
    }

    public CorretoresModels(Integer id, String nomeCorretor) {
        this.id = id;
        this.nomeCorretor = nomeCorretor;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
  

    public String getNomeCorretor() {
        return nomeCorretor;
    }
    public void setNomeCorretor(String nomeCorretor) {
        this.nomeCorretor = nomeCorretor;
    }

    

    
}
