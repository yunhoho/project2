package kr.co.sist.user.vo;

public class DesignerDateVO {
	
	private String designer,year,month,day,time,p_code;
	private int p_charge,empno;
	public DesignerDateVO(String designer, String year, String month, String day, String time, String p_code,
			int p_charge, int empno) {
		super();
		this.designer = designer;
		this.year = year;
		this.month = month;
		this.day = day;
		this.time = time;
		this.p_code = p_code;
		this.p_charge = p_charge;
		this.empno = empno;
	}
	public String getDesigner() {
		return designer;
	}
	public String getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	public String getDay() {
		return day;
	}
	public String getTime() {
		return time;
	}
	public String getP_code() {
		return p_code;
	}
	public int getP_charge() {
		return p_charge;
	}
	public int getEmpno() {
		return empno;
	}
	
	@Override
	public String toString() {
		return "DesignerDateVO [designer=" + designer + ", year=" + year + ", month=" + month + ", day=" + day
				+ ", time=" + time + ", p_code=" + p_code + ", p_charge=" + p_charge + ", empno=" + empno + "]";
	}
	
	
	

}
