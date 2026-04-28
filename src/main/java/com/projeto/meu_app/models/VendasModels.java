package com.projeto.meu_app.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas")
public class VendasModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer id;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @ManyToOne
    @JoinColumn(name = "id_imovel") 
    private ImoveisModels imovel;

    @ManyToOne
    @JoinColumn(name = "id_cliente") 
    private ClienteModels comprador;

    @ManyToOne
    @JoinColumn(name = "id_corretor")
    private CorretoresModels corretor;

    public VendasModels() {
    }

    public VendasModels(Integer id, LocalDate dataVenda, ImoveisModels imovel, ClienteModels comprador,
            CorretoresModels corretor) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.imovel = imovel;
        this.comprador = comprador;
        this.corretor = corretor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ImoveisModels getImovel() {
        return imovel;
    }

    public void setImovel(ImoveisModels imovel) {
        this.imovel = imovel;
    }

    public ClienteModels getComprador() {
        return comprador;
    }

    public void setComprador(ClienteModels comprador) {
        this.comprador = comprador;
    }

    public CorretoresModels getCorretor() {
        return corretor;
    }

    public void setCorretor(CorretoresModels corretor) {
        this.corretor = corretor;
    }

    



    


    
}
