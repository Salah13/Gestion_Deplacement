package fr.gds.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.gds.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.nom like :mc or u.trigramme like :mc or u.prenom like :mc")
	public Page<User> chercherUser(@Param("mc")String mc, Pageable page);
	
}
