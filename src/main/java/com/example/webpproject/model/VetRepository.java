package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Integer> {
	Vet findByMemberId(Integer id);


//	Vet findByUsername(String username);


}
