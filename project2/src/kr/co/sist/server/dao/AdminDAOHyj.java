package kr.co.sist.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import kr.co.sist.server.vo.BookingVO;
import kr.co.sist.server.vo.LoginVO;

public class AdminDAOHyj {
	private static AdminDAOHyj aDAOH;
	
	private AdminDAOHyj() {
	}//AdminDAOHyj
	
	public static AdminDAOHyj getInstance() {
		if(aDAOH==null) {
			aDAOH=new AdminDAOHyj();
		}//end if
		return aDAOH;
	}//getInstance
	
	private Connection getConnection() throws SQLException{
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="hair";
		String pass="salon";
		
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}//getConnection

	public String selectLogin(LoginVO lVO) throws SQLException {
		String adminName="";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=getConnection();
		StringBuilder selectName=new StringBuilder();
		selectName.append(" select id")
		.append(" from admin_login")
		.append(" where id=? and password=?");
		
		
		pstmt=con.prepareStatement(selectName.toString());
		
		pstmt.setString(1, lVO.getId());
		pstmt.setString(2, lVO.getPass());
		
//		System.out.println("id : "+lVO.getId());
//		System.out.println("pass : "+lVO.getPass());
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			adminName=rs.getString("id");
		}//end if
		
		}finally{
		if(con != null) {con.close();}
		if(pstmt != null) {pstmt.close();}
		if(rs != null) {rs.close();}
		}//end finally
		return adminName;
	}//selectLogin
	
	public List<BookingVO> selectBooking() throws SQLException{
		List<BookingVO> list=new ArrayList<BookingVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//2.커넥션얻기
		con=getConnection();
		//3.쿼리문생성객체 얻기: Lunch테이블에서 이름,코드,가격,입력일을 가장 최근에 입력된것 부터 조회 
		StringBuilder selectLunch=new StringBuilder();
		selectLunch.append(" select b_date||' '||b_time bookingTime, c_name, c_phone, e.e_name, total_price, cfr_payment ")
		.append(" from booking b, emp e")
		.append(" where b.empno=e.empno and cfr_payment = 'N' ");
		
		pstmt=con.prepareStatement(selectLunch.toString());
		//4.바인드 변수 값넣기
		//5.쿼리문 실행 후 결과얻기
		rs=pstmt.executeQuery();
		BookingVO lv=null;
		
		while(rs.next()) {
			lv=new BookingVO(rs.getString("bookingTime"),rs.getString("c_name"),rs.getString("c_phone"),rs.getString("e_name"),
					rs.getString("cfr_payment"), rs.getInt("total_price"));
			list.add(lv);
		}//end while
		}finally {
		//6.연결끊기
			if(con != null) {con.close();}
			if(pstmt != null) {pstmt.close();}
			if(rs != null) {rs.close();}
		}//end finally
		return list;
	}//selectBooking
	

}//class
