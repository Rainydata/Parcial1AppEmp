package com.example.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Usuario;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioAServicio {
	
	@Autowired private UsuarioRepository repositorio;

    public List<Usuario> listAll(){
        return (List<Usuario>) repositorio.findAll();
    }
    
    public void guardarUsuario(Usuario usuario) {
        repositorio.save(usuario);
    }
}
