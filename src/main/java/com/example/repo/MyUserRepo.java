package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MyUser;

public interface MyUserRepo extends JpaRepository<MyUser, Integer>{
	
 MyUser findByEmail(String email);
	
	
	
	boolean existsByEmail(String email);


}
