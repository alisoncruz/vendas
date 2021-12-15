package db;

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
}
