package com.example.demo.model;

public class TrabalhoDTO {
    private int id;
    private String endereco;

    public static TrabalhoDTO transform(Trabalho trabalho){
        TrabalhoDTO trabalhoDTO = new TrabalhoDTO();
        trabalhoDTO.setEndereco(trabalho.getEndereco());
        trabalhoDTO.setId(trabalho.getId());
        return trabalhoDTO;
    }

    public static Trabalho transform(TrabalhoDTO trabalhoDTO){
        Trabalho trabalho = new Trabalho();
        trabalho.setEndereco(trabalhoDTO.getEndereco());
        trabalho.setId(trabalhoDTO.getId());
        return trabalho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
