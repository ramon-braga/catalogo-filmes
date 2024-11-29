package com.example.catalogo_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo_filmes.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
