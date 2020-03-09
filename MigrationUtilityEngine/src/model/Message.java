package model;

public class Message {
	String locale;
    String value;
	public Message(String locale, String value) {
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
