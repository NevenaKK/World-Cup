package com.jwd.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jwd.test.model.Reprezentacija;
import com.jwd.test.repository.ReprezentacijaRepository;
import com.jwd.test.service.ReprezentacijaService;

@Service
public class JpaReprezentacijaService implements ReprezentacijaService{

	@Autowired
	ReprezentacijaRepository reprezentacijaRepository;
	
	@Override
	public List<Reprezentacija> findAll() {
		return reprezentacijaRepository.findAll();
	}

	@Override
	public Reprezentacija getOne(Long id) {
		
		Optional<Reprezentacija> reprezentacija=reprezentacijaRepository.findById(id);
		
		if(reprezentacija.isPresent())
			return reprezentacija.get();
		return null;
	}
}

