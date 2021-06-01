package com.bsrcs.hrms.core.utilities.validations;

import java.util.UUID;

public class RandomCodeGenerator {
	
	private RandomCodeGenerator() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String getRandomCode() {
		return UUID.randomUUID().toString();
	}
	 
}
