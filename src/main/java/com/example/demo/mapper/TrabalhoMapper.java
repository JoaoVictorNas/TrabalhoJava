package com.example.demo.mapper;

import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.model.Trabalho;

public class TrabalhoMapper {
    public static TrabalhoDTO paraDTO (Trabalho trabalho){
        return new TrabalhoDTO(
                trabalho.getId(),
                trabalho.getEndereco()
        );
    }
}