package com.amdocs.migration;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 
 * @author marathej
 *
 */
@Component
public class Utility {
	
	 public static final Logger logger = Logger.getLogger(Utility.class);
	 
	 /*
	  * 
	  * 
	  */
	 public void writeAsJson(Object object, String fileName) throws IOException {
	    	logger.info("JsonObjectGenerator.writeAsJson : Write Json ");
	    	ObjectMapper mapper = new ObjectMapper();
	    	
	    	try {
				//Convert object to JSON string and save into file directly 
				mapper.writeValue(new File(fileName), object);
				
				//Convert object to JSON string
				String jsonInString = mapper.writeValueAsString(object);
				//logger.info(jsonInString);
				
				//Convert object to JSON string and pretty print
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
				//logger.info(jsonInString);
				
				
			} catch (Exception e) {
				logger.error("JsonObjectGenerator.writeAsJson : " + e.getStackTrace());
			}
	    }
	    
	
	  /*
	   * function to generate a random string of length n 
	   * 	
	   */
	   public String getAlphaNumericString(int n, String str) 
	    { 
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index  = (int)(str.length() * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(str .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 


}
