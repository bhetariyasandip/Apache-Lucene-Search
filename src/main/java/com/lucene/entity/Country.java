package com.lucene.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.SortableField;
import org.hibernate.search.annotations.Store;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="country")
@Getter
@Setter
@Indexed
public @Data class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Field(store = Store.NO)
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="currency_code")
	private String currencyCode;
	
	@Column(name="fips_code")
	private String fipsCode;
	
	@Column(name="iso_numeric")
	private String  isoNumeric;
	
	private String north;
	
	private String south;
	
	private String east;
	
	private String west;
	
	private String capital;
	
	@Field
	@Column(name="continent_name")
	private String continentName;
	
	private String continent;
	
	private String languages;
	
	@Column(name="iso_alpha3")
	private String isoAlpha3;
	
	@Column(name="geoname_id")
	private Long geonameId;
	
	// add rank for sorting 
	@SortableField
	@Field
	private Long rank;
	
}
