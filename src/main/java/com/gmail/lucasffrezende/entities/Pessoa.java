package com.gmail.lucasffrezende.entities;

public class Pessoa {
    private String nome;
    private String bairro;

    public Pessoa(String nome, String bairro) {
        this.nome = nome;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return getNome() + ", " + getBairro();
    }
}
