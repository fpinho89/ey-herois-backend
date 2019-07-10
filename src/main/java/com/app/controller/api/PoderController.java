package com.app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Poder;
import com.app.servico.PoderService;

@RestController
@Scope("request")
@RequestMapping("/poderes")
@CrossOrigin(origins = "http://localhost:4200")
public class PoderController {

	@Autowired
	private PoderService service;
	
	@GetMapping
	public List<Poder> listar() {
		return this.service.listar();
	}
}
