package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

	// void save(Visit visit) throws DataAccessException;

//	List<Visit> findVisitsByPetId(Integer petId);

}
