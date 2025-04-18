package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.model.PessoaDTO;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    private ResponseEntity<List<Pessoa>> buscarPessoas(){
        List<Pessoa> pessoas = pessoaService.listaPessoas();
        if (pessoas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Pessoa> buscarPorId(@PathVariable int id){
        Pessoa pessoaExis = pessoaService.buscarPessoaPorId(id);
        if (pessoaExis == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoaExis);
    }

    @PostMapping
    private ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaNova = pessoaService.criarPessoa(pessoa);
        if(pessoaNova == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoaNova);
    }

    //Post com Pessoa DTO
    @PostMapping("/DTO")
    private ResponseEntity<PessoaDTO> criarPessoaDTO(@RequestBody PessoaDTO pessoaDTO){
        PessoaDTO pessoaNovaDTO = pessoaService.criarPessoaDTO(pessoaDTO);
        if(pessoaNovaDTO == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoaNovaDTO);
    }

    @PutMapping("/{id}/mudar")
    private ResponseEntity<Pessoa> mudarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa){
        Pessoa pessoaMod = pessoaService.modificarPessoa(id, pessoa);
        if(pessoa == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoaMod);
    }

    @DeleteMapping("/{id}")
    private void deletarPessoa(@PathVariable int id){
        pessoaService.deletarPessoa(id);
    }
}
