package com.app.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.model.Universo;
import com.app.repository.UniversoRepository;

@Service
public class UniversoService {

	@Autowired
	private UniversoRepository repository;
	
	@Cacheable("listaUniversos")
	public List<Universo> listar() {
		return this.repository.findAll();
	}
}
