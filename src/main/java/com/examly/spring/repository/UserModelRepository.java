package com.examly.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examly.spring.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,String>,CrudRepository<UserModel,String>{
	

	public boolean existsByEmail(String email);

	public boolean existsByMobileNumber(String mobileNumber);

	public boolean existsByUserId(int userId);
	
}
