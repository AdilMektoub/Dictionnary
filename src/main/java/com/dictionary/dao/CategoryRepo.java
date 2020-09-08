package com.dictionary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dictionary.entities.Category;

@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
