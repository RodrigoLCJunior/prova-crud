package com.example.demo.service;

import com.example.demo.model.Pessoa;
import com.example.demo.model.PessoaDTO;
import com.example.demo.model.Trabalho;
import com.example.demo.model.TrabalhoDTO;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<Trabalho> listaTrabalho(){
        return trabalhoRepository.findAll();
    }

    public Trabalho buscarTrabalhoPorId(int id){
        return trabalhoRepository.findById(id).get();
    }

    public Trabalho criarTrabalho(Trabalho trabalho){
        return trabalhoRepository.save(trabalho);
    }

    //Criar com DTO
    public TrabalhoDTO criarTrabalhoDTO(TrabalhoDTO trabalhoDTO){

        Trabalho trabalho = TrabalhoDTO.transform(trabalhoDTO);
        trabalhoRepository.save(trabalho);

        return TrabalhoDTO.transform(trabalho);
    }

    public Trabalho modificarTrabalho(int id, Trabalho trabalho){
        Trabalho trabalhoExis = buscarTrabalhoPorId(id);

        if (trabalhoExis != null){
            trabalhoExis.setEndereco(trabalho.getEndereco());
        }
        return null;
    }

    public void deletarTrabalho(int id){
        trabalhoRepository.deleteById(id);
    }
}
