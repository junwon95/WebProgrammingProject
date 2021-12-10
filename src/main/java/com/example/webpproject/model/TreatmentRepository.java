package com.example.webpproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {

	Treatment findByVisitId(Integer visitId);

}
