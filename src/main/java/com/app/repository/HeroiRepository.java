package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Heroi;

public interface HeroiRepository extends JpaRepository<Heroi, Long>{

}
