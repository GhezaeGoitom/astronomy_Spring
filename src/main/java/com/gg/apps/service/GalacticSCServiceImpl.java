package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.GalacticSC;
import com.gg.apps.repository.GalacticSCRepo;

@Service
public class GalacticSCServiceImpl implements GalacticSCService{

	
	@Autowired
	GalacticSCRepo galacticSCRepo;
	
	
	@Override
	public List<GalacticSC> getAllGalacticSC() {
		return galacticSCRepo.findAll();
	}

	@Override
	public GalacticSC saveGalacticSC(GalacticSC galacticSC) {
		return galacticSCRepo.saveAndFlush(galacticSC);
	}

	@Override
	public GalacticSC getGalacticSCById(Integer id) {
		return galacticSCRepo.getById(id);
	}

	@Override
	public void deleteGalacticSC(Integer id) {
		galacticSCRepo.deleteById(id);
	}

}
