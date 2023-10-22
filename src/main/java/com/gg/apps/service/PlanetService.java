package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Planet;

public interface PlanetService {
	List<Planet> getAllPlanet();
	void savePlanet(Planet planet);
	Planet getPlanetById(Integer id);
	void deletePlanet(Integer id);
}
