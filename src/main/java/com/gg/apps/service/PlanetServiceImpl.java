package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Planet;
import com.gg.apps.repository.PlanetRepo;


@Service
public class PlanetServiceImpl implements PlanetService{

	
	@Autowired
	PlanetRepo planetRepo;
	
	@Override
	public List<Planet> getAllPlanet() {
		return planetRepo.findAll();
	}

	@Override
	public void savePlanet(Planet planet) {
		 planetRepo.save(planet);
	}

	@Override
	public Planet getPlanetById(Integer id) {
		return planetRepo.getById(id);
	}

	@Override
	public void deletePlanet(Integer id) {
		planetRepo.deleteById(id);
	}

}
