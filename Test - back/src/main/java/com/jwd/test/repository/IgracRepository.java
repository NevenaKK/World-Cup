package com.jwd.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwd.test.model.Igrac;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {

	public List<Igrac> findByReprezentacijaId(Long id);
	
	@Query("select i from Igrac i where postignutiGolovi=(select max(postignutiGolovi) from  Igrac )")
	List<Igrac> najbolji();
	
	
}
