package com.gg.apps.service;

import java.util.List;

import com.gg.apps.model.Discover;
import com.gg.apps.model.Person;

public interface DiscoverService {
List<Discover> getAllDiscover();
void saveDiscover(Discover discover);
Discover getDiscoverById(Integer id);
void deleteDiscover(Integer id);
List<Discover> selectAll();
void delete(Discover discover);
Discover selectById(Integer id);
}