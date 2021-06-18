package com.telusko.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{
		List<Alien> findByAname(String aname);
		List<Alien> findByTech(String tech);
		
		List<Alien> findAll();
		
		@Query("from Alien where tech=?1 order by aname")
		List<Alien> findByTechSorted(String tech);
	
}
