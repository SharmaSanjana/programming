package model;

public class Name {
	String locale;
    String value;
	public Name(String locale, String value) {
		super();
		this.locale = locale;
		this.value = value;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
