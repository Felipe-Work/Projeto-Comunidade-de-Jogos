package org.example.Jogos;

import org.example.Exceptions.DadoInvalidoException;

public class JogoDigital extends Jogo{
 private String codigoDeAcesso;

    public String getCodigoDeAcesso() {
        return codigoDeAcesso;
    }

    public void setCodigoDeAcesso(String codigoDeAcesso) {
        this.codigoDeAcesso = codigoDeAcesso;
    }

    @Override
    public String toString() {
        return "JogoDigital{" +
                "codigoDeAcesso='" + codigoDeAcesso + '\'' +
                '}';
    }

    public JogoDigital(String nome, String genero, Double preco, String plataforma, String codigoDeAcesso) {
        super(nome, genero, preco, plataforma);
        if(codigoDeAcesso == null || codigoDeAcesso.isBlank()){
            throw new DadoInvalidoException();
        }
        this.codigoDeAcesso = codigoDeAcesso;
    }
}
