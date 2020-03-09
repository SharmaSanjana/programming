package model;

public class PromotionCriteria {
	 String id;
     String criteriaParam;
     String criteriaParamName;
     String criteriaOperator;
     String criteriaValue;
	public PromotionCriteria(String id, String criteriaParam, String criteriaParamName, String criteriaOperator,
			String criteriaValue) {
		super();
		this.id = id;
		this.criteriaParam = criteriaParam;
		this.criteriaParamName = criteriaParamName;
		this.criteriaOperator = criteriaOperator;
		this.criteriaValue = criteriaValue;
	}
	public String getId() {
		return id;
	}
	public PromotionCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCriteriaParam() {
		return criteriaParam;
	}
	public void setCriteriaParam(String criteriaParam) {
		this.criteriaParam = criteriaParam;
	}
	public String getCriteriaParamName() {
		return criteriaParamName;
	}
	public void setCriteriaParamName(String criteriaParamName) {
		this.criteriaParamName = criteriaParamName;
	}
	public String getCriteriaOperator() {
		return criteriaOperator;
	}
	public void setCriteriaOperator(String criteriaOperator) {
		this.criteriaOperator = criteriaOperator;
	}
	public String getCriteriaValue() {
		return criteriaValue;
	}
	public void setCriteriaValue(String criteriaValue) {
		this.criteriaValue = criteriaValue;
	}
    
}
