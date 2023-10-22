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
@Table(name="BLOCKHOLE")
public class Blackhole {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer blackholeId;
	
	@Column(name="NAME")
	public String blackholeName;
	
	@Column(name="OBJECTSIZE")
	public Integer blackholeObjectsize;
	
	@Column(name="OBJECTMASS")
	public Integer blackholeObjectmass;
	
	@Column(name="DESCRIPTION")
	public String blackholeDescription;
	
	@ManyToOne()
	@JoinColumn(name = "GALAXY", referencedColumnName = "ID")
    public Galaxy blackholeGalaxy;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISCOVER", referencedColumnName = "ID")
    public Discover blackholeDiscover;

	public Integer getBlackholeId() {
		return blackholeId;
	}

	public void setBlackholeId(Integer blackholeId) {
		this.blackholeId = blackholeId;
	}

	public String getBlackholeName() {
		return blackholeName;
	}

	public void setBlackholeName(String blackholeName) {
		this.blackholeName = blackholeName;
	}

	public Integer getBlackholeObjectsize() {
		return blackholeObjectsize;
	}

	public void setBlackholeObjectsize(Integer blackholeObjectsize) {
		this.blackholeObjectsize = blackholeObjectsize;
	}

	public Integer getBlackholeObjectmass() {
		return blackholeObjectmass;
	}

	public void setBlackholeObjectmass(Integer blackholeObjectmass) {
		this.blackholeObjectmass = blackholeObjectmass;
	}

	public String getBlackholeDescription() {
		return blackholeDescription;
	}

	public void setBlackholeDescription(String blackholeDescription) {
		this.blackholeDescription = blackholeDescription;
	}

	public Galaxy getBlackholeGalaxy() {
		return blackholeGalaxy;
	}

	public void setBlackholeGalaxy(Galaxy blackholeGalaxy) {
		this.blackholeGalaxy = blackholeGalaxy;
	}

	public Discover getBlackholeDiscover() {
		return blackholeDiscover;
	}

	public void setBlackholeDiscover(Discover blackholeDiscover) {
		this.blackholeDiscover = blackholeDiscover;
	}
	
	
}
