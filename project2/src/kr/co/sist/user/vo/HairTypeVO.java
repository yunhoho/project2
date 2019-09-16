package kr.co.sist.user.vo;

public class HairTypeVO {
	private String hairType,hairCategory,hairName,hairNameCode;
	private int hairPrice;
	public HairTypeVO(String hairType, String hairCategory, String hairName, String hairNameCode, int hairPrice) {
		super();
		this.hairType = hairType;
		this.hairCategory = hairCategory;
		this.hairName = hairName;
		this.hairNameCode = hairNameCode;
		this.hairPrice = hairPrice;
	}
	/**
	 * @return the hairType
	 */
	public String getHairType() {
		return hairType;
	}
	/**
	 * @return the hairCategory
	 */
	public String getHairCategory() {
		return hairCategory;
	}
	/**
	 * @return the hairName
	 */
	public String getHairName() {
		return hairName;
	}
	/**
	 * @return the hairNameCode
	 */
	public String getHairNameCode() {
		return hairNameCode;
	}
	/**
	 * @return the hairPrice
	 */
	public int getHairPrice() {
		return hairPrice;
	}
	
	@Override
	public String toString() {
		return "HairTypeVO [hairType=" + hairType + ", hairCategory=" + hairCategory + ", hairName=" + hairName
				+ ", hairNameCode=" + hairNameCode + ", hairPrice=" + hairPrice + "]";
	}
	
	
}
