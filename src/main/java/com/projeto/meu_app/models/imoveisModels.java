package com.projeto.meu_app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "imoveis")    
public class imoveisModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_imovel")
    private Integer id;

    @Column(name = "valor_imovel")
    private Double valorImovel;

    @Column(name = "bairro_imovel", length = 100)
    private String bairroImovel;

    @OneToMany
    @JoinColumn(name = "id_cliente")
    private List<clienteModels> proprietario;

    public imoveisModels() {
    }

    public imoveisModels(Integer id, Double valorImovel, String bairroImovel, List<clienteModels> proprietario) {
        this.id = id;
        this.valorImovel = valorImovel;
        this.bairroImovel = bairroImovel;
        this.proprietario = proprietario;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public Double getValorImovel() {
        return valorImovel;
    }
    public void setValorImovel(Double valorImovel) {
        this.valorImovel = valorImovel;
    }


    public String getBairroImovel() {
        return bairroImovel;
    }
    public void setBairroImovel(String bairroImovel) {
        this.bairroImovel = bairroImovel;
    }


    public List<clienteModels> getProprietario() {
        return proprietario;
    }
    public void setProprietario(List<clienteModels> proprietario) {
        this.proprietario = proprietario;
    }

    

}
    