package com.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Igrac;
import com.jwd.test.web.dto.IgracDTO;

@Component
public class IgracToIgracDto implements Converter<Igrac, IgracDTO>{

	@Override
	public IgracDTO convert(Igrac source) {
		
		IgracDTO dto =new IgracDTO();
		
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setPostignutiGolovi(source.getPostignutiGolovi());
		dto.setPrezime(source.getPrezime());
		dto.setReprezentacijaId(source.getReprezentacija().getId());
		dto.setReprezentacijaNaziv(source.getReprezentacija().getNaziv());
		
		return dto;
		
	}
	
	public List<IgracDTO> convert(List<Igrac> source) {
		
		List<IgracDTO> dto =new ArrayList<IgracDTO>();
		
		for(Igrac i:source)
			dto.add(convert(i));
		
		
		return dto;
		
	}

}
