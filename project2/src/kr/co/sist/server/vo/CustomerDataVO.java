package kr.co.sist.server.vo;

public class CustomerDataVO {
	private String cName,cPhone,cGender,bDate;

	public CustomerDataVO(String cName, String cPhone, String cGender, String bDate) {
		super();
		this.cName = cName;
		this.cPhone = cPhone;
		this.cGender = cGender;
		this.bDate = bDate;
	}

	public String getcName() {
		return cName;
	}

	public String getcPhone() {
		return cPhone;
	}

	public String getcGender() {
		return cGender;
	}

	public String getbDate() {
		return bDate;
	}

	@Override
	public String toString() {
		return "CustomerDataVO [cName=" + cName + ", cPhone=" + cPhone + ", cGender=" + cGender + ", bDate=" + bDate
				+ "]";
	}
	
}
