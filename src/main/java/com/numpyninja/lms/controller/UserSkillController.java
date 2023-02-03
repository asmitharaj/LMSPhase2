package com.numpyninja.lms.controller;

import com.numpyninja.lms.config.ApiResponse;
import com.numpyninja.lms.dto.UserSkillDTO;
import com.numpyninja.lms.exception.DuplicateResourceFound;
import com.numpyninja.lms.mappers.UserSkillMapper;
import com.numpyninja.lms.services.UserSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userSkill")
public class UserSkillController {
    private UserSkillMapper userSkillMapper;
    private UserSkillService userSkillService;
    public UserSkillController( UserSkillMapper userSkillMapper, UserSkillService userSkillService){
        this.userSkillMapper=userSkillMapper;
        this.userSkillService=userSkillService;

    }
    @PostMapping("/create")
        public ResponseEntity<UserSkillDTO> createUserSkill(@RequestBody  UserSkillDTO newuserskillDTO ) throws DuplicateResourceFound {
            UserSkillDTO responseDto = this.userSkillService.createUserSkill(newuserskillDTO);
            return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }

    @GetMapping()
    public List<UserSkillDTO> getAllUserSkill(){

        return userSkillService.getAllUserSkills();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserSkillDTO>> getUserSkillForUser(@PathVariable(value = "userId") String userId){
        return ResponseEntity.ok(this.userSkillService.getUserSkillForUser(userId));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<UserSkillDTO>  updateUserSkill(@RequestBody UserSkillDTO userSkillDTO, @PathVariable String id){
     UserSkillDTO updateUserSkillDTO =this.userSkillService.updateUserSkill(userSkillDTO,id);
     return ResponseEntity.ok(updateUserSkillDTO);
    }


   /* @DeleteMapping(path="/deleteByUser/{id}")
    public ResponseEntity<ApiResponse> deleteUserByUserId(@PathVariable String id) {
        this.userSkillService.deleteUserByUserId(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Users deleted successfully", true), HttpStatus.OK);
    }*/
    @DeleteMapping(path="/deleteByUserSkillId/{id}")
    public ResponseEntity< ApiResponse>deleteUserSkillByUserSkillId(@PathVariable String id){
        this.userSkillService.deleteUserSkillByUserSkillId(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("UserSkill deleted successfully", true), HttpStatus.OK);


    }


}
