package model;

import java.util.List;

public class PromotionPattern {
	String id;
	List<PromotionAction> listOfPromotionAction;
	PromotionCriteriaGroup listOfPromotionCriteriaGroup;
	String relationTypeAmongGroup;
	public PromotionPattern() {
		super();
	}
	public PromotionPattern(String id, List<PromotionAction> listOfPromotionAction,
			PromotionCriteriaGroup listOfPromotionCriteriaGroup, String relationTypeAmongGroup) {
		super();
		this.id = id;
		this.listOfPromotionAction = listOfPromotionAction;
		this.listOfPromotionCriteriaGroup = listOfPromotionCriteriaGroup;
		this.relationTypeAmongGroup = relationTypeAmongGroup;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<PromotionAction> getListOfPromotionAction() {
		return listOfPromotionAction;
	}
	public void setPromotionAction(List<PromotionAction> listOfPromotionAction) {
		this.listOfPromotionAction = listOfPromotionAction;
	}
	public PromotionCriteriaGroup getListOfPromotionCriteriaGroup() {
		return listOfPromotionCriteriaGroup;
	}
	public void setPromotionCriteriaGroup(PromotionCriteriaGroup listOfPromotionCriteriaGroup) {
		this.listOfPromotionCriteriaGroup = listOfPromotionCriteriaGroup;
	}
	public String getRelationTypeAmongGroup() {
		return relationTypeAmongGroup;
	}
	public void setRelationTypeAmongGroup(String relationTypeAmongGroup) {
		this.relationTypeAmongGroup = relationTypeAmongGroup;
	}
	
}
