package com.jwd.test.service;

import java.util.List;

import com.jwd.test.model.Igrac;

public interface IgracService {
	
	List<Igrac> findAll();
	Igrac getOne(Long id);
	List<Igrac> findByReprezentacijaId(Long id);
	
	Igrac save(Igrac igrac);
	
	Igrac dodajGol(Long id);
	List<Igrac> najbolji();
	
	
}
