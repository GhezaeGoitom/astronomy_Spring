package com.gg.apps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PLANET")
public class Planet {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer planetId;
	
	@Column(name="NAME")
	public String planetName;
	
	@Column(name="OBJECTSIZE")
	public Integer planetObjectsize;
	
	@Column(name="OBJECTMASS")
	public Integer planetObjectmass;
	
	@Column(name="SCORE")
	public Integer planetScore;
	
	@Column(name="DESCRIPTION")
	public String planetDescription;
	
	@ManyToOne()
	@JoinColumn(name = "SOLARSYSTEM", referencedColumnName = "ID")
    public SolarSystem planetSolarS;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISCOVER", referencedColumnName = "ID")
    public Discover planetDiscover;

	public Integer getPlanetId() {
		return planetId;
	}

	public void setPlanetId(Integer planetId) {
		this.planetId = planetId;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public Integer getPlanetObjectsize() {
		return planetObjectsize;
	}

	public void setPlanetObjectsize(Integer planetObjectsize) {
		this.planetObjectsize = planetObjectsize;
	}

	public Integer getPlanetObjectmass() {
		return planetObjectmass;
	}

	public void setPlanetObjectmass(Integer planetObjectmass) {
		this.planetObjectmass = planetObjectmass;
	}

	
	
	public Integer getPlanetScore() {
		return planetScore;
	}

	public void setPlanetScore(Integer planetScore) {
		this.planetScore = planetScore;
	}

	public String getPlanetDescription() {
		return planetDescription;
	}

	public void setPlanetDescription(String planetDescription) {
		this.planetDescription = planetDescription;
	}

	public SolarSystem getPlanetSolarS() {
		return planetSolarS;
	}

	public void setPlanetSolarS(SolarSystem planetSolarS) {
		this.planetSolarS = planetSolarS;
	}

	public Discover getPlanetDiscover() {
		return planetDiscover;
	}

	public void setPlanetDiscover(Discover planetDiscover) {
		this.planetDiscover = planetDiscover;
	}
	
	
	
}
