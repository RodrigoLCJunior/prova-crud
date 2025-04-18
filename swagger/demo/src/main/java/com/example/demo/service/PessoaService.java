package com.example.demo.service;

import com.example.demo.model.Pessoa;
import com.example.demo.model.PessoaDTO;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listaPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorId(int id){
        return pessoaRepository.findById(id).get();
    }

    public Pessoa criarPessoa(Pessoa pessoa){
        if (pessoa.getTrabalho() == null){
            pessoa.setTrabalho(null);
        }
        return pessoaRepository.save(pessoa);
    }

    //Criar com DTO
    public PessoaDTO criarPessoaDTO(PessoaDTO pessoaDTO){
        if (pessoaDTO.getTrabalho() == null){
            pessoaDTO.setTrabalho(null);
        }

        Pessoa pessoa = PessoaDTO.transform(pessoaDTO);
        pessoaRepository.save(pessoa);

        return PessoaDTO.transform(pessoa);
    }

    public Pessoa modificarPessoa(int id, Pessoa pessoa){
        Pessoa pessoaExis = buscarPessoaPorId(id);
        if (pessoaExis != null){
            pessoaExis.setCpf(pessoa.getCpf());
            pessoaExis.setNome(pessoa.getNome());
            pessoaExis.setTrabalho(pessoa.getTrabalho());
            return pessoaRepository.save(pessoaExis);
        }
        return null;
    }

    public void deletarPessoa(int id){
        pessoaRepository.deleteById(id);
    }
}
