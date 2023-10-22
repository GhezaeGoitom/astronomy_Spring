package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Supernova;

public interface SupernovaService {
	List<Supernova> getAllSupernova();
	Supernova saveSupernova(Supernova supernova);
	Supernova getSupernovaById(Integer id);
	void deleteSupernova(Integer id);
}
