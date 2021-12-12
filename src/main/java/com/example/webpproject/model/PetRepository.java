package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface PetRepository extends JpaRepository<Pet, Integer> {

	@Transactional(readOnly = true)
	Pet findPetById(Integer id);

    Collection<Pet> findPetsByOwnerId(Integer id);
}
