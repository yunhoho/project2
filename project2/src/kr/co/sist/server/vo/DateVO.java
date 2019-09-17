package kr.co.sist.server.vo;

public class DateVO {
	private String year, month;
	
	public DateVO(String year, String month) {
		this.year=year;
		this.month=month;
	}//DateVO

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}
	
	
}
