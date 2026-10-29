package org.example.Jogos;

import org.example.Exceptions.DadoInvalidoException;

public class JogoFisico extends Jogo{
private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "JogoFisico{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public JogoFisico(String nome, String genero, Double preco, String plataforma, String tipo) {
        super(nome, genero, preco, plataforma);
        if(tipo == null || tipo.isBlank() || (!(tipo.equalsIgnoreCase("cartucho")) && !(tipo.equalsIgnoreCase("cd")))){
            throw new DadoInvalidoException();
        }
        this.tipo = tipo;
    }
}
