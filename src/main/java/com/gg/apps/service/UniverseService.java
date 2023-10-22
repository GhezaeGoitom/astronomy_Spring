package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Publish;
import com.gg.apps.model.Universe;

public interface UniverseService {
	List<Universe> getAllUniverse();
	Universe saveUniverse(Universe universe);
	Universe getUniverseById(Integer id);
	void deleteUniverse(Integer id);
}
