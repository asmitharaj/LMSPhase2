package com.numpyninja.lms.services;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numpyninja.lms.dto.BatchDTO;
import com.numpyninja.lms.entity.Batch;
import com.numpyninja.lms.entity.Program;
import com.numpyninja.lms.exception.ResourceNotFoundException;
import com.numpyninja.lms.mappers.BatchMapper;
import com.numpyninja.lms.repository.ProgBatchRepository;
import com.numpyninja.lms.repository.ProgramRepository;

@Service
public class ProgBatchServices {
    @Autowired
    private ProgBatchRepository progBatchRepository;

    @Autowired
    private ProgramRepository programRepository;
    
    @Autowired
    private BatchMapper batchMapper;
    
    // method for All batch
    public List<BatchDTO> getAllBatches() {
    	return batchMapper.toBatchDTOs(progBatchRepository.findAll());
    }
    
    public List<BatchDTO> getAllBatches(String searchString) {
    	List<Batch> batches = progBatchRepository.findByBatchNameContainingIgnoreCaseOrderByBatchIdAsc(searchString);
    	return batchMapper.toBatchDTOs( batches );
    }

    //method for get single batch by id
    public  BatchDTO findBatchById(Integer batchId) {
    	Batch batch = progBatchRepository.findById(batchId).orElseThrow(()-> new ResourceNotFoundException("Batch", "Id", batchId));
        return batchMapper.toBatchDTO( batch );
    }

    //method for finding BatchName
    public List<BatchDTO> findByProgramBatchName(String name) {
    	List<Batch> batchList = progBatchRepository.findByBatchName(name);
    	return batchMapper.toBatchDTOs( batchList );
    }

    // create new  Batch under Program     
    public BatchDTO createBatch(BatchDTO batchDTO ) {
    	Long programId = batchDTO.getProgramId();
    	Batch newBatch = batchMapper.toBatch(batchDTO );
    	Program program = programRepository.findById( programId ).orElseThrow(()-> new ResourceNotFoundException("Program", "Id", programId));
    	newBatch.setProgram(program);
    	newBatch.setCreationTime(new Timestamp( new Date().getTime()));
    	newBatch.setLastModTime(new Timestamp( new Date().getTime()));
    	Batch batchCreated = progBatchRepository.save(newBatch);
    	return batchMapper.toBatchDTO( batchCreated );
    }

    
    //Update new Batch                    
    public BatchDTO updateBatch(BatchDTO batchDTO, Integer batchId) {
    	Batch exisBatch = progBatchRepository.findById(batchId).orElseThrow(()-> new ResourceNotFoundException("Batch", "Id", batchId));
    	Batch batchDetailToUpdt = batchMapper.toBatch(batchDTO );
    	batchDetailToUpdt.setCreationTime(exisBatch.getCreationTime() );
    	batchDetailToUpdt.setLastModTime( new Timestamp( new Date().getTime()));
    	return batchMapper.toBatchDTO( progBatchRepository.save(batchDetailToUpdt) );
    }


    // get Batches by Program ID         
    public List<BatchDTO> findBatchByProgramId(Long programid) {
      return batchMapper.toBatchDTOs(progBatchRepository.findByProgramProgramId(programid));      
    }

    public void deleteProgramBatch(Integer id) {
        progBatchRepository.deleteById(id);
    }

}
	

