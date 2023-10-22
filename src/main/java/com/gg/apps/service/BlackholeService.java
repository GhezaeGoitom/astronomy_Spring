package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Blackhole;

public interface BlackholeService {
	List<Blackhole> getAllBlackhole();
	Blackhole saveBlackhole(Blackhole blackhole);
	Blackhole getBlackholeById(Integer id);
	void deleteBlackhole(Integer id);
}
