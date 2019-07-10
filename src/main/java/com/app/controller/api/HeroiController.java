package com.app.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Heroi;
import com.app.servico.HeroiService;

@RestController
@Scope("request")
@RequestMapping("/herois")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroiController {

	@Autowired
	private HeroiService service;
	
	@GetMapping
	public List<Heroi> listar() {
		return this.service.listar();
	}
	
	@PostMapping(consumes = "application/json")
	public void add(@RequestBody Heroi heroi) {
		this.service.add(heroi);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}
}
