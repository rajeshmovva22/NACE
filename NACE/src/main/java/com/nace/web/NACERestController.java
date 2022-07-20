package com.nace.web;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nace.entity.NACEDetails;
import com.nace.payload.ErrorMessage;
import com.nace.service.NACEService;


@RequestMapping("/nace")
@RestController
public class NACERestController {
	
	@Autowired
	private NACEService naceService;

	 @GetMapping("/details/{id}")
	    public ResponseEntity<Object>  getNaceDetails(@PathVariable("id") Long id) {
	        try {
	        	NACEDetails details = this.naceService.getNACEDetailsByOrderId(id);
	        	return new ResponseEntity<Object>(details, HttpStatus.OK);
	        }catch(NoResultException ex) {
	        	ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setMessage(ex.getMessage());
				return new ResponseEntity<Object>(errorMessage, HttpStatus.NO_CONTENT);
			}
			catch(Exception e) {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setMessage(e.getMessage());
				return new ResponseEntity<Object>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	 
	 @PutMapping("/save")
	    public ResponseEntity<Object>  putNaceDetails() {
	        try {
	        	this.naceService.saveNACEDetails();
	        	return new ResponseEntity<Object>("Saved NACE List", HttpStatus.OK);
	        }
			catch(Exception e) {
				ErrorMessage errorMessage = new ErrorMessage();
				errorMessage.setMessage(e.getMessage());
				return new ResponseEntity<Object>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
}
