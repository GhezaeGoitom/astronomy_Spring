package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Blackhole;
import com.gg.apps.model.SolarSystem;

public interface SolarSystemService {
	List<SolarSystem> getAllSolarsystem();
	SolarSystem saveSolarsystem(SolarSystem solarsystem);
	SolarSystem getSolarSystemById(Integer id);
	void deleteSolarsystem(Integer id);
}
