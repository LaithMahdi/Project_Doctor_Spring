package com.laith.doctors.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.laith.doctors.entites.Image;


public interface ImageService {
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id);
	 
	 Image uplaodImageDoc(MultipartFile file,Long idDoc) throws IOException;
	 List<Image> getImagesParDoc(Long docId);
}