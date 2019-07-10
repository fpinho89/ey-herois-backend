package com.app.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Poder;
import com.app.repository.PoderRepository;

@Service
public class PoderService {

	@Autowired
	private PoderRepository repository;
	
	public List<Poder> listar() {
		return this.repository.findAll();
	}
}
