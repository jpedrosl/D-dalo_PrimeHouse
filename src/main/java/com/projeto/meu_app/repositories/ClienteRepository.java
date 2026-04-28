package com.projeto.meu_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.meu_app.models.ClienteModels;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModels, Integer> {

}
