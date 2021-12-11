package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Collection<Visit> findByVetId(Integer id);

    // void save(Visit visit) throws DataAccessException;

//	List<Visit> findVisitsByPetId(Integer petId);

}
