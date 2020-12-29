package com.project.demo.services;

import com.project.demo.dto.BiodataDto;
import com.project.demo.entity.DetailBiodataEntity;

public interface BiodataService {
	DetailBiodataEntity insertAll(BiodataDto dto);
}
