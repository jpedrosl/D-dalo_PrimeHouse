package com.projeto.meu_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeuAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuAppApplication.class, args);
		System.out.println("Aplicação MeuApp está rodando!");
	}

}
