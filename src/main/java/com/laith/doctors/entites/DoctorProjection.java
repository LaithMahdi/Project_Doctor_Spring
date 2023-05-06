package com.laith.doctors.entites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameDoc", types = { Doctor.class })
public interface DoctorProjection {
	public String getNameDoctor();
}
