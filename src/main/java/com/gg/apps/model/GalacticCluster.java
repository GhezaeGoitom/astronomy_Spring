package com.gg.apps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="GALACTICCLUSTER")
public class GalacticCluster {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer galacticCId;
	
	@Column(name="NAME")
	public String galacticCName;
	
	@ManyToOne()
	@JoinColumn(name = "GALACTICSUPERCLUSTER", referencedColumnName = "ID")
    public GalacticSC galacticSC;
	
	@OneToMany(mappedBy = "galaxyGalacticC",
			 cascade = CascadeType.ALL)
  public List<Galaxy> c_galaxy;
	
	
	@Column(name="DESCRIPTION")
	public String galacticCDescription;


	public Integer getGalacticCId() {
		return galacticCId;
	}


	public void setGalacticCId(Integer galacticCId) {
		this.galacticCId = galacticCId;
	}


	public String getGalacticCName() {
		return galacticCName;
	}


	public void setGalacticCName(String galacticCName) {
		this.galacticCName = galacticCName;
	}


	public GalacticSC getGalacticSC() {
		return galacticSC;
	}


	public void setGalacticSC(GalacticSC galacticSC) {
		this.galacticSC = galacticSC;
	}


	public List<Galaxy> getC_galaxy() {
		return c_galaxy;
	}


	public void setC_galaxy(List<Galaxy> c_galaxy) {
		this.c_galaxy = c_galaxy;
	}


	public String getGalacticCDescription() {
		return galacticCDescription;
	}


	public void setGalacticCDescription(String galacticCDescription) {
		this.galacticCDescription = galacticCDescription;
	}
	
	
	
}
