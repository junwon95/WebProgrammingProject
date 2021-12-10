package com.example.webpproject.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member findByEmail(String email);

	Member findByUsername(String username);

	@Transactional
	@Modifying
	@Query("UPDATE Member mem SET mem.password = :password WHERE mem.id = :memberId")
	void changePassword(@Param("password") String password, @Param("memberId") Integer memberId);

}
