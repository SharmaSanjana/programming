package model;

public class ValidFor {
	String startDatetime;
	String endDatetime;
	public ValidFor(String startDatetime, String endDatetime) {
		super();
		this.startDatetime = startDatetime;
		this.endDatetime = endDatetime;
	}
	public String getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}
	public String getEndDatetime() {
		return endDatetime;
	}
	public void setEndDatetime(String endDatetime) {
		this.endDatetime = endDatetime;
	}
	
}
