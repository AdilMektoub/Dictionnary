package com.dictionary.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dictionary.dao.CategoryRepo;
import com.dictionary.dao.InformationRepo;
import com.dictionary.dao.UserRepo;
import com.dictionary.entities.Category;
import com.dictionary.entities.Information;
import com.dictionary.entities.User;

@Controller
public class InformationController {

	@Autowired
	private InformationRepo iR;

	@Autowired
	private UserRepo uR;

	@Autowired
	private CategoryRepo cR;

	@RequestMapping(value = "/index")
	public String index(Model model , 
			@RequestParam(name = "mc", defaultValue="") String mc) {

		List<Information> informations = iR.findAll();
		if (mc.length() == 0 || mc.equals(null)) {
			model.addAttribute("informations", informations);
		}
		else {
			List<Information> InformationsTrouves = iR.chercher("%"+mc+"%");
			model.addAttribute("informations", InformationsTrouves);
		}
		model.addAttribute("mc", mc);
		return "index4Admin";
	}

	@RequestMapping(value = "/delete" , method=RequestMethod.GET)
	public String delete(Long id) {
		iR.deleteById(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/addInformation" , method=RequestMethod.GET)
	public String addInformation(Model model) {
		List<Category> categories = cR.findAll();
		List<User> users = uR.findAll();
		Information info = new Information();
		info.setCategory(cR.getOne((long) 1));
		info.setUser(uR.getOne((long) 1));
		model.addAttribute("users", users);
		model.addAttribute("categories", categories);
		model.addAttribute("information", info);
		return "AddInformation";
	}

	@RequestMapping(value = "/edit" , method=RequestMethod.GET)
	public String edit(Model model, Long id) {
		List<Category> categories = cR.findAll();
		List<User> users = uR.findAll();
		model.addAttribute("users", users);
		model.addAttribute("categories", categories);
		
		Optional<Information> i =  iR.findById(id);
		Information info = i.get();
		
		info.setCategory(cR.getOne((long) 1));
		info.setUser(uR.getOne((long) 1));

		model.addAttribute("information", info);
		return "EditInformation";
	}
	
	
	@RequestMapping(value = "/save" , method=RequestMethod.POST)
	public String save(Model model,  Information Information, // @Valid
	@RequestParam(name = "category", defaultValue="1") String categoryId,
	@RequestParam(name = "user", defaultValue="1") String userId) {
		//		if (bindingResult.hasErrors()) return "FormInformation";
		Information.setDate(new Date());
		Long lC = Long.parseLong(categoryId);
		Optional<Category> c = cR.findById(lC);
		Category RealC = c.get();
		if (RealC != null) Information.setCategory(RealC);
		
		Long lU = Long.parseLong(userId);
		Optional<User> u = uR.findById(lU);
		User RealU = u.get();
		if (RealU != null) Information.setUser(RealU);
		iR.save(Information);
		return "Confirmation";	
	}

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

}
