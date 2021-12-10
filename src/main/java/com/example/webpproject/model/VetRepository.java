package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Integer> {

//	@Transactional(readOnly = true)
//	@Cacheable("vets")
//	Collection<Vet> findAll() throws DataAccessException;
//
//	@Query("SELECT vet FROM Vet vet WHERE vet.id = :id")
//	@Transactional(readOnly = true)
//	Vet findById(@Param("id") Integer id);

}
