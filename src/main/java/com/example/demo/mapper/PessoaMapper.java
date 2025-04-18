package com.example.demo.mapper;

import com.example.demo.dto.PessoaDTO;
import com.example.demo.model.Pessoa;

public class PessoaMapper {
    public static PessoaDTO paraDTO (Pessoa pessoa){
        return new PessoaDTO(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getTrabalho().getEndereco()
        );
    }
}