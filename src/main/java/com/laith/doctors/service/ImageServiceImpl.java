package com.laith.doctors.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.laith.doctors.entites.Doctor;
import com.laith.doctors.entites.Image;
import com.laith.doctors.repos.DoctorRepository;
import com.laith.doctors.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	DoctorService doctorService;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public Image uplaodImageDoc(MultipartFile file, Long idDoc) throws IOException {
		Doctor doc = new Doctor();
		doc.setIdDoctor(idDoc);
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).doctor(doc).build());
	}

	@Override
	public List<Image> getImagesParDoc(Long idDoc) {
		Doctor doc = doctorRepository.findById(idDoc).get();
		return doc.getImages();
	}
}