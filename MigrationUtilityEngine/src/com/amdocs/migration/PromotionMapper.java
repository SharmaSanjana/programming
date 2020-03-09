package com.amdocs.migration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ActionObjectRef;
import model.Description;
import model.Key;
import model.Message;
import model.Messages;
import model.Name;
import model.Promotion;
import model.PromotionAction;
import model.PromotionCriteria;
import model.PromotionCriteriaGroup;
import model.PromotionPattern;
import model.ValidFor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author marathej
 *
 */
@Component
public class PromotionMapper {

	@Autowired
	private Utility utility;
	
  public static final Logger logger = Logger.getLogger(PromotionMapper.class);
    
    public Object generateJsons(Map<String, ?> planMap , Map<?, ?> conditionMap , Map<?, ?> eligibilityMap ,Map<?, ?> itemsMap) throws IOException{
    	
    	Set<String> planNames = planMap.keySet();
    	
    	for(String planName : planNames){	
    	 List<?> planlist =(List<?>)planMap.get(planName);
    	 Map<?, ?> plan= (Map<?, ?>)planlist.get(0);
    	 List<?> conditionList =(List<?>)conditionMap.get(planName);
    	 Map<?, ?> condition= (Map<?, ?>)conditionList.get(0);
    	 List<?> eligibilityList= (List<?>)eligibilityMap.get(condition.get("CONDITION_ID"));
    	 
    	 Promotion promotion =new Promotion();
    	 promotion.setKey(new Key(plan.get("VERSION_ID")+"_"+planName, "IPromotionDTO", "IPromotionDTO_"+plan.get("VERSION_ID")+"_"+planMap));
    	 promotion.setId(planName);
    	 promotion.setHref(null);
    	 promotion.setName(new Name("en_US", planName));
    	 promotion.setCrossProduct(false);
    	 promotion.setDescription(new Description("en_US", (String)plan.get("PLAN_DESC")));
    	 promotion.setValidFor(new ValidFor((String)plan.get("EFFECTIVE_START_TIME"), (String)plan.get("EFFECTIVE_END_TIME")));
    	 promotion.setPriority((String)plan.get("PLAN_RANK"));
    	 promotion.setMessages(new Messages(null , new Message("",(String)plan.get("PLAN_DESC"))));
    	 promotion.setProductPromotion(null);
    	 promotion.setExposureTime("2019-05-12T15:43:30");
    	 promotion.setCatalogReleaseId((String)plan.get("VERSION_ID"));
    	 promotion.setCatalogReleaseSequence(0);
    	 promotion.setIsProductPromotion(false);
    	 
         PromotionPattern promotionPattern = new PromotionPattern();
    	 promotionPattern.setId(planName);
    	 promotionPattern.setRelationTypeAmongGroup("AND");
    	 PromotionAction promotionAction = new PromotionAction();
    	 promotionAction.setId("Sample Price ID");
    	 promotionAction.setActionType("Price Allteration");
    	    	 
         List<ActionObjectRef> actionObjectRefList = new ArrayList<ActionObjectRef>();
    	 for(Object obj : eligibilityList){
    		 Map eligibilityItem =(Map)obj;
    		 ActionObjectRef actionObjectRef = new ActionObjectRef();
    		 actionObjectRef.setId((String)eligibilityItem.get("DISCOUNT_ITEM_ID"));
    		 actionObjectRefList.add(actionObjectRef);
    	 }
         
    	 promotionAction.setActionObjectRef(actionObjectRefList);
    	 List<PromotionAction> promotionActionList= new ArrayList<PromotionAction>();
    	 promotionPattern.setPromotionAction(promotionActionList);
         PromotionCriteriaGroup promotionCriteriaGroup1 = new PromotionCriteriaGroup();
 		 promotionCriteriaGroup1.setId((String)condition.get("CONDITION_ID"));
 		 promotionCriteriaGroup1.setGroupName("CriteriaGroupForEachDiscountItem");
 		 promotionCriteriaGroup1.setCriteriaType("ProductOffering");
 		 promotionCriteriaGroup1.setCriteriaTypeMethod("LIST");
 		 promotionCriteriaGroup1.setRelationTypeInGroup("AND");
 		 promotionCriteriaGroup1.setPromotionCriteria(null);
 		 promotionCriteriaGroup1.setScopeCriteria(null);
 		 promotionCriteriaGroup1.setAggregationFunctionCriteria(null);
 		 
 		PromotionCriteriaGroup promotionCriteriaGroup2 = new PromotionCriteriaGroup();
		promotionCriteriaGroup2.setId((String)condition.get("CONDITION_ID"));
		promotionCriteriaGroup2.setGroupName("DummyCriteriaGroupForEligibilityItems");
		promotionCriteriaGroup2.setCriteriaType("ProductOffering");
		promotionCriteriaGroup2.setCriteriaTypeMethod("LIST");
		promotionCriteriaGroup2.setRelationTypeInGroup("OR");
		promotionCriteriaGroup2.setPromotionCriteria(null);
		promotionCriteriaGroup2.setScopeCriteria(null);
		promotionCriteriaGroup2.setAggregationFunctionCriteria(null);
		
	
		for(Object obj : eligibilityList){
    		
    		@SuppressWarnings("rawtypes")
			Map eligibilityItem =(Map)obj;
    		
    		PromotionCriteriaGroup promotionCriteriaGroup= new PromotionCriteriaGroup();
    		String DISCOUNT_ITEM_ID =(String)eligibilityItem.get("DISCOUNT_ITEM_ID");
    		promotionCriteriaGroup.setId(DISCOUNT_ITEM_ID);
    		actionObjectRefList.add(new ActionObjectRef(DISCOUNT_ITEM_ID));
    		System.out.println(promotionCriteriaGroup.getId());
    		promotionCriteriaGroup.setGroupName("CriteriaGroupForEachDiscountItem");
    		promotionCriteriaGroup.setCriteriaType("ProductOffering");
    		promotionCriteriaGroup.setCriteriaTypeMethod("CRITERIA");
    		promotionCriteriaGroup.setRelationTypeInGroup("AND");
    		promotionCriteriaGroup.setScopeCriteria(null);
    		promotionCriteriaGroup.setAggregationFunctionCriteria(null);
    		
    		List itemList= (List) itemsMap.get(DISCOUNT_ITEM_ID);
    	    Map item= (Map)itemList.get(0);
    	    String DISCOUNT_ITEM_VALUE=(String)item.get("DISCOUNT_ITEM_VALUE");
    	    System.out.println(DISCOUNT_ITEM_VALUE);
    	    String [] DISCOUNT_ITEM_VALUE_Array =DISCOUNT_ITEM_VALUE.split(";");
    	    List promotionCriteriaList = new ArrayList();
    	    for(int i=0; i<3 ; i++){
    	    	    PromotionCriteria promotionCriteria = new PromotionCriteria();
    	    		promotionCriteria.setId(null);
    	    		promotionCriteria.setCriteriaParam("product.characteristic");
    	    		promotionCriteria.setCriteriaParamName("typeGroup");
    	    		promotionCriteria.setCriteriaOperator("equals");
    	    		System.out.println(DISCOUNT_ITEM_VALUE_Array[i]);
    	    		promotionCriteria.setCriteriaValue(DISCOUNT_ITEM_VALUE_Array[i]);
    	    		promotionCriteriaList.add(promotionCriteria);
    	     }
    	    promotionCriteriaGroup.setPromotionCriteria(promotionCriteriaList);
    	    
    	    promotionCriteriaGroup2.setPromotionCriteriaGroup(promotionCriteriaGroup);
		}
    	    promotionCriteriaGroup1.setPromotionCriteriaGroup(promotionCriteriaGroup2);
    	    
 
		promotionPattern.setPromotionCriteriaGroup(promotionCriteriaGroup1);
		
		promotion.setPromotionPattern(promotionPattern);
		
		String fileName = "C:/Ajinkya/Migration/Data/MigrationUtilityEngine/resources/outputJson/"+planName+".json";
		System.out.println(promotion);
	
		utility.writeAsJson(promotion, fileName);
    		break;
    	}
    	
    	
    	return null;
    }
    
}
