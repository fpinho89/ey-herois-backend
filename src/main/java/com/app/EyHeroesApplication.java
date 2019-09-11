package com.app;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Heroi;
import com.app.model.Poder;
import com.app.model.Universo;
import com.app.repository.HeroiRepository;
import com.app.repository.PoderRepository;
import com.app.repository.UniversoRepository;

@SpringBootApplication
public class EyHeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyHeroesApplication.class, args);
	}
	
	@Bean @Transactional(propagation = Propagation.REQUIRED)
    CommandLineRunner init(HeroiRepository heroiRepository, UniversoRepository universoRepository, PoderRepository poderRepository) {
        return args -> {
        
        	Poder p1 = new Poder("Invisibilidade");
        	Poder p2 = new Poder("Visão Nortuna");
        	Poder p3 = new Poder("Velocidade");
        	Poder p4 = new Poder("Magia");
        	Poder p5 = new Poder("Mutação");
        	poderRepository.saveAll(Arrays.asList(p1,p2,p3));
        	
        	Universo u1 = new Universo("EY Commics");
        	Universo u2 = new Universo("Trainee Commics");
        	Universo u3 = new Universo("Outros");
        	Universo u4 = new Universo("Mkt Commics");
        	universoRepository.saveAll(Arrays.asList(u1,u2,u3));
        	
        	Heroi h1 = new Heroi();
        	h1.setNome("Noturno");
        	h1.setUniverso(u1);
        	h1.setPoderes(Arrays.asList(p1, p2));
        	
        	Heroi h2 = new Heroi();
        	h2.setNome("Caverna");
        	h2.setUniverso(u2);
        	h2.setPoderes(Arrays.asList(p3));
        	
        	Heroi h3 = new Heroi();
        	h2.setNome("Rain");
        	h2.setUniverso(u4);
        	h2.setPoderes(Arrays.asList(p4, p5));
        	
        	
        	heroiRepository.saveAll(Arrays.asList(h1, h2));
        };
    }
}
