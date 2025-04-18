package com.example.demo.model;

public class PessoaDTO {

    private int id;
    private String nome;
    private String cpf;
    private Trabalho trabalho;

    public static PessoaDTO transform(Pessoa pessoa){
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setTrabalho(pessoa.getTrabalho());
        return pessoaDTO;
    }

    public static Pessoa transform(PessoaDTO pessoaDTO){
        Pessoa pessoaNova = new Pessoa();
        pessoaNova.setId(pessoaDTO.getId());
        pessoaNova.setCpf(pessoaDTO.getCpf());
        pessoaNova.setNome(pessoaDTO.getNome());
        pessoaNova.setTrabalho(pessoaDTO.getTrabalho());
        return pessoaNova;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
