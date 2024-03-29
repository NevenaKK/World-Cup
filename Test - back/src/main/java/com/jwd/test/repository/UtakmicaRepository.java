package com.jwd.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwd.test.model.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica, Long>{
	
	@Query("SELECT u FROM Utakmica u WHERE "
			+ "(:repA=NULL OR u.reprezntacijaA.id = :repA) AND "
			+ "(:repB=NULL OR u.reprezentacijaB.id = :repB)")
	Page<Utakmica> search (@Param("repA") Long repA,
						  @Param("repB") Long repB,
						  Pageable pageable);
	

}
