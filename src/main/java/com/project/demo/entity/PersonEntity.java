package com.project.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_entity")
public class PersonEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Column(name = "nik", length = 16, nullable = false)
	private String nik;
	
	@Column(name = "kode_person", unique = true)
	private String kodePerson;

	public String getKodePerson() {
		return kodePerson;
	}

	public void setKodePerson(String kodePerson) {
		this.kodePerson = kodePerson;
	}

	public Integer getId() {
		return id;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PersonEntity(Integer id, String firstName, String lastName, String nik, String kodePerson) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nik = nik;
		this.kodePerson = kodePerson;
	}

	public PersonEntity() {
		super();
	}
}
