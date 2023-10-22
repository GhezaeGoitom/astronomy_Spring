package com.gg.apps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUPERNOVA")
public class Supernova {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer supernovaId;
	
	@Column(name="NAME")
	public String sname;
	
	@Column(name="BRIGHTNESS")
	public Integer supernovaBrightness;
	
	@ManyToOne()
	@JoinColumn(name = "UNIVERSE", referencedColumnName = "ID")
    public Universe supernovaUniverse;
	
	@Column(name="DESCRIPTION")
	public String supernovaDescription;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISCOVER", referencedColumnName = "ID")
    public Discover supernovaDiscover;

	public Integer getSupernovaId() {
		return supernovaId;
	}

	public void setSupernovaId(Integer supernovaId) {
		this.supernovaId = supernovaId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSupernovaBrightness() {
		return supernovaBrightness;
	}

	public void setSupernovaBrightness(Integer supernovaBrightness) {
		this.supernovaBrightness = supernovaBrightness;
	}

	public Universe getSupernovaUniverse() {
		return supernovaUniverse;
	}

	public void setSupernovaUniverse(Universe supernovaUniverse) {
		this.supernovaUniverse = supernovaUniverse;
	}

	public String getSupernovaDescription() {
		return supernovaDescription;
	}

	public void setSupernovaDescription(String supernovaDescription) {
		this.supernovaDescription = supernovaDescription;
	}

	public Discover getSupernovaDiscover() {
		return supernovaDiscover;
	}

	public void setSupernovaDiscover(Discover supernovaDiscover) {
		this.supernovaDiscover = supernovaDiscover;
	}

		
	}
