package com.jwd.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.stereotype.Service;

import com.jwd.test.model.Igrac;
import com.jwd.test.repository.IgracRepository;
import com.jwd.test.service.IgracService;

@Service
public class JpaIgracService implements IgracService {

	@Autowired
	IgracRepository igracRepository;
	
	@Override
	public List<Igrac> findAll() {
		return igracRepository.findAll();
	}

	@Override
	public Igrac getOne(Long id) {
		Optional<Igrac> igrac=igracRepository.findById(id);
		
		if(igrac.isPresent())
			return igrac.get();
		return null;
	}

	@Override
	public List<Igrac> findByReprezentacijaId(Long id) {
		return igracRepository.findByReprezentacijaId(id);
	}
	
	@Override
	public Igrac save(Igrac igrac) {
		return igracRepository.save(igrac);
	}

	@Override
	public Igrac dodajGol(Long id) { 
		
		Igrac igrac = getOne(id);
		
		int golovi=igrac.getPostignutiGolovi();
		
		igrac.setPostignutiGolovi(golovi+1);
		
		igrac=save(igrac);
		
		return igrac;
		 
	}

	@Override
	public List<Igrac> najbolji() {
		return igracRepository.najbolji();
	}

	

//	@Override
//	public Igrac najbolji() {
//		List<Igrac> igraci=igracRepository.findAll();
//		
//		int max=0;
//		
//		Igrac najbolji=new Igrac();
//		
//		for(Igrac i: igraci) {
//			if(i.getPostignutiGolovi()>max)
//			max=i.getPostignutiGolovi();
//		}
//		
//		
//	}

	

}