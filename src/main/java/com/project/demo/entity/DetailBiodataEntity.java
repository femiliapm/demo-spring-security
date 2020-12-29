package com.project.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_biodata_entity")
public class DetailBiodataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String domisili;

	@Column
	private Integer usia;

	@Column
	private Date tanggalLahir;

	@Column
	private String hobi;

	@Column
	private String jenisKelamin;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomisili() {
		return domisili;
	}

	public void setDomisili(String domisili) {
		this.domisili = domisili;
	}

	public Integer getUsia() {
		return usia;
	}

	public void setUsia(Integer usia) {
		this.usia = usia;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getHobi() {
		return hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	public DetailBiodataEntity() {
	}

	public DetailBiodataEntity(Integer id, String domisili, Integer usia, Date tanggalLahir, String hobi,
			String jenisKelamin, PersonEntity personEntity) {
		super();
		this.id = id;
		this.domisili = domisili;
		this.usia = usia;
		this.tanggalLahir = tanggalLahir;
		this.hobi = hobi;
		this.jenisKelamin = jenisKelamin;
		this.personEntity = personEntity;
	}
}
