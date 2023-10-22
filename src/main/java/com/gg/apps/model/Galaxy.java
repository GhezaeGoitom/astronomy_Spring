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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="GALAXY")
public class Galaxy {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer galaxyId;
	
	@Column(name="NAME")
	public String galaxyName;
	
	@ManyToOne()
	@JoinColumn(name = "UNIVERSE", referencedColumnName = "ID")
    public Universe galaxyUniverse;
	
	@Column(name="DESCRIPTION")
	public String galaxyDescription;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISCOVER", referencedColumnName = "ID")
    public Discover galaxyDiscover;
	
	@ManyToOne()
	@JoinColumn(name = "GALACTICCLUSTER", referencedColumnName = "ID")
    public GalacticCluster galaxyGalacticC;

	
	@OneToMany(mappedBy = "blackholeGalaxy")
	public List<Blackhole> blackhole;
	
	@OneToMany(mappedBy = "solarSGalaxy")
	public List<SolarSystem> solarSystem;

	
	public Integer getGalaxyId() {
		return galaxyId;
	}

	public void setGalaxyId(Integer galaxyId) {
		this.galaxyId = galaxyId;
	}

	public String getGalaxyName() {
		return galaxyName;
	}

	public void setGalaxyName(String galaxyName) {
		this.galaxyName = galaxyName;
	}

	public Universe getGalaxyUniverse() {
		return galaxyUniverse;
	}

	public void setGalaxyUniverse(Universe galaxyUniverse) {
		this.galaxyUniverse = galaxyUniverse;
	}

	public String getGalaxyDescription() {
		return galaxyDescription;
	}

	public void setGalaxyDescription(String galaxyDescription) {
		this.galaxyDescription = galaxyDescription;
	}

	public Discover getGalaxyDiscover() {
		return galaxyDiscover;
	}

	public void setGalaxyDiscover(Discover galaxyDiscover) {
		this.galaxyDiscover = galaxyDiscover;
	}

	public GalacticCluster getGalaxyGalacticC() {
		return galaxyGalacticC;
	}

	public void setGalaxyGalacticC(GalacticCluster galaxyGalacticC) {
		this.galaxyGalacticC = galaxyGalacticC;
	}

	

	
	
	
}
