package com.gg.apps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gg.apps.model.Person;
import com.gg.apps.model.Publish;

@Repository
public interface PublishRepo extends JpaRepository<Publish, Integer>{
	
	
	@Query(
			  value = "SELECT * FROM PUBLISH", 
			  nativeQuery = true)
			List<Publish> findAllpublll();
	
}