package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.GalacticCluster;

public interface GalacticCService {
	List<GalacticCluster> getAllGalacticC();
	GalacticCluster saveGalacticC(GalacticCluster galacticC);
	GalacticCluster getGalacticCById(Integer id);
	void deleteGalacticC(Integer id);
}
