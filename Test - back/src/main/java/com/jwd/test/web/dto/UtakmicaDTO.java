package com.jwd.test.web.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.jwd.test.model.Reprezentacija;

public class UtakmicaDTO {
	
private Long id;
	

	private Long repAid;
	private String repAime;
	
	private Long repBid;
	private String repBime;
	

	private int brojGolovaA; 
	
	
	private int brojGolovaB;


	public UtakmicaDTO() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getRepAid() {
		return repAid;
	}


	public void setRepAid(Long repAid) {
		this.repAid = repAid;
	}


	public String getRepAime() {
		return repAime;
	}


	public void setRepAime(String repAime) {
		this.repAime = repAime;
	}


	public Long getRepBid() {
		return repBid;
	}


	public void setRepBid(Long repBid) {
		this.repBid = repBid;
	}


	public String getRepBime() {
		return repBime;
	}


	public void setRepBime(String repBime) {
		this.repBime = repBime;
	}


	public int getBrojGolovaA() {
		return brojGolovaA;
	}


	public void setBrojGolovaA(int brojGolovaA) {
		this.brojGolovaA = brojGolovaA;
	}


	public int getBrojGolovaB() {
		return brojGolovaB;
	}


	public void setBrojGolovaB(int brojGolovaB) {
		this.brojGolovaB = brojGolovaB;
	}
	
	

}
