package br.com.devinhouse.backend.entities;


import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interessado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;
	
	@Column(nullable = false)
	private String nminteressado;
	
	@CPF(message = "CPF inválido")
	@Column(nullable = false)
	private String nuidentificacao;
	
	@Column(nullable = false)
	private Date dtnascimento;
	
	@Column(nullable = false)
	private String flativo;
	
	public Interessado() {
		
	}
	
	public Interessado(int id, String nminteressado, String nuidentificacao, Date dtnascimento, String flativo) {
		this.id = id;
		this.nminteressado = nminteressado;
		this.nuidentificacao = nuidentificacao;
		this.dtnascimento = dtnascimento;
		this.flativo = flativo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNminteressado() {
		return nminteressado;
	}
	
	public void setNminteressado(String nminteressado) {
		this.nminteressado = nminteressado;
	}
	
	public String getNuidentificacao() {
		return nuidentificacao;
	}
	
	public void setNuidentificacao(String nuidentificacao) {
		this.nuidentificacao = nuidentificacao;
	}
	
	public Date getDtnascimento() {
		return dtnascimento;
	}
	
	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
	
	public String getFlativo() {
		return flativo;
	}
	
	public void setFlativo(String flativo) {
		this.flativo = flativo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interessado other = (Interessado) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
