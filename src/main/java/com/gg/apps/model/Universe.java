package com.gg.apps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UNIVERSE")
public class Universe {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer id;
	
	@Column(name="NAME")
	public String name;
	
	@Column(name="DESCRIPTION")
	public String description;
	
	@Column(name="COORDINATE")
	public String coordinate;
	
	@OneToMany(mappedBy = "supernovaUniverse",
			 cascade = CascadeType.ALL)
    public List<Supernova> supernova;
	
	@OneToMany(mappedBy = "galaxyUniverse",
			 cascade = CascadeType.ALL)
    public List<Galaxy> galaxy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public List<Supernova> getSupernova() {
		return supernova;
	}

	public void setSupernova(List<Supernova> supernova) {
		this.supernova = supernova;
	}

	public List<Galaxy> getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(List<Galaxy> galaxy) {
		this.galaxy = galaxy;
	}
	
	
	
}
