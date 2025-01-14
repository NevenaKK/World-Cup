package com.jwd.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Utakmica;
import com.jwd.test.service.ReprezentacijaService;
import com.jwd.test.service.UtakmicaService;
import com.jwd.test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDtoToUtakmica implements Converter<UtakmicaDTO, Utakmica> {

	@Autowired
	UtakmicaService utakmicaService;
	
	@Autowired
	ReprezentacijaService reprezentacijaService;
	
		@Override
		public Utakmica convert(UtakmicaDTO dto) {
		
		Utakmica utakmica=new Utakmica();
		
		if(dto.getId()==null)
			utakmica=new Utakmica();
		else 
			utakmica=utakmicaService.findOne(dto.getId());
		
		if(utakmica!=null) {
			utakmica.setBrojgolovaA(dto.getBrojGolovaA());
			utakmica.setBrojgolovaB(dto.getBrojGolovaB());
			utakmica.setReprezentacijaB(reprezentacijaService.getOne(dto.getRepBid()));
			utakmica.setReprezntacijaA(reprezentacijaService.getOne(dto.getRepAid()));

		}
		
		return utakmica;
		
		
	}

}
