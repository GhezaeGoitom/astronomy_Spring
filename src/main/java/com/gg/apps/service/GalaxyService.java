package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Galaxy;

public interface GalaxyService {
	List<Galaxy> getAllGalaxy();
	void saveGalaxy(Galaxy galaxy);
	Galaxy getGalaxyById(Integer id);
	void deleteGalaxy(Integer id);
}
