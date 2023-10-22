package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Supernova;
import com.gg.apps.repository.SupernovaRepo;

@Service
public class SupernovaServiceImpl implements SupernovaService{

	@Autowired
	public SupernovaRepo supernovaRepo;
	
	@Override
	public List<Supernova> getAllSupernova() {
		return supernovaRepo.findAll();
	}

	@Override
	public Supernova saveSupernova(Supernova supernova) {
		return supernovaRepo.saveAndFlush(supernova);
	}

	@Override
	public Supernova getSupernovaById(Integer id) {
		return supernovaRepo.getById(id);
	}

	@Override
	public void deleteSupernova(Integer id) {
		supernovaRepo.deleteById(id);
		
	}

}
