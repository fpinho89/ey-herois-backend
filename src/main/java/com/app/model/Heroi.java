package com.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Heroi {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@ManyToMany
    @JoinTable(name = "heroi_poder",
        joinColumns = @JoinColumn(name = "heroi_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "poder_id", referencedColumnName = "id"))
	private List<Poder> poderes;
	
	@ManyToOne
	@JoinColumn(name = "universo_id")
	private Universo universo;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro = new Date();

	private boolean ativo = true;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Poder> getPoderes() {
		return poderes;
	}

	public void setPoderes(List<Poder> poderes) {
		this.poderes = poderes;
	}

	public Universo getUniverso() {
		return universo;
	}

	public void setUniverso(Universo universo) {
		this.universo = universo;
	}

	@Override
	public String toString() {
		return "Heroi [id=" + id + ", nome=" + nome + ", poderes=" + poderes + ", universo=" + universo + "]";
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
