package com.numpyninja.lms.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numpyninja.lms.dto.AssignmentDto;
import com.numpyninja.lms.entity.Assignment;
import com.numpyninja.lms.exception.ResourceNotFoundException;
import com.numpyninja.lms.mappers.AssignmentMapper;
import com.numpyninja.lms.repository.AssignmentRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Service
public class AssignmentService {
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private AssignmentMapper assignmentMapper;

	// get all assignments
    public List<AssignmentDto> getAllAssignments() {
    	List<Assignment> assignments =  this.assignmentRepository.findAll();
    	List<AssignmentDto> assignmentDtos = assignments.stream()
    			.map(assignment -> assignmentMapper.toAssignmentDto(assignment)).collect(Collectors.toList());
        return assignmentDtos;
    }

	
	/*//get all assignments for batch
	public List<AssignmentDto> getAllAssignmentsForBatch(Integer batchId) {
		List<AssignmentDto> assignments = new ArrayList<>();
		assignmentRepository.findByBatchId(batchId).forEach(assignments::add);
		return assignments;
	}*/
		
	//save an assignment 
	public AssignmentDto createAssignment(AssignmentDto assignmentDto) {
		 Assignment assignment = assignmentMapper.toAssignment(assignmentDto);
		 Assignment savedAssignment = this.assignmentRepository.save(assignment);
		 return assignmentMapper.toAssignmentDto(savedAssignment);
	}
	
	//get assignment by id
	public AssignmentDto getAssignmentById(Long id) {
		Assignment assignment = this.assignmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Assignment", "Id", id));
		return assignmentMapper.toAssignmentDto(assignment);
	}
	
	public AssignmentDto updateAssignment(@RequestBody AssignmentDto assignmentDto, Long assignmentId) {
		this.assignmentRepository.findById(assignmentId)
							.orElseThrow(() -> new ResourceNotFoundException("Assignment", "Id", assignmentId));
		Assignment updatedAssignment = assignmentMapper.toAssignment(assignmentDto);
		this.assignmentRepository.save(updatedAssignment);
		AssignmentDto updatedAssignmentDto = assignmentMapper.toAssignmentDto(updatedAssignment);
		return updatedAssignmentDto;
		
	}
	
	public void deleteAssignment(Long id) {
		Assignment assignment = this.assignmentRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Assignment", "Id", id));
		this.assignmentRepository.delete(assignment);
	}
	
	/*private Assignment dtoToAssignment(AssignmentDto assignmentDto) {
		Assignment assignment = new Assignment();
		assignment.setAssignmentId(assignmentDto.getAssignmentId());
		assignment.setAssignmentName(assignmentDto.getAssignmentName());
		assignment.setAssignmentDescription(assignmentDto.getAssignmentDescription());
		assignment.setComments(assignmentDto.getComments());
		assignment.setDueDate(assignmentDto.getDueDate());
		assignment.setBatchId(assignmentDto.getBatchId());
		return assignment;
		
	}
	
	private AssignmentDto assignmentToDto(Assignment assignment) {
		AssignmentDto assignmentDto = new AssignmentDto();
		assignmentDto.setAssignmentId(assignment.getAssignmentId());
		assignmentDto.setAssignmentName(assignment.getAssignmentName());
		assignmentDto.setAssignmentDescription(assignment.getAssignmentDescription());
		assignmentDto.setComments(assignment.getComments());
		assignmentDto.setDueDate(assignment.getDueDate());
		assignmentDto.setBatchId(assignment.getBatchId());
		return assignmentDto;
		
	}*/
}