package model;

public class Key {
	String sequence;
	String entityType;
	String keyString;
	
	public Key(String sequence, String entityType, String keyString) {
		super();
		this.sequence = sequence;
		this.entityType = entityType;
		this.keyString = keyString;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}
	
	
}
