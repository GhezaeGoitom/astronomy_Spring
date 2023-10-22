package com.gg.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gg.apps.model.Publish;
import com.gg.apps.model.Universe;

public interface UniverseRepo extends JpaRepository<Universe, Integer>{
		
	
}
