package com.laith.doctors.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.laith.doctors.entites.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}