package com.example.app2_exer;

public class Entidade {
    private long id;
    private String nome;
    private int idade;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\n" +
                "nome: '" + nome +
                "\n" +
                "idade: " + idade +
                "\n" +
                "email: " + email;
    }
}
