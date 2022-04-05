package com.numpyninja.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.numpyninja.lms.entity.Role;
import com.numpyninja.lms.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, String>{
 
	//List<User> findUsersByRolesRoleName( String roleName );
}
