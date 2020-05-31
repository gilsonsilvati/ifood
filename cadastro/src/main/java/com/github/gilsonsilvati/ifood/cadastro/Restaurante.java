package com.github.gilsonsilvati.ifood.cadastro;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "restaurante")
public class Restaurante extends PanacheEntityBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String proprietario;
	public String cnpj;
	public String nome;
	
	@ManyToOne
	public Localizacao localizacao;
	
	@CreationTimestamp
	public LocalDate criacao;
	
	@UpdateTimestamp
	public LocalDate atualizacao;

}
