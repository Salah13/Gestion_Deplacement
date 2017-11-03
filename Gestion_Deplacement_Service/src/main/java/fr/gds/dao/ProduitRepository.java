package fr.gds.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.gds.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	@Query("select p from Produit p where p.designation like :mc")
	public Page<Produit> chercherProduit(@Param("mc")String mc, Pageable page);

}
