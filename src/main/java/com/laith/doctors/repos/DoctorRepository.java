package com.laith.doctors.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.laith.doctors.entites.Doctor;
import com.laith.doctors.entites.Hospital;


@RepositoryRestResource(path="rest")
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	List<Doctor> findByNameDoctor(String nom);
	List<Doctor> findByNameDoctorContains(String nom); 
	
	/*@Query("select d from Doctor d where d.nameDoctor like %?1 and d.ageDoctor > ?2")
	List<Doctor> findByNameAge (String nom, int age);*/
	@Query("select d from Doctor d where d.nameDoctor like %:nom and d.ageDoctor > :age")
	List<Doctor> findByNameAge (@Param("nom") String nom,@Param("age") int age);
	
	@Query("select d from Doctor d where d.hospital = ?1")
	List<Doctor> findByHospital (Hospital hospital);
	
	List<Doctor> findByHospitalIdHospital(Long id);
	List<Doctor> findByOrderByNameDoctorAsc();
	
	
	@Query("select d from Doctor d order by d.nameDoctor ASC, d.ageDoctor DESC")
	List<Doctor> trierDoctorsNamesAge ();
}
