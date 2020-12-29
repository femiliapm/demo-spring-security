package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.demo.entity.DetailBiodataEntity;


@Repository
public interface DetailBiodataRepository extends JpaRepository<DetailBiodataEntity, Integer> {
	List<DetailBiodataEntity> findByJenisKelamin(String jenisKelamin);

	List<DetailBiodataEntity> findByPersonEntityId(Integer personId);
	
	@Query(value = "select * from detail_biodata_entity where person_id = ?", nativeQuery = true)
	List<DetailBiodataEntity> findByPersonId(Integer idPerson);
}
