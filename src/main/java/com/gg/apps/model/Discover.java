package com.gg.apps.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.CascadeType;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
    @Entity
    @Table(name="DISCOVER")
	public class Discover {
		@Id
		@Column(name="ID")
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	public Integer discoverId;
		
		@Column(name="DATEDISCOVERED")
	public LocalDate dateDiscovered;
		
		
		@ManyToOne()
		@JoinColumn(name = "DISCOVEREDBY", referencedColumnName = "FISCALCODE")
	public Person discoverPerson;
		
		@Column(name="DESCRIPTION")
	public String discoverDescription;
		
		@Column(name="COORDINATE")
	public String discoverCoordinate;
		
//		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "PUBLISH", referencedColumnName = "ID", insertable = false)
    public Publish discoverPublish;

		public Integer getDiscoverId() {
			return discoverId;
		}

		public void setDiscoverId(Integer discoverId) {
			this.discoverId = discoverId;
		}

		public LocalDate getDateDiscovered() {
			return dateDiscovered;
		}

		public void setDateDiscovered(String dateDiscovered) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
					.withLocale(Locale.ITALIAN);
			this.dateDiscovered = LocalDate.parse(dateDiscovered, formatter);
		}

		public Person getDiscoverPerson() {
			return discoverPerson;
		}

		public void setDiscoverPerson(Person discoverPerson) {
			this.discoverPerson = discoverPerson;
		}

		public String getDiscoverDescription() {
			return discoverDescription;
		}

		public void setDiscoverDescription(String discoverDescription) {
			this.discoverDescription = discoverDescription;
		}

		public String getDiscoverCoordinate() {
			return discoverCoordinate;
		}

		public void setDiscoverCoordinate(String discoverCoordinate) {
			this.discoverCoordinate = discoverCoordinate;
		}

		public Publish getDiscoverPublish() {
			return discoverPublish;
		}

		public void setDiscoverPublish(Publish discoverPublish) {
			this.discoverPublish = discoverPublish;
		}
		
		
//		
		 
			
		
	}
