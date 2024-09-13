package com.example.ac1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ac1.model.Categoria;
import com.example.ac1.model.Produto;

@SpringBootApplication
public class Ac1Application {

    private static final Logger logger = LoggerFactory.getLogger(Ac1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Ac1Application.class, args);

        logger.info("Aplicação iniciada com sucesso.");

        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        Categoria categoria1 = new Categoria(1, "Celular");
        Categoria categoria2 = new Categoria(2, "Teclado");

        logger.info("Produto 1 criado: {}", produto1);
        logger.info("Produto 2 criado: {}", produto2);
        logger.info("Categoria 1 criada: {}", categoria1);
        logger.info("Categoria 2 criada: {}", categoria2);
    }
}