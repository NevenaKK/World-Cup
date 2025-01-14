package com.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jwd.test.model.Korisnik;
import com.jwd.test.model.Utakmica;
import com.jwd.test.web.dto.KorisnikDTO;
import com.jwd.test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDto implements Converter<Utakmica, UtakmicaDTO>{

	@Override
	public UtakmicaDTO convert(Utakmica source) {
		UtakmicaDTO utakmicaDTO = new UtakmicaDTO();

		utakmicaDTO.setId(source.getId());
		utakmicaDTO.setBrojGolovaA(source.getBrojgolovaA());
		utakmicaDTO.setBrojGolovaB(source.getBrojgolovaB());
		utakmicaDTO.setRepAid(source.getReprezntacijaA().getId());
		utakmicaDTO.setRepAime(source.getReprezntacijaA().getNaziv());
		
		utakmicaDTO.setRepBid(source.getReprezentacijaB().getId());
		utakmicaDTO.setRepBime(source.getReprezentacijaB().getNaziv());

        return utakmicaDTO;
	}
	
	public List<UtakmicaDTO> convert(List<Utakmica> source) {
		List<UtakmicaDTO> dto = new ArrayList<>();

		 for(Utakmica u : source) 
			 dto.add(convert(u));

        return dto;
	}

}
