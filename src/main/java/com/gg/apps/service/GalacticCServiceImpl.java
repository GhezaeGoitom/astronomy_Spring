package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gg.apps.model.GalacticCluster;
import com.gg.apps.repository.GalacticCRepo;

@Service
public class GalacticCServiceImpl implements GalacticCService{
 
	@Autowired
	GalacticCRepo galacticCRepo;

	@Override
	public List<GalacticCluster> getAllGalacticC() {
		return galacticCRepo.findAll();
	}

	@Override
	public GalacticCluster saveGalacticC(GalacticCluster galacticC) {
		return galacticCRepo.save(galacticC);
	}

	@Override
	public GalacticCluster getGalacticCById(Integer id) {
		return galacticCRepo.getById(id);
	}

	@Override
	public void deleteGalacticC(Integer id) {
		galacticCRepo.deleteById(id);
	}
	
	}
