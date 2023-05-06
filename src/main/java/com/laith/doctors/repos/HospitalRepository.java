package com.laith.doctors.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.laith.doctors.entites.Hospital;

@RepositoryRestResource(path = "hos")
@CrossOrigin(origins = "http://localhost:4200/")
public interface HospitalRepository  extends JpaRepository<Hospital, Long>{

}
