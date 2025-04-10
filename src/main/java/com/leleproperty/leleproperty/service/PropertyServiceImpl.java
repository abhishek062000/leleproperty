package com.leleproperty.leleproperty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leleproperty.leleproperty.model.dao.Property;
import com.leleproperty.leleproperty.repository.PropertyRepository;





@Service
public class PropertyServiceImpl {

	
	@Autowired 
	PropertyRepository propertyRepository;
	

    //for fetching all property
	public ResponseEntity<?> getAllProperty(){
		List<Property> allProterty=propertyRepository.findAll();
		return ResponseEntity.ok(allProterty);
	}
	
	//for saving propertyDetail
	public ResponseEntity<?> saveProperty(Property property){
		propertyRepository.save(property);
		return ResponseEntity.ok("Property Detail is Saved");
	}
	
	
	
	
}
