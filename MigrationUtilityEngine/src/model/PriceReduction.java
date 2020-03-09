package model;

public class PriceReduction {
	
	String  unit;
    String value;
    
    
    public PriceReduction(String unit, String value) {
		super();
		this.unit = unit;
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
    
}
