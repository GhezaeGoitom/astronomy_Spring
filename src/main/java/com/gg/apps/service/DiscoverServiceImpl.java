package com.gg.apps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Discover;
import com.gg.apps.repository.DiscoverRepo;

@Service
public class DiscoverServiceImpl implements DiscoverService{

	@Autowired
	private DiscoverRepo discoverRepo;

	
	@Override
	public List<Discover> getAllDiscover() {
		return discoverRepo.findAll();
	}

	@Override
	public void saveDiscover(Discover discover) {
		this.discoverRepo.save(discover);
		
	}

	@Override
	public Discover getDiscoverById(Integer id) {
		Optional<Discover> optional = discoverRepo.findById(id);
		Discover discover = null;
		if(optional.isPresent()) {
			discover = optional.get();
		}else {
			throw new RuntimeException("discover not found using this id : "+id);
		}
		return discover;
	}

	@Override
	public void deleteDiscover(Integer id) {
		this.discoverRepo.deleteDiscover(id);
		
	}

	@Override
	public List<Discover> selectAll() {
		List<Discover> a = discoverRepo.findAlldiscoverzz();
		return discoverRepo.findAlldiscoverzz();
	}

	@Override
	public void delete(Discover discover) {
		this.discoverRepo.delete(discover);
		
	}

	@Override
	public Discover selectById(Integer id) {	
		return discoverRepo.selectV(id);
	}

}
