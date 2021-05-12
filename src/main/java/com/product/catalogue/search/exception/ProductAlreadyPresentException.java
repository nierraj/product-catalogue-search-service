package com.product.catalogue.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class ProductAlreadyPresentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6079029663184291829L;
	
	
	public ProductAlreadyPresentException(String message){
		super(message);
	}

}
