package com.example.ac1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac1.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}