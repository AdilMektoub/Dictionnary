package com.dictionary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dictionary.dao.InformationRepo;
import com.dictionary.entities.Information;

@SpringBootApplication
public class DevDictionaryApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(DevDictionaryApplication.class, args);
		InformationRepo iR = ctx.getBean(InformationRepo.class);
		List<Information> infos = new ArrayList<Information>();
//		infos = iR.findAll();
//		infos.forEach(p-> System.out.println(p.getCategory().getTitle()));
		
	}

}
