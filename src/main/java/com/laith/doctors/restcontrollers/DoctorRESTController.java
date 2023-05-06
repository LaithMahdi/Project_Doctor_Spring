package com.laith.doctors.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laith.doctors.dto.DoctorDTO;
import com.laith.doctors.entites.Doctor;
import com.laith.doctors.service.DoctorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DoctorRESTController {
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> getAllDoctors() {
		return doctorService.getAllDoctors();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public DoctorDTO getDoctorById(@PathVariable("id") Long id) {
		return doctorService.getDoctor(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public DoctorDTO createDoctor(@RequestBody DoctorDTO doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public DoctorDTO updateDoctor(@RequestBody DoctorDTO doctor) {
		return doctorService.updateDoctor(doctor);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteDoctor(@PathVariable("id") Long id)
	{
		doctorService.deleteDoctorById(id);
	}
	
	
	@RequestMapping(value="/doctHos/{idHospital}",method = RequestMethod.GET)
	public List<Doctor> getDoctorsByHospitalId(@PathVariable("idHospital") Long idHospital) {
		return doctorService.findByHospitalIdHospital(idHospital);
	}
	
	@RequestMapping(value="/docsByName/{nom}",method = RequestMethod.GET)
	public List<Doctor> findByNameDoctorContains(@PathVariable("nom") String nom) {
		return doctorService.findByNameDoctorContains(nom);
	}
}
