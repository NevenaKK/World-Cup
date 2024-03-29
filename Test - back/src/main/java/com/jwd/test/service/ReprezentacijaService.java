package com.jwd.test.service;

import java.util.List;
import com.jwd.test.model.Reprezentacija;

public interface ReprezentacijaService {

	List<Reprezentacija> findAll();
	Reprezentacija getOne(Long id);
	
}
