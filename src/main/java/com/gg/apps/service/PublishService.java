package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Person;
import com.gg.apps.model.Publish;

public interface PublishService {
List<Publish> getAllPublish();
Publish savePublish(Publish publish);
Publish getPublishById(Integer id);
void deletePublish(Integer id);
void delete(Publish publish);
Publish selectById(Integer id);
}