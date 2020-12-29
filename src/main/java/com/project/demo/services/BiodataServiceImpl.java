package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.dto.BiodataDto;
import com.project.demo.entity.DetailBiodataEntity;
import com.project.demo.entity.PersonEntity;
import com.project.demo.repository.DetailBiodataRepository;
import com.project.demo.repository.PersonRepository;

@Service
@Transactional
public class BiodataServiceImpl implements BiodataService{
	@Autowired
	private DetailBiodataRepository detailRepository;
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public DetailBiodataEntity insertAll(BiodataDto dto) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);

		personRepository.save(personEntity);
		detailBiodataEntity.setPersonEntity(personEntity);
		detailRepository.save(detailBiodataEntity);
		return detailBiodataEntity;
	}

	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();

		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		return personEntity;
	}
	
	public DetailBiodataEntity convertToDetailBiodataEntity(BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();

		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setHobi(dto.getHobi());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setUsia(dto.getUsia());
		return detailBiodataEntity;
	}

}
