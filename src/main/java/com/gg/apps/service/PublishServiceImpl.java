package com.gg.apps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Publish;
import com.gg.apps.repository.DiscoverRepo;
import com.gg.apps.repository.PublishRepo;

@Service
public class PublishServiceImpl implements PublishService{

	
	@Autowired
	private PublishRepo publishRepo;
	
	
	@Override
	public List<Publish> getAllPublish() {
		return publishRepo.findAllpublll();
	}

	@Override
	public Publish savePublish(Publish publish) {
		return publishRepo.saveAndFlush(publish);
	}

	@Override
	public Publish getPublishById(Integer id) {
		Optional<Publish> optional = publishRepo.findById(id);
		Publish publish = null;
		if(optional.isPresent()) {
			publish = optional.get();
		}else {
			throw new RuntimeException("discover not found using this id : "+id);
		}
		return publish;
	}

	@Override
	public void deletePublish(Integer id) {
		publishRepo.deleteById(id);
		
	}


	@Override
	public void delete(Publish publish) {
		publishRepo.delete(publish);		
	}

	@Override
	public Publish selectById(Integer id) {
		return publishRepo.getById(id);
	}

}
