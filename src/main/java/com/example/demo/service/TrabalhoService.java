package com.example.demo.service;

import com.example.demo.dto.TrabalhoCriarDTO;
import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.mapper.TrabalhoMapper;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repo;

    public TrabalhoDTO criar(TrabalhoCriarDTO dto) {
        Trabalho trabalho = new Trabalho(dto.getEndereco());
        trabalho = repo.save(trabalho);
        return TrabalhoMapper.paraDTO(trabalho);
    }

    public List<TrabalhoDTO> listar() {
        return repo.findAll().stream().map(TrabalhoMapper::paraDTO).toList();
    }

    public TrabalhoDTO buscar(Long id) {
        return repo.findById(id).map(TrabalhoMapper::paraDTO).orElse(null);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}