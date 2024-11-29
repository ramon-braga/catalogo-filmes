package com.example.catalogo_filmes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo_filmes.model.Filme;
import com.example.catalogo_filmes.service.FilmeService;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    // Listar todos os filmes
    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarTodos();
    }

    // Buscar filme por ID
    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarFilmePorId(@PathVariable int id) {
        Optional<Filme> filme = filmeService.buscarPorId(id);
        return filme.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Adicionar um novo filme
    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        Filme filmeSalvo = filmeService.salvar(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
    }

    // Atualizar um filme existente
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable int id, @RequestBody Filme novoFilme) {
        Optional<Filme> filmeAtualizado = filmeService.atualizar(id, novoFilme);
        return filmeAtualizado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable int id) {
        boolean excluido = filmeService.excluir(id);
        if (excluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
