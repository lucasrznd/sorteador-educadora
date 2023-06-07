package com.gmail.lucasffrezende.entities;

public class Participante {
    private String nome;
    private String bairro;

    public Participante(String nome, String bairro) {
        this.nome = nome;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public String getBairro() {
        return bairro;
    }
}
