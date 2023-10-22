package com.gg.apps.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="PUBLISH")
public class Publish {

		@Id
		@Column(name="ID")
		@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer id;
		
		@Column(name="DATEPUBLISHED")
	public LocalDate datePublished;
			
		
		@Column(name="PLACE")
	public String place;
		
		 @OneToMany(mappedBy = "discoverPublish",
				 cascade = CascadeType.ALL,
			     orphanRemoval = true)
	public List<Discover> discover;
		
		public Integer getId() {
			return id;
		}


		public List<Discover> getDiscover() {
			return discover;
		}


		public void setDiscover(List<Discover> discover) {
			this.discover = discover;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public LocalDate getDatePublished() {
			return datePublished;
		}


		public void setDatePublished(String datePublished) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
					.withLocale(Locale.ITALIAN);
			this.datePublished = LocalDate.parse(datePublished, formatter);
		}

		public String getPlace() {
			return place;
		}


		public void setPlace(String place) {
			this.place = place;
		}
		
}
