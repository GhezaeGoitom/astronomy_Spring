package com.gg.apps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SOLARSYSTEM")
public class SolarSystem {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer solarSId;
	
	@Column(name="NAME")
	public String solarSName;
	
	
	@Column(name="DESCRIPTION")
	public String solarSDescription;
	
	@ManyToOne()
	@JoinColumn(name = "GALAXY", referencedColumnName = "ID")
    public Galaxy solarSGalaxy;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISCOVER", referencedColumnName = "ID")
    public Discover solarSDiscover;
	
	@OneToMany(mappedBy = "starSolarS")
	public List<Star> star;
	
	@OneToMany(mappedBy = "planetSolarS")
	public List<Planet> planet;

	public Integer getSolarSId() {
		return solarSId;
	}

	public void setSolarSId(Integer solarSId) {
		this.solarSId = solarSId;
	}

	public String getSolarSName() {
		return solarSName;
	}

	public void setSolarSName(String solarSName) {
		this.solarSName = solarSName;
	}

	public String getSolarSDescription() {
		return solarSDescription;
	}

	public void setSolarSDescription(String solarSDescription) {
		this.solarSDescription = solarSDescription;
	}

	public Galaxy getSolarSGalaxy() {
		return solarSGalaxy;
	}

	public void setSolarSGalaxy(Galaxy solarSGalaxy) {
		this.solarSGalaxy = solarSGalaxy;
	}

	public Discover getSolarSDiscover() {
		return solarSDiscover;
	}

	public void setSolarSDiscover(Discover solarSDiscover) {
		this.solarSDiscover = solarSDiscover;
	}
}
