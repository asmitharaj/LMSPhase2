package com.numpyninja.lms.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numpyninja.lms.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController  { //extends BaseController
	@Autowired
	private UserServices userServices;
	
    /*public UserController() {
        super("users");
    }*/
    
   
    @GetMapping("/roles/{rolename}")
    protected List<?> getAllRoles(@PathVariable(value="rolename")String roleName) {
        return userServices.getAllUsersByRole(roleName);
    }
    
    @GetMapping("/programs/{programid}")
    protected List<?> getUsersForProgram(@PathVariable(value="programid")Long programId) {
        return userServices.getUsersForProgram(programId);
    }
}
