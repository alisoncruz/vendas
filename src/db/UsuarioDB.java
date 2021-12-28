package db;

import models.Cliente;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDB {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void addUsuario(Usuario usuario) {
        int id = this.getUsuarios().size() + 1;
        usuario.setId(id);
        this.getUsuarios().add(usuario);
    }

    public Usuario getUsuarioPorId(int idCliente) {
        Usuario usuario = this.getUsuarios().stream().filter(u -> u.getId() == idCliente).findAny().orElse(null);
        if(usuario == null) throw new RuntimeException("Usuário não cadastrado");
        return usuario;
    }
}
