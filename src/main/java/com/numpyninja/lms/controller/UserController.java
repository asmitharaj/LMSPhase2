package com.numpyninja.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numpyninja.lms.mappers.UserEntityDTOMapper;
import com.numpyninja.lms.services.UserServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController  { //extends BaseController
//	@Autowired
//	private UserServices userServices;
//	
//	@Autowired
//	private UserEntityDTOMapper userEntityDTOMapper;
	
    /*public UserController() {
        super("users");
    }*/
    
	//@Autowired
	//UserServices userServices;


	private UserEntityDTOMapper userEntityDTOMapper;
	private UserServices userServices;

	@Autowired
    public UserController(
    		UserEntityDTOMapper userEntityDTOMapper,
            UserServices userServices) {
        this.userEntityDTOMapper = userEntityDTOMapper;
        this.userServices = userServices;
    }
	
	
    @GetMapping("/roles/{rolename}")
    protected List<?> getAllRoles(@PathVariable(value="rolename")String roleName) {
    	return userEntityDTOMapper.toUserDTOs( userServices.getAllUsersByRole(roleName) );
    }
    
    @GetMapping("/programs/{programid}")
    protected List<?> getUsersForProgram(@PathVariable(value="programid")Long programId) {
        return userServices.getUsersForProgram(programId);
    }
}
