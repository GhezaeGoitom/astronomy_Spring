package com.gg.apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gg.apps.model.Supernova;
import com.gg.apps.model.Universe;

public interface SupernovaRepo extends JpaRepository<Supernova, Integer>{

}
