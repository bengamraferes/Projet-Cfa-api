package fr.dawan.cfa2022.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import fr.dawan.cfa2022.entities.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	@Query("SELECT e FROM Etudiant e JOIN FETCH e.promotions p WHERE p.id =:id ")
	List<Etudiant> findAllByPromoId(@Param("id")long id);

	Page<Etudiant> findAllByFirstNameContainingOrLastNameContainingOrEmailContaining(
			String firstName, String lastName, String email, Pageable pageable);

	long countByFirstNameContainingOrLastNameContainingOrEmailContaining(String search, String search2, String search3);

}
