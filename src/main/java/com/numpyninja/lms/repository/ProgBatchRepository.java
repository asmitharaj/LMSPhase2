package com.numpyninja.lms.repository;

import com.numpyninja.lms.entity.Batch;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgBatchRepository extends JpaRepository<Batch, Integer>, JpaSpecificationExecutor<Batch> {
    static Specification<Batch> hasProgramId(Long programId) {
        return (batch, cq, cb) -> cb.equal(batch.get("batchProgramId"), programId);
    }

    Optional<Batch> findByBatchName(String programName);

    List<Batch> findAll(Specification<Batch> hasProgramId);

    List<Batch> findByBatchNameContainingIgnoreCaseOrderByBatchIdAsc(String batchName);


}
