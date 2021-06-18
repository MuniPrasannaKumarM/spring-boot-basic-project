package com.telusko.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.Dao.AlienRepo;
import com.telusko.demo.model.Alien;



@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		System.out.println("id   "+aid);
		ModelAndView mv = new ModelAndView("getAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		System.out.println("find by aname"+repo.findByAname("maha"));
		System.out.println("find by tech"+repo.findByTech("java"));
		System.out.println("find by all"+repo.findAll());
		System.out.println("find by tech sorted "+repo.findByTechSorted("java"));
		mv.addObject("alien", alien);
		return mv;
	}
}

