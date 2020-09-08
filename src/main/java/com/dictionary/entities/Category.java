package com.dictionary.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {
	
	@Id @GeneratedValue
	private Long id_category;
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_category")
    private List<Information> informations = new ArrayList<>();	

	
	public List<Information> getInformations() {
		return informations;
	}
	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}
	
	public Category(String title, List<Information> informations) {
		super();
		this.title = title;
		this.informations = informations;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId_category() {
		return id_category;
	}
	public String getTitle() {
		return title;
	}
	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Category [id_category=" + id_category + ", title=" + title + "]";
	}

}
