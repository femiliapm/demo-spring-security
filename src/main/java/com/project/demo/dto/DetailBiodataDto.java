package com.project.demo.dto;

import java.sql.Date;

public class DetailBiodataDto {
	private String domisili;
	private Integer usia;
	private Date tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	private Integer personId;
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
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
}
