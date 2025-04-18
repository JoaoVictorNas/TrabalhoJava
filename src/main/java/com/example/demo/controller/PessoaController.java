package com.example.demo.controller;

import com.example.demo.dto.PessoaCriarDTO;
import com.example.demo.dto.PessoaDTO;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaDTO> criar(@RequestBody PessoaCriarDTO dto) {
        PessoaDTO pessoaSalva = service.criar(dto);

        return ResponseEntity.created(
                        UriComponentsBuilder
                                .newInstance()
                                .path("/pessoa/{id}")
                                .buildAndExpand(pessoaSalva.getId())
                                .toUri())
                .body(pessoaSalva);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listar() {
        List<PessoaDTO> pessoaListar = service.listar();

        return ResponseEntity.ok(pessoaListar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscar(@PathVariable Long id) {
        PessoaDTO pessoaBuscar = service.buscar(id);

        return ResponseEntity.ok(pessoaBuscar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}