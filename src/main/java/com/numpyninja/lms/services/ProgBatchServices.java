package com.numpyninja.lms.services;

import com.numpyninja.lms.entity.Batch;
import com.numpyninja.lms.repository.ProgBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProgBatchServices {
    @Autowired
    private ProgBatchRepository progBatchRepository;

    // method for All batch
    public List<Batch> getAllBatches() {
        return progBatchRepository.findAll();
    }
    
    public List<Batch> getAllBatches(String searchString) {
        return progBatchRepository.findByBatchNameContainingIgnoreCaseOrderByBatchIdAsc(searchString);
    }


    //method for get single batch by id
    public Optional<Batch> findBatchById(Integer id) {
        return progBatchRepository.findById(id);
    }

    //method for finding BatchName
    public Optional<Batch> findByProgramBatchName(String name) {
        return progBatchRepository.findByBatchName(name);
    }

    // create new  Batch under Program
    public Batch createBatch(Batch newProgrambatch) {
        return progBatchRepository.save(newProgrambatch);
    }

    //Update new Batch
    public Batch updateBatch(Batch updatedProgram, @PathVariable Long id) {
        return progBatchRepository.save(updatedProgram);
    }

    // get Batches by Program ID
    public List<Batch> findBatchByProgramId(Long programid) {
        return progBatchRepository.findAll(ProgBatchRepository.hasProgramId(programid));
    }

    public void deleteProgramBatch(Integer id) {
        progBatchRepository.deleteById(id);
    }

}
	

