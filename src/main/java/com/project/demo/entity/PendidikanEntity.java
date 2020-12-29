package com.project.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pendidikan_entity")
public class PendidikanEntity {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_pendidikan", unique = true, length = 25, nullable = false)
	private String kodePendidikan;
	
	@Column(name = "jenjang")
	private String jenjang;
	
	@Column(name = "institusi")
	private String institusi;
	
	@ManyToOne
	@JoinColumn(name = "kode_person", referencedColumnName = "kode_person")
	private PersonEntity personEntity;

	public PendidikanEntity(Integer id, String kodePendidikan, String jenjang, String institusi,
			PersonEntity personEntity) {
		super();
		this.id = id;
		this.kodePendidikan = kodePendidikan;
		this.jenjang = jenjang;
		this.institusi = institusi;
		this.personEntity = personEntity;
	}

	public PendidikanEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodePendidikan() {
		return kodePendidikan;
	}

	public void setKodePendidikan(String kodePendidikan) {
		this.kodePendidikan = kodePendidikan;
	}

	public String getJenjang() {
		return jenjang;
	}

	public void setJenjang(String jenjang) {
		this.jenjang = jenjang;
	}

	public String getInstitusi() {
		return institusi;
	}

	public void setInstitusi(String institusi) {
		this.institusi = institusi;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}
}
