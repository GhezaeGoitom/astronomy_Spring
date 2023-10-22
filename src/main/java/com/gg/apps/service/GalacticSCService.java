package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.GalacticSC;

public interface GalacticSCService {
	List<GalacticSC> getAllGalacticSC();
	GalacticSC saveGalacticSC(GalacticSC galacticSC);
	GalacticSC getGalacticSCById(Integer id);
	void deleteGalacticSC(Integer id);
}
