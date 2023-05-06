package com.laith.doctors.service;

import java.util.List;

import com.laith.doctors.dto.DoctorDTO;
import com.laith.doctors.entites.Doctor;
import com.laith.doctors.entites.Hospital;

public interface DoctorService {

	DoctorDTO saveDoctor(DoctorDTO doctor);
	DoctorDTO getDoctor(Long id);
	List<DoctorDTO> getAllDoctors();
	
	
	DoctorDTO updateDoctor(DoctorDTO doctor);
	void deleteDoctor(Doctor doctor);
	void deleteDoctorById(Long id);
	
	
	List<Doctor> findByNameDoctor(String nom);
	List<Doctor> findByNameDoctorContains(String nom); 
	List<Doctor> findByNameAge (String nom,int age);
	List<Doctor> findByHospital (Hospital hospital);
	List<Doctor> findByHospitalIdHospital(Long id);
	List<Doctor> findByOrderByNameDoctorAsc();
	List<Doctor> trierDoctorsNamesAge ();
	
	DoctorDTO convertEntityToDto (Doctor doctor);
	Doctor convertDtoToEntity(DoctorDTO doctorDTO);
}
