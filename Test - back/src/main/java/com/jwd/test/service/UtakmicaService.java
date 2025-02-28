package com.jwd.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jwd.test.model.Utakmica;



public interface UtakmicaService {
	
	Utakmica findOne(Long id);
	Utakmica save(Utakmica utakmica);
	Utakmica update(Utakmica utakmica);
	Utakmica delete(Long id);
	
	Page<Utakmica> search(Long repA,Long repB,int pageNo);
	
	Utakmica dodajGolA (Long id);
	Utakmica dodajGolB (Long id);
	


}
