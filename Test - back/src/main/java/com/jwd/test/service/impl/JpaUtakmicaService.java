package com.jwd.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jwd.test.model.Reprezentacija;
import com.jwd.test.model.Utakmica;
import com.jwd.test.repository.ReprezentacijaRepository;
import com.jwd.test.repository.UtakmicaRepository;
import com.jwd.test.service.ReprezentacijaService;
import com.jwd.test.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService{

	@Autowired
	UtakmicaRepository utakmicaRepository;
	
	@Autowired
	ReprezentacijaService reprezentacijaService;
	
	
	@Override
	public Utakmica findOne(Long id) {
		Optional<Utakmica> zadatak=utakmicaRepository.findById(id);
		
		if(zadatak.isPresent())
			return zadatak.get();
		return null;
	}

	@Override
	public Utakmica save(Utakmica utakmica) {
		Utakmica u=utakmicaRepository.save(utakmica);
		if(u.getReprezntacijaA().getId()==u.getReprezentacijaB().getId())
			return null;
		return u;
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica delete(Long id) {
		Optional<Utakmica> zadatak=utakmicaRepository.findById(id);
		if(zadatak.isPresent()) {
			utakmicaRepository.deleteById(id); 
			return zadatak.get();
		}
		return null;
	}

	@Override
	public Page<Utakmica> search(Long repA, Long repB, int pageNo) {
		
		if(repA==repB && repA!=null && repB!=null)
			return null;
		else
			return utakmicaRepository.search(repA, repB, PageRequest.of(pageNo, 3));
	}

	@Override
	public Utakmica dodajGolA(Long id) {
		
		Utakmica u=utakmicaRepository.getOne(id);
		
		int brojGolovaA =u.getBrojgolovaA();
		
		u.setBrojgolovaA(brojGolovaA+1);
		
		u=utakmicaRepository.save(u);
		
		return u;
		
		
	}
	
	@Override
	public Utakmica dodajGolB(Long id) {
		
		Utakmica u=utakmicaRepository.getOne(id);
		
		int brojGolovaB =u.getBrojgolovaB();
		
		u.setBrojgolovaB(brojGolovaB+1);
		
		return utakmicaRepository.save(u);
		
		
	}

}
