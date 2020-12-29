package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {
	List<PendidikanEntity> findByPersonEntityKodePerson(String kodePerson);
}
