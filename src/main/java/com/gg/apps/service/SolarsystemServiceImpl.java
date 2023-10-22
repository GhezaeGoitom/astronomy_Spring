package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.SolarSystem;
import com.gg.apps.repository.SolarSystemRepo;

@Service
public class SolarsystemServiceImpl implements SolarSystemService{

	
	@Autowired
	private SolarSystemRepo solarsystemRepo;
	
	@Override
	public List<SolarSystem> getAllSolarsystem() {
		return solarsystemRepo.findAll();
	}

	@Override
	public SolarSystem saveSolarsystem(SolarSystem solarsystem) {
		return solarsystemRepo.save(solarsystem);
	}

	@Override
	public SolarSystem getSolarSystemById(Integer id) {
		return solarsystemRepo.getById(id);
	}

	@Override
	public void deleteSolarsystem(Integer id) {
		solarsystemRepo.deleteById(id);
		
	}

}
