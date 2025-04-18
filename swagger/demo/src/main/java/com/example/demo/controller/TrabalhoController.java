package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.model.PessoaDTO;
import com.example.demo.model.Trabalho;
import com.example.demo.model.TrabalhoDTO;
import com.example.demo.service.PessoaService;
import com.example.demo.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    private ResponseEntity<List<Trabalho>> buscarTrabalhos(){
        List<Trabalho> trabalhos = trabalhoService.listaTrabalho();
        if (trabalhos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabalhos);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Trabalho> buscarPorId(@PathVariable int id){
        Trabalho trabalhoExis = trabalhoService.buscarTrabalhoPorId(id);
        if (trabalhoExis == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabalhoExis);
    }

    @PostMapping
    private ResponseEntity<Trabalho> criarTrabalho(@RequestBody Trabalho trabalho){
        Trabalho trabalhoNova = trabalhoService.criarTrabalho(trabalho);
        if(trabalhoNova == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabalhoNova);
    }

    //Post com Pessoa DTO
    @PostMapping("/DTO")
    private ResponseEntity<TrabalhoDTO> criarTrabalhoDTO(@RequestBody TrabalhoDTO trabalhoDTO){
        TrabalhoDTO trabalhoNovoDTO = trabalhoService.criarTrabalhoDTO(trabalhoDTO);
        if(trabalhoNovoDTO == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabalhoNovoDTO);
    }

    @PutMapping("/{id}/mudar")
    private ResponseEntity<Trabalho> mudarPessoa(@PathVariable int id, @RequestBody Trabalho trabalho){
        Trabalho trabalhoMod = trabalhoService.modificarTrabalho(id, trabalho);
        if(trabalhoMod == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabalhoMod);
    }

    @DeleteMapping("/{id}")
    private void deletarTrabalho(@PathVariable int id){
        trabalhoService.deletarTrabalho(id);
    }
}
