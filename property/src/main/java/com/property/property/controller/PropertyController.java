package com.property.property.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.property.property.model.dao.Property;
import com.property.property.service.PropertyServiceImpl;



@RestController
@RequestMapping("/api")
public class PropertyController {


@Autowired
PropertyServiceImpl propertyService;


@GetMapping("/getAllProperty")
ResponseEntity<?> getAllProperty(){
	
	return ResponseEntity.ok(propertyService.getAllProperty());
}

@PostMapping(value = "/saveProperty", consumes = {"multipart/form-data"})
ResponseEntity<?> saveProperty(
        @RequestPart("property") String propertyJson,
        @RequestPart(value = "image1", required = false) MultipartFile image1,
        @RequestPart(value = "image2", required = false) MultipartFile image2,
        @RequestPart(value = "image3", required = false) MultipartFile image3,
        @RequestPart(value = "image4", required = false) MultipartFile image4) {

    try {
        ObjectMapper objectMapper = new ObjectMapper();
        Property property = objectMapper.readValue(propertyJson, Property.class);

        if (image1 != null && !image1.isEmpty()) {
            property.setImageData1(image1.getBytes());
            property.setImageName1(image1.getOriginalFilename());
            property.setImageType1(image1.getContentType());
        }
        if (image2 != null && !image2.isEmpty()) {
           
            property.setImageName2(image2.getOriginalFilename());
            property.setImageType2(image2.getContentType());
        }
        if (image3 != null && !image3.isEmpty()) {
            property.setImageData3(image3.getBytes());
            property.setImageName3(image3.getOriginalFilename());
            property.setImageType3(image3.getContentType());
        }
        if (image4 != null && !image4.isEmpty()) {
            property.setImageData4(image4.getBytes());
            property.setImageName4(image4.getOriginalFilename());
            property.setImageType4(image4.getContentType());
        }

        return ResponseEntity.ok(propertyService.saveProperty(property));

    } catch (IOException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body("Error processing request.");
    }
}




}
