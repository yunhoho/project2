package kr.co.sist.server.vo;

public class BookingVO {
	private String bookingTime, clientName, phoneNum, staffName, paymentFlag;
	private int price;
	
	public BookingVO(String bookingTime, String clientName, String phoneNum, String staffName, String paymentFlag,
			int price) {
		super();
		this.bookingTime = bookingTime;
		this.clientName = clientName;
		this.phoneNum = phoneNum;
		this.staffName = staffName;
		this.paymentFlag = paymentFlag;
		this.price = price;
	}//BookingVO

	public String getBookingTime() {
		return bookingTime;
	}

	public String getClientName() {
		return clientName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getStaffName() {
		return staffName;
	}

	public String getPaymentFlag() {
		return paymentFlag;
	}

	public int getPrice() {
		return price;
	}
	
	
	
}//BookingVO
