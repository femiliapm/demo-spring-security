package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
	@Query(value = "select * from person_entity where first_name = ?", nativeQuery = true)
	List<PersonEntity> findByFirstName(String firstName);

	List<PersonEntity> findByLastName(String lastName);

	@Query(value = "select first_name from person_entity where id = ?", nativeQuery = true)
	String findFirstNameById(Integer id);

	@Query(value = "select id from person_entity where id = ?", nativeQuery = true)
	Integer findIdById(Integer id);
	
	PersonEntity findByKodePerson(String kodePerson);
}
