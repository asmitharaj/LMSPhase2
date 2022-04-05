package com.numpyninja.lms.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.FetchType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity 
@Table ( name = "tbl_lms_user" ) 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", sequenceName = "tbl_lms_user_user_id_seq", allocationSize = 1)
	@Column( name = "user_id" )
	private String userId;

	@Column( name = "user_first_name" )
	private String userFirstName; 
	
	@Column( name = "user_last_name" )
	private String userLastName; 
    
	@Column( name = "user_phone_number" )
	private long userPhoneNumber; 
	
	@Column( name = "user_location" )
    private String userLocation; 
	
	@Column( name = "user_time_zone" )
    private String userTimeZone ;
	
	@Column( name = "user_linkedin_url" )
    private String userLinkedinUrl; 
	
	@Column( name = "user_edu_ug" )
    private String userEduUg ;
	
	@Column( name = "user_edu_pg" )
    private String userEduPg ;
	
	@Column( name = "user_comments" )
    private String userComments ;
	
	@Column( name = "user_visa_status" )
    private String userVisaStatus ;
	
	@Column( name = "creation_time" )
    private Timestamp creationTime ;
	
	@Column( name = "last_mod_time" )
    private Timestamp lastModTime ;
	


}

