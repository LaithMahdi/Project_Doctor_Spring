package com.laith.doctors.dto;

import java.util.Date;
import java.util.List;

import com.laith.doctors.entites.Hospital;
import com.laith.doctors.entites.Image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
	private Long idDoctor;
	private String nameDoctor;
	private int ageDoctor;
	private String serviceDoctor;
	private Date dateDoctor;
	private Hospital hospital;
	//private String nameHospital;
	private List<Image> images;
	private String imagePath;
}
