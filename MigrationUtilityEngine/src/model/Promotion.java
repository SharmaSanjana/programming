package model;

import java.util.List;


public class Promotion{

	
	Key key;
	String id;
	String href;
	
	Name name;
	boolean crossProduct;
	
	Description description;
	
	ValidFor validFor;
	String priority;
	
    Messages messages;
	String attachment;
	
	PromotionPattern promotionPattern;
	String productPromotion;
	
	List<ProductTriggerItem> productTriggerItem;
	
	List<ProductBenefitItem> productBenefitItem;
	String exposureTime;
	String catalogReleaseId;
	int catalogReleaseSequence;
	boolean isProductPromotion;
	
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public boolean getCrossProduct() {
		return crossProduct;
	}
	public void setCrossProduct(Boolean crossProduct) {
		this.crossProduct = crossProduct;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public ValidFor getValidFor() {
		return validFor;
	}
	public void setValidFor(ValidFor validFor) {
		this.validFor = validFor;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Messages getMessages() {
		return messages;
	}
	public void setMessages(Messages messages) {
		this.messages = messages;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public PromotionPattern getPromotionPattern() {
		return promotionPattern;
	}
	public void setPromotionPattern(PromotionPattern promotionPattern) {
		this.promotionPattern = promotionPattern;
	}
	public String getProductPromotion() {
		return productPromotion;
	}
	public void setProductPromotion(String productPromotion) {
		this.productPromotion = productPromotion;
	}
	public List<ProductTriggerItem> getProductTriggerItem() {
		return productTriggerItem;
	}
	public void setProductTriggerItem(List<ProductTriggerItem> productTriggerItem) {
		this.productTriggerItem = productTriggerItem;
	}
	public List<ProductBenefitItem> getProductBenefitItem() {
		return productBenefitItem;
	}
	public void setProductBenefitItem(List<ProductBenefitItem> productBenefitItem) {
		this.productBenefitItem = productBenefitItem;
	}
	public String getExposureTime() {
		return exposureTime;
	}
	public void setExposureTime(String exposureTime) {
		this.exposureTime = exposureTime;
	}
	public String getCatalogReleaseId() {
		return catalogReleaseId;
	}
	public void setCatalogReleaseId(String catalogReleaseId) {
		this.catalogReleaseId = catalogReleaseId;
	}
	public int getCatalogReleaseSequence() {
		return catalogReleaseSequence;
	}
	public void setCatalogReleaseSequence(int catalogReleaseSequence) {
		this.catalogReleaseSequence = catalogReleaseSequence;
	}
	public Boolean getIsProductPromotion() {
		return isProductPromotion;
	}
	public void setIsProductPromotion(Boolean isProductPromotion) {
		this.isProductPromotion = isProductPromotion;
	}

	/*@Override
	public String toString() {
		return "Promotion [key=" + key + ", id=" + id + ", href=" + href + ", name=" + name + ", crossProduct="
				+ crossProduct + ", description=" + description + ", validFor=" + validFor + ", priority=" + priority
				+ ", messages=" + messages + ", attachment=" + attachment + ", promotionPattern=" + promotionPattern
				+ ", productPromotion=" + productPromotion + ", productTriggerItem=" + productTriggerItem
				+ ", productBenefitItem=" + productBenefitItem + ", exposureTime=" + exposureTime
				+ ", catalogReleaseId=" + catalogReleaseId + ", catalogReleaseSequence=" + catalogReleaseSequence
				+ ", isProductPromotion=" + isProductPromotion + "]";
	}*/
	
}
