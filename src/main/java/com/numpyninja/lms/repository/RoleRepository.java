package com.numpyninja.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.numpyninja.lms.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

	
}
