package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToymemberDao extends JpaRepository<Toymember, String> {
	Toymember findByIdAndPwd(String id, String pwd);
}
