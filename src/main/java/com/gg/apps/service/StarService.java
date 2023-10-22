package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Blackhole;
import com.gg.apps.model.Star;

public interface StarService {
	List<Star> getAllStar();
	Star saveStar(Star star);
	Star getStarById(Integer id);
	void deleteStar(Integer id);
}
