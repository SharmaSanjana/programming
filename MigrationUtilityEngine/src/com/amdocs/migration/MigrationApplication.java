package com.amdocs.migration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import constants.MigrationConstants;

@SpringBootApplication
public class MigrationApplication implements CommandLineRunner{
	
	@Autowired
	private CsvParser csvUtil;
	
	@Autowired
	private PromotionMapper jsonObjectGenerator;
	
	@Autowired
	private PriceMapper priceMapper;
	
	@Autowired
	private CsvValidator csvValidate;
	
    public static final Logger logger = LoggerFactory.getLogger(MigrationApplication.class);
	
	@Value("${app.filepath.priceJson}")
	private String pathPriceJson;
	
	@Value("${app.filepath.conditions}")
	private String conditionCSV;
	
	@Value("${app.filepath.discountItems}")
	private String discountItemsCVS;
	
	@Value("${app.filepath.discountPlans}")
	private String discountPlansCSV;
	
	@Value("${app.filepath.steps}")
	private String stepsCVS;
	
	/**********************Reading Validation Properties****************************/
	/*@Value("${csv.filepath.plans}")
	private String filePath_plans;
	
	@Value("${csv.filepath.queryPlans}")
	private String filePath_queryPlans;
	
	@Value("${csv.filepath.conditions}")
	private String filePath_conditions;
	
	@Value("${csv.filepath.queryConditions}")
	private String filePath_queryConditions;
	
	@Value("${csv.filepath.components}")
	private String filePath_components;
	
	@Value("${csv.filepath.tiers}")
	private String filePath_tiers;
	
	@Value("${csv.filepath.steps}")
	private String filePath_steps;
	
	@Value("${csv.filepath.eligibilityList}")
	private String filePath_eligibilityList;
	
	@Value("${csv.filepath.queryEligibiltyList}")
	private String filePath_queryEligibiltyList;
	
	@Value("${csv.filepath.items}")
	private String filePath_items;
	*/
	@Value("${csv.filepath}")
	private String filePaths;
	
	@Value("${prefix.path}")
	private String prefixPropertiesFilePath;
	
	@Value("${standard.property.file.path}")
	private String standardPropertiesFilePath;
	
	@Autowired
	private Environment env;
 
	private static final String[] KEY_CONDITION = {MigrationConstants.PLAN_NAME_COLUMN,MigrationConstants.VERSION_ID_COLUMN};
	private static final String[] KEY_PLANS = {MigrationConstants.PLAN_NAME_COLUMN,MigrationConstants.VERSION_ID_COLUMN};
	private static final String[] KEY_ITEMS = {MigrationConstants.DISCOUNT_ITEM_ID_COLUMN};
	private static final String[] KEY_STEPS = {MigrationConstants.CONDITION_ID_COLUMN};	 
	
	public static void main(String[] args) {  
		SpringApplication.run(MigrationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		  
	    /* Map<String, List<Map<?,?>>> mapWithKeyCondition = csvUtil.generateMapFromCsv(conditionCSV,KEY_CONDITION);
	      Map<String, List<Map<?,?>>> mapWithKeyItems = csvUtil.generateMapFromCsv(discountItemsCVS,KEY_ITEMS);
	      Map<String, List<Map<?,?>>> mapWithKeyPlans = csvUtil.generateMapFromCsv(discountPlansCSV,KEY_PLANS);
	      Map<String, List<Map<?,?>>> mapWithKeySTEPS = csvUtil.generateMapFromCsv(stepsCVS,KEY_STEPS);
	     
	      logger.info("Final cond is "+ mapWithKeyCondition);
	      logger.info("Final item is "+ mapWithKeyItems);
	      logger.info("Final plan is "+mapWithKeyPlans);
	     
	      //jsonObjectGenerator.generateJsons(mapWithKeyPlans, mapWithKeyCondition, mapWithKeyEligibility ,mapWithKeyItems);
	      
	      System.out.print("Json File path :" +pathPriceJson);
	      logger.info("---------------Start Json Creating for Price-------------------");
	      priceMapper.priceJsonCreation(mapWithKeyPlans, mapWithKeyCondition,mapWithKeyItems,mapWithKeySTEPS,pathPriceJson);
	      logger.info("---------------End Json Creating for Price---------------------");*/
		
		//String standardPropFile = "C:\\Users\\sanjasha\\Documents\\Bell\\MigrationUtilityEngine\\MigrationUtilityEngine\\resources\\validation.properties";
		/*List<Map<?, ?>> listOfMaps= csvParser.readObjectsFromCsv(inputCSV,',');
		Map<String, List<Map<?, ?>>> map = new HashMap<>();
		map.put("DE_DISCOUNT_PLAN", listOfMaps)
		csvValidate.validateLogic(map,standardPropFile);*/
		Properties pathProperties = getProperties(filePaths); //CSVs for parsing
		Properties prefixProperties = getProperties(prefixPropertiesFilePath);
		for(Object prop  : pathProperties.keySet()) {
			String propString  = (String) prop;
			String filePath = pathProperties.getProperty(propString);
			String prefixKey = propString.substring(propString.lastIndexOf(".")+1);
			String prefix = prefixProperties.getProperty(prefixKey);
			logger.info("Prefix key ::" + prefixKey + "Prefix ::" + prefix);
			csvValidate.validateLogic(filePath,standardPropertiesFilePath,prefix);		
		}
		
		//csvValidate.validateLogic(filePath_plans,standardPropFile,"DE_QUERY_AREA_DE_DISCOUNT_PLAN");
	}
	
	public Properties getProperties(String filePath) {
		Properties props = new Properties();
		try(InputStream standardProp  =  new FileInputStream(filePath);) {
			props.load(standardProp);
		} catch (IOException e) {
			logger.error("Error occured while reading file " + e);
		}
		return props;
	}
	
	
	
}
