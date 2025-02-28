package com.jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jwd.test.model.Reprezentacija;
import com.jwd.test.service.ReprezentacijaService;
import com.jwd.test.support.ReprezentacijaToReprezentacijaDto;
import com.jwd.test.web.dto.ReprezentacijaDTO;



@RestController
@RequestMapping(value = "/api/reprezentacije", produces = MediaType.APPLICATION_JSON_VALUE)

public class ReprezentacijaController {

	@Autowired
	ReprezentacijaToReprezentacijaDto toReprezentacijaDto;
	
	@Autowired
	ReprezentacijaService reprezentacijaService;
	
	 @GetMapping
	   public ResponseEntity<List<ReprezentacijaDTO>> getAll(){
	    		
		 List<Reprezentacija> reprezentacija=reprezentacijaService.findAll();
		 
	     return new ResponseEntity<>(toReprezentacijaDto.convert(reprezentacija),HttpStatus.OK);
	    	
	           
	    }
	 
	 
	 @GetMapping("/{id}") 
	 public ResponseEntity<ReprezentacijaDTO> getOne(@PathVariable Long id){
		 
		 Reprezentacija reprezentacija=reprezentacijaService.getOne(id);
		 
		 if(reprezentacija != null) 
	            return new ResponseEntity<>(toReprezentacijaDto.convert(reprezentacija), HttpStatus.OK);
	        else 
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        

	 }
	
}
