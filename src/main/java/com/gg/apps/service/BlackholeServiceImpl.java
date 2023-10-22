package com.gg.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Blackhole;
import com.gg.apps.repository.BlackholeRepo;

@Service
public class BlackholeServiceImpl implements BlackholeService{

	@Autowired
	private BlackholeRepo blackholeRepo;
	
	@Override
	public List<Blackhole> getAllBlackhole() {
		return blackholeRepo.findAll();
	}

	@Override
	public Blackhole saveBlackhole(Blackhole blackhole) {
		return blackholeRepo.save(blackhole);
	}

	@Override
	public Blackhole getBlackholeById(Integer id) {
		return blackholeRepo.getById(id);
	}

	@Override
	public void deleteBlackhole(Integer id) {
	blackholeRepo.deleteById(id);
	}

}
