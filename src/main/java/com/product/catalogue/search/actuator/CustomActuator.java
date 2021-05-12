package com.product.catalogue.search.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customActuator")
public class CustomActuator {
	
	@ReadOperation
	public  ResponseEntity<String> getRecordsCount() {
		return new ResponseEntity<>("There are 5 Records!", HttpStatus.OK);
	}

}
