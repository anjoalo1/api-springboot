package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.pojo.UsuarioPojo;
import com.example.demo.domain.service.IUsuarioService;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {
	
	private final IUsuarioService iUsuarioService;

	public UsuarioController(IUsuarioService iUsuarioService) {
		this.iUsuarioService = iUsuarioService;
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioPojo>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(iUsuarioService.getAll());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<UsuarioPojo> getUsuario(@PathVariable Long id){
		return ResponseEntity.of(iUsuarioService.getUsuario(id));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioPojo> save(@RequestBody UsuarioPojo usuarioPojoNew){
		return ResponseEntity.status(HttpStatus.CREATED).body(iUsuarioService.save(usuarioPojoNew));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
