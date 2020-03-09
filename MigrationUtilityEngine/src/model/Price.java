package model;

public class Price {

	String dutyFreeAmount;
	String id;
	String percentage;
	PriceReduction priceReduction;
	String taxIncludedAmount;
	ValidFor validFor;
	
	public String getDutyFreeAmount() {
		return dutyFreeAmount;
	}
	public void setDutyFreeAmount(String dutyFreeAmount) {
		this.dutyFreeAmount = dutyFreeAmount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public PriceReduction getPriceReduction() {
		return priceReduction;
	}
	public void setPriceReduction(PriceReduction priceReduction) {
		this.priceReduction = priceReduction;
	}
	public String getTaxIncludedAmount() {
		return taxIncludedAmount;
	}
	public void setTaxIncludedAmount(String taxIncludedAmount) {
		this.taxIncludedAmount = taxIncludedAmount;
	}
	public ValidFor getValidFor() {
		return validFor;
	}
	public void setValidFor(ValidFor validFor) {
		this.validFor = validFor;
	}
	
	
}
