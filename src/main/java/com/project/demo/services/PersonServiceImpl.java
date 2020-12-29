package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.dto.BiodataDto;
import com.project.demo.entity.PersonEntity;
import com.project.demo.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	public PersonEntity insertPerson(BiodataDto dto) {
		// TODO Auto-generated method stub
		PersonEntity personEntity = convertToPersonEntity(dto);
		personRepository.save(personEntity);
		return personEntity;
	}

	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();

		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		return personEntity;
	}
}
