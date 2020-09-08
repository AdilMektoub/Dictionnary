package com.dictionary.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Information implements Serializable {
	
	@Id @GeneratedValue
	private Long id_information;
	private String title;
	private String description;
	private Date date;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
	
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
	public Information(String title, String description, Date date, Category category, User user) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.category = category;
		this.user = user;
	}

	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_information() {
		return id_information;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public Category getCategory() {
		return category;
	}

	public User getUser() {
		return user;
	}

	public void setId_information(Long id_information) {
		this.id_information = id_information;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Information [id_information=" + id_information + ", title=" + title + ", description=" + description
				+ ", date=" + date + ", category=" + category + ", user=" + user + "]";
	}
    
    
}
