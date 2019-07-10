package com.app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Universo;
import com.app.servico.UniversoService;

@RestController
@Scope("request")
@RequestMapping("/universos")
@CrossOrigin(origins = "http://localhost:4200")
public class UniversoController {

	@Autowired
	private UniversoService service;
	
	@GetMapping
	public List<Universo> listar() {
		return this.service.listar();
	}
}
