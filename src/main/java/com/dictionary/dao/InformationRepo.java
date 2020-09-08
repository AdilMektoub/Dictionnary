package com.dictionary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dictionary.entities.Information;

@RepositoryRestResource
public interface InformationRepo extends JpaRepository<Information, Long>{
	
	@Query("select i from Information i where i.description like :x")
	public List<Information> chercher(@Param("x")String mc);

}
