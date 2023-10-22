package com.gg.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gg.apps.model.Planet;

public interface PlanetRepo extends JpaRepository<Planet,Integer>{

}
