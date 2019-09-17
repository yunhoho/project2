package kr.co.sist.server.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;




public class MonthlyMaxDay {

	private String year, month;
	private int day;
	
	public MonthlyMaxDay(String strYear, String strMonth) {
		
		this.year = strYear;
		this.month= strMonth;
		day = 1;
		
		int intYear=Integer.parseInt(year);
		int intMonth=Integer.parseInt(month);
		Calendar cal= Calendar.getInstance();
		cal.set(intYear, intMonth-1, day);
		System.out.println("�ش�⵵ : "+cal.get(Calendar.YEAR));
		System.out.println("�ش�� : "+cal.get(Calendar.MONTH));
		System.out.println("ù��° �� : "+cal.getMinimum(Calendar.DAY_OF_MONTH));
		
		System.out.println("������ ��(���� ��¥ ���� �ִ��): "+cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("������ ��(Calender�� ���� �ִ��): "+cal.getMaximum(Calendar.DAY_OF_MONTH));
		day=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
	}
	
	
	
	public int getDay() {
		return day;
	}



//	public static void main(String[] args) {
//		new MonthlyMaxDay();
//	}//main
}//class
