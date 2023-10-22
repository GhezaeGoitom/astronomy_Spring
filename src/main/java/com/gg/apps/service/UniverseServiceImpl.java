package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Universe;
import com.gg.apps.repository.UniverseRepo;

@Service
public class UniverseServiceImpl implements UniverseService{

	
	@Autowired
	private UniverseRepo universeRepo;
	@Override
	public List<Universe> getAllUniverse() {
		return universeRepo.findAll();
	}

	@Override
	public Universe saveUniverse(Universe universe) {
		return universeRepo.saveAndFlush(universe);
	}

	@Override
	public Universe getUniverseById(Integer id) {
		return universeRepo.getById(id);
	}

	@Override
	public void deleteUniverse(Integer id) {
		this.universeRepo.deleteById(id);
	}

}
