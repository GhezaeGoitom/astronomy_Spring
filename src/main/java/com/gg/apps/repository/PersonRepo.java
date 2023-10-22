package com.gg.apps.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gg.apps.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{
	@Query(
			  value = "SELECT * FROM PERSON", 
			  nativeQuery = true)
			List<Person> findAllPersonzz();

}
