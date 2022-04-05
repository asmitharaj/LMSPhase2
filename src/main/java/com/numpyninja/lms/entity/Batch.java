package com.numpyninja.lms.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.numpyninja.lms.entity.Program;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tbl_lms_batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_id_generator")
    @SequenceGenerator(name = "batch_id_generator", sequenceName = "tbl_lms_batch_batch_id_seq", allocationSize = 1)
    Integer batchId;
    @NotBlank(message = "Batch Name is mandatory")
    String batchName;
    @NotBlank(message = "Batch Description cannot be null")
    String batchDescription;
    String batchStatus;

    @Positive(message = "Batch Program ID invalid")
	@ManyToOne ( cascade = CascadeType.ALL , fetch = FetchType.LAZY)                         // added
    @JoinColumn ( name = "batch_program_id", nullable = false )  // added
    //Long batchProgramId;                             
    private Program program;                         // added
    
    Integer batchNoOfClasses;
}
