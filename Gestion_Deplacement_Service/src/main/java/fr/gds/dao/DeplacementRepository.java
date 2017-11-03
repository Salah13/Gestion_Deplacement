package fr.gds.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.gds.entities.Deplacement;

public interface DeplacementRepository extends JpaRepository<Deplacement, Long>{
	
	@Query("select d from Deplacement d where d.client like :mc")
	public Page<Deplacement> chercherDeplacementByClient(@Param("mc")String mc, Pageable page);

}
