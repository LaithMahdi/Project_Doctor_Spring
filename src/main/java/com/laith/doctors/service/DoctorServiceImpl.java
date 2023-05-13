package com.laith.doctors.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laith.doctors.dto.DoctorDTO;
import com.laith.doctors.entites.Doctor;
import com.laith.doctors.entites.Hospital;
import com.laith.doctors.repos.DoctorRepository;
import com.laith.doctors.repos.ImageRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public DoctorDTO saveDoctor(DoctorDTO doctor) {
		return convertEntityToDto(doctorRepository.save(convertDtoToEntity(doctor)));
	}

	/*
	 * @Override public DoctorDTO updateDoctor(DoctorDTO doctor) { return
	 * convertEntityToDto(doctorRepository.save(convertDtoToEntity(doctor))); }
	 */
	@Override
	public DoctorDTO updateDoctor(DoctorDTO doctor) {
		return doctor;
		/*
		 * Long
		 * oldDocImageId=this.getDoctor(doctor.getIdDoctor()).getImage().getIdImage();
		 * Long newDocImageId=doctor.getImage().getIdImage(); DoctorDTO
		 * docUpdated=convertEntityToDto(
		 * doctorRepository.save(convertDtoToEntity(doctor))); if (oldDocImageId !=
		 * newDocImageId) imageRepository.deleteById(oldDocImageId); return docUpdated;
		 */

	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		doctorRepository.delete(doctor);
	}

	@Override
	public void deleteDoctorById(Long id) {
		DoctorDTO d = getDoctor(id);
		// suuprimer l'image avant de supprimer le produit
		try {
			Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + d.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		doctorRepository.deleteById(id);
	}

	@Override
	public DoctorDTO getDoctor(Long id) {
		return convertEntityToDto(doctorRepository.findById(id).get());
	}

	@Override
	public List<DoctorDTO> getAllDoctors() {
		return doctorRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	@Override
	public List<Doctor> findByNameDoctor(String nom) {
		return doctorRepository.findByNameDoctor(nom);
	}

	@Override
	public List<Doctor> findByNameDoctorContains(String nom) {
		return doctorRepository.findByNameDoctorContains(nom);
	}

	@Override
	public List<Doctor> findByNameAge(String nom, int age) {
		return doctorRepository.findByNameAge(nom, age);
	}

	@Override
	public List<Doctor> findByHospital(Hospital hospital) {
		return doctorRepository.findByHospital(hospital);
	}

	@Override
	public List<Doctor> findByHospitalIdHospital(Long id) {
		return doctorRepository.findByHospitalIdHospital(id);
	}

	@Override
	public List<Doctor> findByOrderByNameDoctorAsc() {
		return doctorRepository.findByOrderByNameDoctorAsc();
	}

	@Override
	public List<Doctor> trierDoctorsNamesAge() {
		return doctorRepository.trierDoctorsNamesAge();
	}

	@Override
	public DoctorDTO convertEntityToDto(Doctor doctor) {
		/*
		 * return DoctorDTO.builder() .idDoctor(doctor.getIdDoctor())
		 * .nameDoctor(doctor.getNameDoctor()) .ageDoctor(doctor.getAgeDoctor())
		 * .serviceDoctor(doctor.getServiceDoctor()) .dateDoctor(doctor.getDateDoctor())
		 * .hospital(doctor.getHospital())
		 * //.nameHospital(doctor.getHospital().getNameHospital()) .build();
		 **/
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		DoctorDTO doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
		return doctorDTO;
	}

	@Override
	public Doctor convertDtoToEntity(DoctorDTO doctorDTO) {
		/*
		 * Doctor doctor=new Doctor(); doctor.setIdDoctor(doctorDTO.getIdDoctor());
		 * doctor.setNameDoctor(doctorDTO.getNameDoctor());
		 * doctor.setAgeDoctor(doctorDTO.getAgeDoctor());
		 * doctor.setServiceDoctor(doctorDTO.getServiceDoctor());
		 * doctor.setDateDoctor(doctorDTO.getDateDoctor());
		 * doctor.setHospital(doctorDTO.getHospital()); return doctor;
		 */
		Doctor doctor = new Doctor();
		doctor = modelMapper.map(doctorDTO, Doctor.class);
		return doctor;
	}

}
