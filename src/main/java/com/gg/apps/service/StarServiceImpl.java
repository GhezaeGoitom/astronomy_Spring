package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Star;
import com.gg.apps.repository.StarRepo;

@Service
public class StarServiceImpl implements StarService{

	@Autowired
	private StarRepo starRepo;
	
	@Override
	public List<Star> getAllStar() {
		return starRepo.findAll(); 
	}

	@Override
	public Star saveStar(Star star) {
		return starRepo.save(star);
	}

	@Override
	public Star getStarById(Integer id) {
		return starRepo.getById(id);
	}

	@Override
	public void deleteStar(Integer id) {
		starRepo.deleteById(id);
	}

}
