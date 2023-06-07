package com.gmail.lucasffrezende.application;

import com.gmail.lucasffrezende.entities.Pessoa;

import java.util.*;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random sorteio = new Random();

        List<Pessoa> pessoas = new ArrayList<>();
        System.out.print("Quantas pessoas serão cadastradas?: ");
        int quantidadePessoa = sc.nextInt();

        for(int i = 1; i <= quantidadePessoa; i++) {
            sc.nextLine();
            System.out.println("\nDados da #" + i + " pessoa: ");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Bairro: ");
            String bairro = sc.nextLine();
            pessoas.add(new Pessoa(nome, bairro));
        }

        int index = sorteio.nextInt(pessoas.size());
        Pessoa pessoaSorteada = pessoas.get(index);

        System.out.println("O vencedor foi: " + pessoaSorteada);
        sc.close();
    }
}
