package org.example.Jogos;

import org.example.Exceptions.DadoInvalidoException;

public class Jogo {
    private String nome;
    private String genero;
    private Double preco;
    private String plataforma;

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", preco=" + preco +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }

    public Jogo(String nome, String genero, Double preco, String plataforma) {
        if(plataforma == null || nome == null || preco == null || genero == null || plataforma.isBlank() || nome.isBlank() || genero.isBlank() || preco < 0.0){
            throw new DadoInvalidoException();
        }
        this.nome = nome;
        this.genero = genero;
        this.preco = preco;
        this.plataforma = plataforma;
    }
}
