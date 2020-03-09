package com.amdocs.migration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Description;
import model.Key;
import model.Policy;
import model.Price;
import model.PriceData;
import model.PriceName;
import model.PriceReduction;
import model.ValidFor;
import constants.MigrationConstants;

/**
 * 
 * 
 * @author marathej
 *
 */

@Component
public class PriceMapper {

	 @Autowired
	 private Utility utility;
	 
	 public static final Logger logger = Logger.getLogger(PriceMapper.class);
	 
	 /**
     * Price JSON
     * 
     * @param planMap
     * @param conditionMap
     * @param mapWithKeyItems
     * @param stepsMap
     * @throws IOException 
     */
    public void priceJsonCreation(Map<String, ?> planMap, Map<?, ?> conditionMap, Map<?, ?> discountItemsMap, Map<?, ?> stepsMap, String pathPriceJson) throws IOException{
    	 
     
    	logger.info("Binding of CSV data to Price");
    	Set<String> planNames = planMap.keySet();
    	for (String planName : planNames) {
    		 List<?> conditionList =(List<?>)conditionMap.get(planName);
        	 Map<?, ?> condition= (Map<?, ?>)conditionList.get(0);
        	
        	 logger.info("\n Plan name : "+planName +"==== Condition : "+condition.get(MigrationConstants.CONDITION_ID_COLUMN));
    		
    		String conditionId=(String) condition.get(MigrationConstants.CONDITION_ID_COLUMN);
    		
    		//Extract the STEPS CSV Data  
    		logger.info("Getting the Price quantity & componentId ");
    		List<?> stepsList =(List<?>)stepsMap.get(conditionId);
    		Map<?, ?> steps = (Map<?, ?>)stepsList.get(0);
    		String componentId=(String) steps.get(MigrationConstants.COMPONENT_ID_COLUMN);
    		String quantity=(String) steps.get(MigrationConstants.QUANTITY_COLUMN);
    		String sequence = utility.getAlphaNumericString(26,MigrationConstants.ALPHA_NUMERIC);
    		logger.info("Got the Price quantity : "+ quantity + " & componentId : " + componentId );
    		
    		logger.info("Getting the Price type");
    		String discountItemValue = MigrationConstants.RC;
    		Set<String> discountItemsKey = (Set<String>) discountItemsMap.keySet();
	       	 for (String str : discountItemsKey) {
	       		List<?> discountItemslist =(List<?>)discountItemsMap.get(str);
	       	    Map<?, ?> discountItems= (Map<?, ?>)discountItemslist.get(0);
	       		 
	       		String discountConditionId=(String) discountItems.get(MigrationConstants.CONDITION_ID_COLUMN);
	       		 if( discountConditionId.equalsIgnoreCase(conditionId)){
	       			 String discountItem = (String) discountItems.get(MigrationConstants.DISCOUNT_ITEM_VALUE);
	       			 String priceType=discountItem.substring(4,5);
	       			 if(priceType.equalsIgnoreCase(MigrationConstants.R)){
	       				discountItemValue=MigrationConstants.RC;
	       			 }else  if(priceType.equalsIgnoreCase(MigrationConstants.S)){
	       				discountItemValue=MigrationConstants.OC;
	       			 }
	       			break;
	       		 }
			}
	       	logger.info("Got the Price type :" + discountItemValue); 
    	 
    		
    		PriceData priceDataObject=new PriceData();
    		priceDataObject.setDescription(new Description("",""));
    		priceDataObject.setImmediatePayOption(null);
    		priceDataObject.setInstallments(null);
    		
    		priceDataObject.setKey(new Key(sequence, componentId, componentId+MigrationConstants.ID_SEPARATOR+sequence));
    		priceDataObject.setKeyPathMap(null);
    		
    		priceDataObject.setName(new PriceName(MigrationConstants.SERVICE_DISCOUNT));
    		
    		priceDataObject.setOverrideOption(null);
    		priceDataObject.setOwner(null);
    		
    		priceDataObject.setPolicy(new Policy(utility.getAlphaNumericString(32,MigrationConstants.ALPHA_NUMERIC),""));
    		
    		priceDataObject.setPopRelationship(null);
  		 
    		List<Price> priceList=new ArrayList<>();
    		Price price=new Price();
    		price.setDutyFreeAmount(null);
    		price.setId(utility.getAlphaNumericString(32,MigrationConstants.ALPHA_NUMERIC));
    		price.setPercentage(null);
    		price.setPriceReduction(new PriceReduction(MigrationConstants.USD,quantity));
    		price.setTaxIncludedAmount(null);
    		price.setValidFor(new ValidFor(null, "2017-01-01T00:00:00Z"));
    		priceList.add(price);
    		priceDataObject.setPrice(priceList);
    		
    		priceDataObject.setId(componentId);
    		priceDataObject.setPriceAlterationCategory(null);
    		priceDataObject.setPriceCategory(null);
    		priceDataObject.setPriceDifference(null);
    		priceDataObject.setPriceEvent(null);
    		priceDataObject.setPriceType(discountItemValue);
    		priceDataObject.setRecurringChargePeriodLength(MigrationConstants._1);
    		priceDataObject.setRecurringChargePeriodType(MigrationConstants.MONTH);
    		priceDataObject.setRole(MigrationConstants.PROMOTION_PRICE_ALT); 
    		priceDataObject.setTaxIncluded(MigrationConstants.EXCLUDED);
    		priceDataObject.setType(MigrationConstants.SIMPLEPRICE);
    		priceDataObject.setUnitOfMeasure(null);
    		logger.info("Completed Binding of CSV data to Price");
    		String fileName = pathPriceJson+ "\\"+componentId+MigrationConstants.ID_SEPARATOR+sequence+".json";
    		logger.info("\n Location of Price Json filename : "+componentId+MigrationConstants.ID_SEPARATOR+sequence+".json");
    		System.out.print("\n Location of Price Json filename : "+componentId+MigrationConstants.ID_SEPARATOR+sequence+".json");
    		
    		utility.writeAsJson(priceDataObject, fileName);
        }
    		
	}
}
