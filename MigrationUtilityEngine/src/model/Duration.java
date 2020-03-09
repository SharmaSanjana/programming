package model;

public class Duration {
	String units;
    String amount;
	public Duration(String units, String amount) {
		super();
		this.units = units;
		this.amount = amount;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
    
}
