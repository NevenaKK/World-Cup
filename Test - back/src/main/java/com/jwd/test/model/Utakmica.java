package com.jwd.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Utakmica {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Reprezentacija reprezntacijaA;
	
	@ManyToOne
	private Reprezentacija reprezentacijaB;
	
	@Column
	private int brojGolovaA; 
	
	@Column
	private int brojGolovaB;

	public Utakmica(Long id, Reprezentacija reprezntacijaA, Reprezentacija reprezentacijaB, int brojgolovaA,
			int brojgolovaB) {
		super();
		this.id = id;
		this.reprezntacijaA = reprezntacijaA;
		this.reprezentacijaB = reprezentacijaB;
		this.brojGolovaA = brojgolovaA;
		this.brojGolovaB = brojgolovaB;
	}

	public Utakmica(Reprezentacija reprezntacijaA, Reprezentacija reprezentacijaB, int brojgolovaA, int brojgolovaB) {
		super();
		this.reprezntacijaA = reprezntacijaA;
		this.reprezentacijaB = reprezentacijaB;
		this.brojGolovaA = brojgolovaA;
		this.brojGolovaB = brojgolovaB;
	}

	public Utakmica() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utakmica other = (Utakmica) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reprezentacija getReprezntacijaA() {
		return reprezntacijaA;
	}

	public void setReprezntacijaA(Reprezentacija reprezntacijaA) {
		this.reprezntacijaA = reprezntacijaA;
	}

	public Reprezentacija getReprezentacijaB() {
		return reprezentacijaB;
	}

	public void setReprezentacijaB(Reprezentacija reprezentacijaB) {
		this.reprezentacijaB = reprezentacijaB;
	}

	public int getBrojgolovaA() {
		return brojGolovaA;
	}

	public void setBrojgolovaA(int brojgolovaA) {
		this.brojGolovaA = brojgolovaA;
	}

	public int getBrojgolovaB() {
		return brojGolovaB;
	}

	public void setBrojgolovaB(int brojgolovaB) {
		this.brojGolovaB = brojgolovaB;
	} 
	
	

}
