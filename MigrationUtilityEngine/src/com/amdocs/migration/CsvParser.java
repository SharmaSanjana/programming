package com.amdocs.migration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import constants.MigrationConstants;

/**
 * 
 * 
 * @author sanjasha
 *
 */
@Component
public class CsvParser {
	
	public static final Logger logger = Logger.getLogger(CsvParser.class);

    public Map<String, List<Map<?,?>>> generateMapFromCsv(String filePath, String[] key) {
    	
    	File input1 = new File(filePath);
    	Map<String, List<Map<?,?>>> csvMapDEConditions = null;
    	try {
			List<Map<?, ?>> listOfMaps= readObjectsFromCsv(input1,'|');
			csvMapDEConditions = createMapForEachRow(listOfMaps,key);
		} catch (IOException e) {
			logger.info("Generate Map from CSV with key = "+key+" and filePathCondition = "+filePath);
		}
		return csvMapDEConditions;
	}

    public static Map<String, List<Map<?,?>>> createMapForEachRow(List<Map<?, ?>> rows, String[] primKey){
    	Map<String, List<Map<?,?>>> mapForEachRow = new HashMap<>();
    	for(Map<?,?> row : rows) {    		
        	StringBuilder actualKey = new StringBuilder();
        	for(String str : primKey) {
        		if(! str.equalsIgnoreCase(MigrationConstants.ID_SEPARATOR)){
        			actualKey.append(row.get(str));
        		}else{
        			actualKey.append(str);
        		}
        	}
        	String key = actualKey.toString();
        	if(mapForEachRow.containsKey(key)) {
        		List<Map<?,?>> record = mapForEachRow.get(key);
				record.add(row);
			} else {
				List<Map<?,?>> record = new ArrayList<>();
				record.add(row);
				mapForEachRow.put(actualKey.toString(), record);
			}
    	}
    	return mapForEachRow;
    }

	public static List<Map<?, ?>> readObjectsFromCsv(File file, char separator) throws IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader().withColumnSeparator(separator);
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);
        
        return mappingIterator.readAll();
    }
}