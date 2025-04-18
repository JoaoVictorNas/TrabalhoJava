package com.example.demo.service;

import com.example.demo.dto.PessoaCriarDTO;
import com.example.demo.dto.PessoaDTO;
import com.example.demo.mapper.PessoaMapper;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepo;

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public PessoaDTO criar(PessoaCriarDTO dto) {
        Trabalho trabalho = trabalhoRepo.findById(dto.getTrabalhoId()).orElseThrow();
        Pessoa pessoa = new Pessoa(dto.getNome(), dto.getCPF(), trabalho);
        pessoa = pessoaRepo.save(pessoa);
        return PessoaMapper.paraDTO(pessoa);
    }

    public List<PessoaDTO> listar() {
        return pessoaRepo.findAll().stream().map(PessoaMapper::paraDTO).toList();
    }

    public PessoaDTO buscar(Long id) {
        return pessoaRepo.findById(id).map(PessoaMapper::paraDTO).orElse(null);
    }

    public void deletar(Long id) {
        pessoaRepo.deleteById(id);
    }


}