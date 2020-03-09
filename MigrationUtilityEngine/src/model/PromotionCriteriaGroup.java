package model;

import java.util.List;

public class PromotionCriteriaGroup {
	 String id;
	 String groupName;
	 String criteriaType;
	 String criteriaTypeMethod;
	 String relationTypeInGroup;
	 List<PromotionCriteria> promotionCriteria;
	 PromotionCriteriaGroup promotionCriteriaGroup;
	 String scopeCriteria;
	 String aggregationFunctionCriteria;
	 
	public PromotionCriteriaGroup() {
		super();
	}
	public PromotionCriteriaGroup(String id, String groupName, String criteriaType, String criteriaTypeMethod,
			String relationTypeInGroup, List<PromotionCriteria> promotionCriteria,
			PromotionCriteriaGroup promotionCriteriaGroup, String scopeCriteria,
			String aggregationFunctionCriteria) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.criteriaType = criteriaType;
		this.criteriaTypeMethod = criteriaTypeMethod;
		this.relationTypeInGroup = relationTypeInGroup;
		this.promotionCriteria = promotionCriteria;
		this.promotionCriteriaGroup = promotionCriteriaGroup;
		this.scopeCriteria = scopeCriteria;
		this.aggregationFunctionCriteria = aggregationFunctionCriteria;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCriteriaType() {
		return criteriaType;
	}
	public void setCriteriaType(String criteriaType) {
		this.criteriaType = criteriaType;
	}
	public String getCriteriaTypeMethod() {
		return criteriaTypeMethod;
	}
	public void setCriteriaTypeMethod(String criteriaTypeMethod) {
		this.criteriaTypeMethod = criteriaTypeMethod;
	}
	public String getRelationTypeInGroup() {
		return relationTypeInGroup;
	}
	public void setRelationTypeInGroup(String relationTypeInGroup) {
		this.relationTypeInGroup = relationTypeInGroup;
	}
	public List<PromotionCriteria> getPromotionCriteria() {
		return promotionCriteria;
	}
	public void setPromotionCriteria(List<PromotionCriteria> promotionCriteria) {
		this.promotionCriteria = promotionCriteria;
	}
	public PromotionCriteriaGroup getPromotionCriteriaGroup() {
		return promotionCriteriaGroup;
	}
	public void setPromotionCriteriaGroup(PromotionCriteriaGroup promotionCriteriaGroup) {
		this.promotionCriteriaGroup = promotionCriteriaGroup;
	}
	public String getScopeCriteria() {
		return scopeCriteria;
	}
	public void setScopeCriteria(String scopeCriteria) {
		this.scopeCriteria = scopeCriteria;
	}
	public String getAggregationFunctionCriteria() {
		return aggregationFunctionCriteria;
	}
	public void setAggregationFunctionCriteria(String aggregationFunctionCriteria) {
		this.aggregationFunctionCriteria = aggregationFunctionCriteria;
	}
	 
}
