package com.amdocs.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amdocs.migration.beans.Plans;

@Component
public class CsvValidator {
	
	public static final Logger logger = LoggerFactory.getLogger(CsvValidator.class);
	
	@Autowired
	Plans plans;
	
	@Autowired
	CsvParser csvParser;

public void validateLogic(String inputCSVPath,String standardPropFile,String filePrefix) throws IOException {
		
		File inputCSV = new File(inputCSVPath);
		InputStream standardProp  =  new FileInputStream(standardPropFile);
		Properties prop = new Properties();
		prop.load(standardProp);
		try {
			List<Map<?, ?>> listOfMaps= csvParser.readObjectsFromCsv(inputCSV,',');
			logger.info("List of Maps"+ listOfMaps);
			for(Map<?,?> map : listOfMaps) {
				for(Entry<?, ?> entry : map.entrySet()) {
					String key  = (String) entry.getKey();
					String propertiesKey = filePrefix + "." + key ; 
					Object value = entry.getValue().toString().trim(); //csv value
					Object propertyValue = prop.get(propertiesKey);
					String standardValue = propertyValue.toString().trim();
					if(standardValue.contains(",")) {
						String[] extractOne = standardValue.split(",");
						Boolean flag = false;
						for(String s:extractOne) {
							if(value.toString().equals(s)) { 
								logger.info("keep going");
								flag = true;
								break;
							}
						}
						if(!flag) {
							logger.info("not matched");
						}
					}
					/*else if(standardValue.contains(";")) {
						String[] extractOne = standardValue.split(";");
						for(String s:extractOne) {
							if(value.toString()==s) { 
								logger.info("keep going");
								break;
							}
						}
					}*/
					else if(value.equals(standardValue))
						logger.info("keep going");
					else if(value.equals("") && standardValue.equals("null"))
						logger.info("keep going");
					else 
						logger.info("not matched");						
					}
			}
						
		} catch (IOException e) {
			logger.error("error ::" + e);
			logger.info("Inside Catch------------------Validation Logic with filePath = "+inputCSVPath);
		}
	}
	
	
	
	

}
