package com.jwd.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwd.test.model.Igrac;
import com.jwd.test.model.Utakmica;
import com.jwd.test.repository.IgracRepository;
import com.jwd.test.service.IgracService;
import com.jwd.test.support.IgracToIgracDto;
import com.jwd.test.web.dto.IgracDTO;
import com.jwd.test.web.dto.UtakmicaDTO;


@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {
	
	@Autowired
	IgracService igracService;
	
	@Autowired
	IgracToIgracDto toIgracDto;
	
	@GetMapping
   public ResponseEntity<List<IgracDTO>> getAll(){
    		
	 List<Igrac> igraci=igracService.findAll();
	 
     return new ResponseEntity<>(toIgracDto.convert(igraci),HttpStatus.OK);
    	
           
    }
	
	@GetMapping("/{id}") 
	 public ResponseEntity<IgracDTO> getOne(@PathVariable Long id){
		 
		 Igrac igrac=igracService.getOne(id);
		 
		 if(igrac != null) 
	            return new ResponseEntity<>(toIgracDto.convert(igrac), HttpStatus.OK);
	        else 
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        

	 }
	
	@GetMapping("/rep/{id}") 
	 public ResponseEntity<List<IgracDTO>> getOneByRep(@PathVariable Long id){
		 
		 List<Igrac> igraci=igracService.findByReprezentacijaId(id);
		 
	
	      return new ResponseEntity<>(toIgracDto.convert(igraci), HttpStatus.OK);
	     
	        

	 }
	
	
	 @PutMapping(value = "/dodajGol/{id}")
	  public ResponseEntity<IgracDTO> dodajGoll(@PathVariable Long id){
	
		 Igrac igrac=igracService.dodajGol(id);
		
		  
		  
		  return new ResponseEntity<>(toIgracDto.convert(igrac),HttpStatus.OK);
		  
	  }
	 
	 @GetMapping("/najbolji")
	 public ResponseEntity<IgracDTO> najbolji(){
		  
		 List<Igrac> igraci=igracService.najbolji();
		 Igrac ig=new Igrac();
		 for(Igrac i:igraci) {
			 ig=i;
			 break;
		 }
	
	     return new ResponseEntity<>(toIgracDto.convert(ig), HttpStatus.OK);
	 
	        

	 }
	
	
	

}