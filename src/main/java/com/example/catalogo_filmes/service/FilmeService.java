package com.example.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogo_filmes.model.Filme;
import com.example.catalogo_filmes.repository.FilmeRepository;

@Service
public class FilmeService {
    
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarPorId(int id) {
        return filmeRepository.findById(id);
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Optional<Filme> atualizar(int id, Filme novoFilme) {
        return filmeRepository.findById(id).map(filme -> {
            filme.setTitulo(novoFilme.getTitulo());
            filme.setDiretor(novoFilme.getDiretor());
            filme.setGenero(novoFilme.getGenero());
            filme.setAnoLancamento(novoFilme.getAnoLancamento());
            filme.setClassificacao(novoFilme.getClassificacao());
            filme.setSinopse(novoFilme.getSinopse());
            return filmeRepository.save(filme);
        });
    }

    public boolean excluir(int id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
