package com.rojalin.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rojalin.employee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByUserName(String userName);
}
