package model;

import java.util.List;

public class PromotionAction {
	String id;
	String actionType;
	String actionValue;
	String actionObjectId;
	Duration duration;
	ActionDiscount actionDiscount;
	String actionObject;
    List<ActionObjectRef> actionObjectRef;
    Name name;
    Description description;
    
	public PromotionAction() {
		super();
	}
	public PromotionAction(String id, String actionType, String actionValue, String actionObjectId, Duration duration,
			ActionDiscount actionDiscount, String actionObject, List<ActionObjectRef> actionObjectRef, Name name,
			Description description) {
		super();
		this.id = id;
		this.actionType = actionType;
		this.actionValue = actionValue;
		this.actionObjectId = actionObjectId;
		this.duration = duration;
		this.actionDiscount = actionDiscount;
		this.actionObject = actionObject;
		this.actionObjectRef = actionObjectRef;
		this.name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionValue() {
		return actionValue;
	}
	public void setActionValue(String actionValue) {
		this.actionValue = actionValue;
	}
	public String getActionObjectId() {
		return actionObjectId;
	}
	public void setActionObjectId(String actionObjectId) {
		this.actionObjectId = actionObjectId;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public ActionDiscount getActionDiscount() {
		return actionDiscount;
	}
	public void setActionDiscount(ActionDiscount actionDiscount) {
		this.actionDiscount = actionDiscount;
	}
	public String getActionObject() {
		return actionObject;
	}
	public void setActionObject(String actionObject) {
		this.actionObject = actionObject;
	}
	public List<ActionObjectRef> getActionObjectRef() {
		return actionObjectRef;
	}
	public void setActionObjectRef(List<ActionObjectRef> actionObjectRef) {
		this.actionObjectRef = actionObjectRef;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
    
}
