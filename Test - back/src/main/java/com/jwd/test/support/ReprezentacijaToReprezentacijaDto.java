package com.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Reprezentacija;
import com.jwd.test.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDto  implements Converter<Reprezentacija, ReprezentacijaDTO>{

	@Override
	public ReprezentacijaDTO convert(Reprezentacija source) {
		
		ReprezentacijaDTO dto=new ReprezentacijaDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setSkraceniNaziv(source.getSkraceniNaziv());
		
		return dto;
		
	}
	
	public List<ReprezentacijaDTO> convert(List<Reprezentacija> source) {
		
		List<ReprezentacijaDTO> dto=new ArrayList<ReprezentacijaDTO>();
		
		for(Reprezentacija r:source)
			dto.add(convert(r));
		
		return dto;
		
	}
	
	

}
