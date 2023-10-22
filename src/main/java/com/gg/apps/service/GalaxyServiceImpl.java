package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gg.apps.model.Galaxy;
import com.gg.apps.repository.GalaxyRepo;

@Controller
public class GalaxyServiceImpl implements GalaxyService{

	@Autowired
	GalaxyRepo galaxyRepo;
	
	
	@Override
	public List<Galaxy> getAllGalaxy() {
		return galaxyRepo.findAll();
	}

	@Override
	public void saveGalaxy(Galaxy galaxy) {
		galaxyRepo.save(galaxy);
	}

	@Override
	public Galaxy getGalaxyById(Integer id) {
		return galaxyRepo.getById(id);
	}

	@Override
	public void deleteGalaxy(Integer id) {
	    galaxyRepo.deleteById(id);
		
	}

}
