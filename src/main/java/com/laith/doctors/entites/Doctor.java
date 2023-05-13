package com.laith.doctors.entites;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDoctor;
	private String nameDoctor;
	private int ageDoctor;
	private String serviceDoctor;
	private Date dateDoctor;
	
	@ManyToOne
	private Hospital hospital;
	
	
	@OneToMany (mappedBy = "doctor")
	private List<Image> images;

	private String imagePath;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String nameDoctor, int ageDoctor, String serviceDoctor, Date dateDoctor) {
		super();
		this.nameDoctor = nameDoctor;
		this.ageDoctor = ageDoctor;
		this.serviceDoctor = serviceDoctor;
		this.dateDoctor = dateDoctor;
	}

	public Long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNameDoctor() {
		return nameDoctor;
	}

	public void setNameDoctor(String nameDoctor) {
		this.nameDoctor = nameDoctor;
	}

	public int getAgeDoctor() {
		return ageDoctor;
	}

	public void setAgeDoctor(int ageDoctor) {
		this.ageDoctor = ageDoctor;
	}

	public String getServiceDoctor() {
		return serviceDoctor;
	}

	public void setServiceDoctor(String serviceDoctor) {
		this.serviceDoctor = serviceDoctor;
	}

	

	public Date getDateDoctor() {
		return dateDoctor;
	}

	public void setDateDoctor(Date dateDoctor) {
		this.dateDoctor = dateDoctor;
	}
	
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Doctor [idDoctor=" + idDoctor + ", nameDoctor=" + nameDoctor + ", ageDoctor=" + ageDoctor
				+ ", serviceDoctor=" + serviceDoctor + ", dateDoctor=" + dateDoctor + "]";
	}
	
}
