package com.project.demo.services;

import com.project.demo.dto.BiodataDto;
import com.project.demo.entity.PersonEntity;

public interface PersonService {
	PersonEntity insertPerson(BiodataDto dto);
}
