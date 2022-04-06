package com.numpyninja.lms.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.numpyninja.lms.dto.UserDTO;
import com.numpyninja.lms.entity.User;

@Mapper(componentModel = "spring")
public interface UserEntityDTOMapper {
	User userDTOtoUser(UserDTO dto);
	
	UserDTO userToUserDTO(User entity);
	
	List<UserDTO> toUserDTOs(List<User> users);
}
