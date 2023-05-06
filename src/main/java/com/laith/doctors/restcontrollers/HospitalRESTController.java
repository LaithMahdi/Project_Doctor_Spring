package com.laith.doctors.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laith.doctors.entites.Hospital;
import com.laith.doctors.repos.HospitalRepository;

@RestController
@RequestMapping("/api/hosp")
@CrossOrigin("*")
public class HospitalRESTController {
	@Autowired
	HospitalRepository hospitalRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Hospital> getHospitals()
	{
		return hospitalRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Hospital getHospitalById(@PathVariable("id") Long id) {
		return hospitalRepository.findById(id).get();
	}
}
