package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Collection<Visit> findByVetId(Integer id);

    List<Visit> findVisitsByPetId(Integer id);

    // void save(Visit visit) throws DataAccessException;

//	List<Visit> findVisitsByPetId(Integer petId);

}
