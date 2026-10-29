package org.example.Usuarios;

import org.example.Exceptions.DadoInvalidoException;
import org.example.Exceptions.JogoNaoEncontradoException;
import org.example.Jogos.Jogo;
import org.example.Jogos.JogoDigital;
import org.example.Jogos.JogoFisico;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private Boolean ativo;
    private List<Jogo> jogos;

    public void adicionarJogo(Jogo jogo){
        if(jogo == null){
            throw new DadoInvalidoException();
        }
        jogos.add(jogo);
    }

    public List<Jogo> buscarJogosPorGerero(String genero){
        List<Jogo> jogosGenero = new ArrayList<>();
        if(genero == null || genero.isBlank()){
            throw new DadoInvalidoException();
        }
        for (int i = 0; i < jogos.size(); i++) {
            if(jogos.get(i).getGenero().equalsIgnoreCase(genero)){
                jogosGenero.add(jogos.get(i));
            }
        }
        return jogosGenero;
    }

    public List<JogoDigital> buscarJogosDigitais(){
        List<JogoDigital> jogosDigitais = new ArrayList<>();
        for (int i = 0; i < jogos.size(); i++) {
            if(jogos.get(i) instanceof JogoDigital jogoDigital){
                jogosDigitais.add(jogoDigital);
            }
        }
        return jogosDigitais;
    }

    public List<JogoFisico> buscarJogosFisicos(){
        List<JogoFisico> jogosFisicos = new ArrayList<>();
        for (int i = 0; i < jogos.size(); i++) {
            if(jogos.get(i) instanceof JogoFisico jogoFisico){
                jogosFisicos.add(jogoFisico);
            }
        }
        return jogosFisicos;
    }

    public Jogo buscarJogoPorNome (String nome){
        if(nome == null || nome.isBlank()){
            throw new DadoInvalidoException();
        }
        for (int i = 0; i < jogos.size(); i++) {
            if(jogos.get(i).getNome().equalsIgnoreCase(nome)){
                return jogos.get(i);
            }
        }
        throw new JogoNaoEncontradoException();
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", ativo=" + ativo +
                ", jogos=" + jogos +
                '}';
    }

    public Usuario(String nome, String cpf) {
        if(nome == null || cpf == null || nome.isBlank() || cpf.isBlank()){
            throw new DadoInvalidoException();
        }
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = true;
        this.jogos = new ArrayList<>();
    }
}
