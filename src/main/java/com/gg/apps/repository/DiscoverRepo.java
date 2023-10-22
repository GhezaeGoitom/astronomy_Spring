package com.gg.apps.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Person;

@Repository
public interface DiscoverRepo extends JpaRepository<Discover, Integer>{
	@Query(
			  value = "SELECT * FROM DISCOVER", 
			  nativeQuery = true)
			List<Discover> findAlldiscoverzz();
	
	@Query(
			  value = "SELECT * FROM DISCOVER WHERE ID =:id", 
			  nativeQuery = true)
			Discover selectV(@Param("id") Integer ID);
	
	
	@Modifying
	@Query(
			  value = "DELETE FROM DISCOVER WHERE ID =:id", 
			  nativeQuery = true)
			List<Discover> deleteDiscover(@Param("id") Integer ID);
	
}
