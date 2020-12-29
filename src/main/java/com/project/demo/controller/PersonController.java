package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.dto.BiodataDto;
import com.project.demo.dto.PersonDto;
import com.project.demo.dto.StatusMessageDto;
import com.project.demo.entity.DetailBiodataEntity;
import com.project.demo.entity.PersonEntity;
import com.project.demo.repository.DetailBiodataRepository;
import com.project.demo.repository.PersonRepository;
import com.project.demo.services.BiodataServiceImpl;
import com.project.demo.services.PersonServiceImpl;

@RestController
@RequestMapping("/person") // localhost:8500/person
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {
	private PersonRepository personRepository;
	private DetailBiodataRepository detailRepository;
	private PersonServiceImpl service;
	private BiodataServiceImpl biodataService;

	@Autowired
	public PersonController(PersonRepository personRepository, DetailBiodataRepository detailRepository,
			PersonServiceImpl service, BiodataServiceImpl biodataService) {
		super();
		this.personRepository = personRepository;
		this.detailRepository = detailRepository;
		this.service = service;
		this.biodataService = biodataService;
	}

	@GetMapping("/get-all") // localhost:8500/person/get-all
	public List<PersonEntity> getPerson() {
		List<PersonEntity> personEntities = personRepository.findAll();
//		personEntities = personRepository.findByFirstName("ajeng");
		return personEntities;
	}

	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}

	@GetMapping("/by-id/{id}")
	public ResponseEntity<?> getAll(@PathVariable Integer id) {
		PersonEntity personEntities = personRepository.findById(id).get();
		return ResponseEntity.ok(personEntities);
	}

//	GET MAPPING BY ID
	@GetMapping("/get-name-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		PersonDto dto = new PersonDto();
		dto.setFirstName(personRepository.findFirstNameById(id));
		dto.setMessage("data berhasil");
		dto.setStatus("200");
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody List<BiodataDto> dto) {
//		List<PersonEntity> listPersonEntity = 

		for (BiodataDto e : dto) {
//			PersonEntity personEntity = convertToPersonEntity(e);
//			personRepository.save(personEntity);
			service.insertPerson(e);
		}

		return ResponseEntity.ok(dto);
	}

	@PostMapping("/post-person-status")
	public ResponseEntity<?> insertPerson2(@RequestBody BiodataDto dto) {
		if (dto.getNik().length() != 16) {
			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("NIK tidak 16 angka");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			PersonEntity personEntity = convertToPersonEntity(dto);
			personRepository.save(personEntity);

			StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Success!");
			result.setData(personEntity);
			return ResponseEntity.ok(result);
		}
	}

//	UPDATE DATA
	@PutMapping("/update-person/{idPerson}")
	public ResponseEntity<?> update(@PathVariable Integer idPerson, @RequestBody BiodataDto dto) {
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		personEntity.setKodePerson(dto.getKodePerson());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}

//	DELETE DATA
	@DeleteMapping("/delete/{idPerson}")
	public ResponseEntity<?> delete(@PathVariable Integer idPerson) {
		PersonEntity personEntity = personRepository.findById(idPerson).get();
		personRepository.delete(personEntity);
		return ResponseEntity.ok(personEntity);
	}

//	API DETAIL BIODATA
	@GetMapping("/get-detail")
	public ResponseEntity<?> getDetail() {
		List<DetailBiodataEntity> detailBiodataEntities = detailRepository.findAll();
		return ResponseEntity.ok(detailBiodataEntities);
	}

	@PostMapping("/post-detail")
	public ResponseEntity<?> postDetail(@RequestBody BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		detailRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}

	@PostMapping("/post-detail-person")
	public ResponseEntity<?> insertDetail(@RequestBody BiodataDto dto) {
		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
		PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();

		detailBiodataEntity.setPersonEntity(personEntity);
		detailRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}

	@PostMapping("/insert-all")
	public ResponseEntity<?> insertAll(@RequestBody BiodataDto dto) {
//		PersonEntity personEntity = convertToPersonEntity(dto);
//		DetailBiodataEntity detailBiodataEntity = convertToDetailBiodataEntity(dto);
//
//		personRepository.save(personEntity);
//		detailBiodataEntity.setPersonEntity(personEntity);
//		detailRepository.save(detailBiodataEntity);

		DetailBiodataEntity detailBiodataEntity = biodataService.insertAll(dto);
		return ResponseEntity.ok(detailBiodataEntity);
	}

//	METHOD CONVERT
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();

		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personEntity.setNik(dto.getNik());
		personEntity.setKodePerson(dto.getKodePerson());
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
