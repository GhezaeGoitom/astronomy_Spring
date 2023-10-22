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
@Table(name="GALACTICSUPERCLUSTER")
public class GalacticSC {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer galacticSCId;
	
	@Column(name="NAME")
	public String galacticSCName;
	
	@Column(name="DESCRIPTION")
	public String galacticSCDescription;
	
	@OneToMany(mappedBy = "galacticSC",
			 cascade = CascadeType.ALL)
   public List<GalacticCluster> sc_galacticClusters;

	public Integer getGalacticSCId() {
		return galacticSCId;
	}

	public void setGalacticSCId(Integer galacticSCId) {
		this.galacticSCId = galacticSCId;
	}

	public String getGalacticSCName() {
		return galacticSCName;
	}

	public void setGalacticSCName(String galacticSCName) {
		this.galacticSCName = galacticSCName;
	}

	public String getGalacticSCDescription() {
		return galacticSCDescription;
	}

	public void setGalacticSCDescription(String galacticSCDescription) {
		this.galacticSCDescription = galacticSCDescription;
	}

	public List<GalacticCluster> getSc_galacticClusters() {
		return sc_galacticClusters;
	}

	public void setSc_galacticClusters(List<GalacticCluster> sc_galacticClusters) {
		this.sc_galacticClusters = sc_galacticClusters;
	}

	
	
}
