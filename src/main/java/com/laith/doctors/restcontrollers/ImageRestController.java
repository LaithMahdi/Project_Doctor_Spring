package com.laith.doctors.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.laith.doctors.dto.DoctorDTO;
import com.laith.doctors.entites.Doctor;
import com.laith.doctors.entites.Image;
import com.laith.doctors.repos.DoctorRepository;
import com.laith.doctors.service.DoctorService;
import com.laith.doctors.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	@Autowired
	DoctorService doctorService;

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		DoctorDTO d = doctorService.getDoctor(id);
		d.setImagePath(id + ".jpg");
		Files.write(Paths.get(System.getProperty("user.home") + "/images/" + d.getImagePath()), file.getBytes());
		doctorService.saveDoctor(d);

	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		DoctorDTO d = doctorService.getDoctor(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + d.getImagePath()));
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageDoc/{idDoc}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idDoc") Long idDoc)
			throws IOException {
		return imageService.uplaodImageDoc(file, idDoc);
	}

	@RequestMapping(value = "/getImagesDoc/{idDoc}", method = RequestMethod.GET)
	public List<Image> getImagesProd(@PathVariable("idDoc") Long idDoc) throws IOException {
		return imageService.getImagesParDoc(idDoc);
	}

}
