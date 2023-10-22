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
@Table(name="STAR")
public class Star {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer starId;
	
	@Column(name="NAME")
	public String starName;
	
	@Column(name="OBJECTSIZE")
	public Integer starObjectsize;
	
	@Column(name="OBJECTMASS")
	public Integer starObjectmass;
	
	@Column(name="DESCRIPTION")
	public String starDescription;
	
	@ManyToOne()
	@JoinColumn(name = "SOLARSYSTEM", referencedColumnName = "ID")
    public SolarSystem starSolarS;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISCOVER", referencedColumnName = "ID")
    public Discover starDiscover;

	public Integer getStarId() {
		return starId;
	}

	public void setStarId(Integer starId) {
		this.starId = starId;
	}

	public String getStarName() {
		return starName;
	}

	public void setStarName(String starName) {
		this.starName = starName;
	}

	public Integer getStarObjectsize() {
		return starObjectsize;
	}

	public void setStarObjectsize(Integer starObjectsize) {
		this.starObjectsize = starObjectsize;
	}

	public Integer getStarObjectmass() {
		return starObjectmass;
	}

	public void setStarObjectmass(Integer starObjectmass) {
		this.starObjectmass = starObjectmass;
	}

	public String getStarDescription() {
		return starDescription;
	}

	public void setStarDescription(String starDescription) {
		this.starDescription = starDescription;
	}

	public SolarSystem getStarSolarS() {
		return starSolarS;
	}

	public void setStarSolarS(SolarSystem starSolarS) {
		this.starSolarS = starSolarS;
	}

	public Discover getStarDiscover() {
		return starDiscover;
	}

	public void setStarDiscover(Discover starDiscover) {
		this.starDiscover = starDiscover;
	}

	
	
}
