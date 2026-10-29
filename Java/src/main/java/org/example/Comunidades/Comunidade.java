package org.example.Comunidades;

import org.example.Exceptions.DadoInvalidoException;
import org.example.Exceptions.UsuarioNaoEncontradoException;
import org.example.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Comunidade {
    private String nome;
    private List<Usuario> usuarios;

public void adicionarUsuario(Usuario usuario){
    if (usuario == null){
        throw new DadoInvalidoException();
    }
    usuarios.add(usuario);
}

public List<Usuario> buscarUsuariosAtivos(){
    List<Usuario> usuariosAtivos = new ArrayList<>();
    for (int i = 0; i < usuarios.size(); i++) {
        if(usuarios.get(i).getAtivo() == true){
            usuariosAtivos.add(usuarios.get(i));
        }
    }
    return usuariosAtivos;
}

public void desativarUsuario(Usuario usuario){
    if(usuario == null){
        throw new DadoInvalidoException();
    }
    if(usuario.getAtivo() == true){
        usuario.setAtivo(false);
    }
}

public void reativarUsuario(Usuario usuario){
    if(usuario == null){
        throw new DadoInvalidoException();
    }
    if(usuario.getAtivo() == false){
        usuario.setAtivo(true);
    }
}

public Usuario buscarUsuarioPorCpf(String cpf){
    if(cpf == null || cpf.isBlank()){
        throw new DadoInvalidoException();
    }
    for (int i = 0; i < usuarios.size(); i++) {
        if(usuarios.get(i).getCpf().equalsIgnoreCase(cpf)){
            return usuarios.get(i);
        }
    }
    throw new UsuarioNaoEncontradoException();
}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Comunidade{" +
                "nome='" + nome + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }

    public Comunidade(String nome) {
        if(nome == null || nome.isBlank()){
            throw new DadoInvalidoException();
        }
        this.nome = nome;
        this.usuarios = new ArrayList<>();
    }
}
