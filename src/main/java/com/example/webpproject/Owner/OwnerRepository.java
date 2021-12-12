package com.example.webpproject.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	Owner findOwnerById(int ownerId);

    Owner findByMemberId(Integer id);

//	@Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.name LIKE :name%")
//	@Transactional(readOnly = true)
//	Collection<Owner> findByName(@Param("name") String name);
//
//	@Query("SELECT owner FROM Owner owner WHERE owner.id =:id")
//	@Transactional(readOnly = true)
//	Owner findOwnerById(@Param("id") Integer id);
//
//	@Modifying
//	@Query("DELETE FROM Owner owner WHERE owner.id = :id")
//	void deleteById(@Param("id") Integer id);

}
