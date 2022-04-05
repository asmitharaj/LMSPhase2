package com.numpyninja.lms.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numpyninja.lms.entity.Batch;
import com.numpyninja.lms.entity.User;
import com.numpyninja.lms.entity.UserRoleMap;
import com.numpyninja.lms.repository.UserRoleMapRepository;

@Service
public class UserServices {
	@Autowired
	// private UserRepository userRepository;
	UserRoleMapRepository userRoleMapRepository;

	public List<User> getAllUsersByRole(String roleName) {
		return userRoleMapRepository.findUserRoleMapsByRoleRoleName(roleName).stream()
				.map(userRoleMap -> userRoleMap.getUser()).collect(Collectors.toList());
	}

	public List<UserRoleMap> getUsersForProgram(Long programId) {
		List<UserRoleMap> list = userRoleMapRepository.findUserRoleMapsByBatchesProgramProgramId(programId);
    	
		return list.stream().map(userRoleMap -> 
		       { userRoleMap.getBatches().removeIf(batch -> batch.getProgram().getProgramId() == programId); 
		         return userRoleMap;  } ).collect(Collectors.toList());
	}
}
