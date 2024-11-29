package com.example.catalogo_filmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String diretor;
    private String genero;
    private int anoLancamento;
    private double classificacao;
    private String sinopse;

    // Construtores 

    public Filme() {}

    public Filme(String titulo, String diretor, String genero, int anoLancamento, double classificacao, String sinopse) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(double classificacao) {
        // Não deve aceitar uma classificação fora do intervalo de 0 à 5
        if (classificacao >= 0 && classificacao <= 5)
            this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

}
