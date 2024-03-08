package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Usuario;
import com.example.repository.UsuarioRepository;
import com.example.servicio.UsuarioAServicio;

@Controller
public class UsuarioController {

	@Autowired
    private UsuarioAServicio UsuarioAServicio;
	 
	
	@GetMapping("/usuarios")
	    public String listarUsuarios(Model model) {
	        List<Usuario> usuarios = UsuarioAServicio.listAll();
	        model.addAttribute("usuarios", usuarios);
	        return "listaUsuarios";
	    }

	    @GetMapping("/usuarios/nuevo")
	    public String mostrarFormularioUsuario(Model model) {
	        model.addAttribute("usuario", new Usuario());
	        return "formularioUsuario";
	    }

	    @PostMapping("/usuarios/nuevo")
	    public String agregarUsuario(@ModelAttribute Usuario usuario) {
	        UsuarioAServicio.guardarUsuario(usuario);
	        return "redirect:/usuarios";
	    }
	}
