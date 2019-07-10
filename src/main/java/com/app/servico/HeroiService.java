package com.app.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Heroi;
import com.app.repository.HeroiRepository;

@Service
public class HeroiService {

	@Autowired
	private HeroiRepository repository;
	
	public List<Heroi> listar() {
		return this.repository.findAll().stream().filter(h -> h.isAtivo()).collect(Collectors.toList());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Heroi heroi) {
		this.repository.save(heroi);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		Heroi heroi = this.repository.getOne(id);
		heroi.setAtivo(false);
		this.repository.save(heroi);
	}
}
