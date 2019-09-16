package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.vo.HairTypeVO;

public class BookingDAO {
	private static BookingDAO bDAO;

	private BookingDAO() {

	}// BookingDAO

	public static BookingDAO getInstance() {
		if (bDAO == null) {
			bDAO = new BookingDAO();
		} // end if
		return bDAO;
	}// getinstance

	private Connection getConnection() throws SQLException {
		Connection con = null;
		// 1. µå¶óÀÌ¹ö ·Îµù(ojdbc8.jar)
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Ä¿³Ø¼Ç ¾ò±â
		String url = "jdbc:oracle:thin:@211.63.89.137:1521:orcl";//127.0.0.1   , localhost
		String id = "hair";
		String pass = "salon";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection
	
	public List<HairTypeVO> selectCutHairType() throws SQLException {
		List<HairTypeVO> list = new ArrayList<HairTypeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder selectHairType = new StringBuilder();
			selectHairType
			.append(" select t_name, t_category,t_type,t_code, price  ")
			.append(" from treatment ")
			.append(" where t_type like 'ÄÆ' ");
//			.append(" where t_type like %? ");
			
			pstmt = con.prepareStatement(selectHairType.toString());
			
//			pstmt.setString(1, "ÄÆ");
			rs = pstmt.executeQuery();
			HairTypeVO htvo = null;
			while(rs.next()) {
				htvo = new HairTypeVO(rs.getString("t_type"), rs.getString("t_category"), rs.getString("t_name"), rs.getString("t_code"), rs.getInt("price"));
				list.add(htvo);
			}//end while
			
		}finally {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}//end finally
		
		return list;
	}//selectAllHairType
	
	public List<HairTypeVO> selectPermHairType() throws SQLException {
		List<HairTypeVO> list = new ArrayList<HairTypeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder selectHairType = new StringBuilder();
			selectHairType
			.append(" select t_name, t_category,t_type,t_code, price  ")
			.append(" from treatment ")
			.append(" where t_category like 'ÀÏ¹ÝÆß' ");
//			.append(" where t_type like %? ");
			
			pstmt = con.prepareStatement(selectHairType.toString());
			
//			pstmt.setString(1, "ÄÆ");
			rs = pstmt.executeQuery();
			HairTypeVO htvo = null;
			while(rs.next()) {
				htvo = new HairTypeVO(rs.getString("t_type"), rs.getString("t_category"), rs.getString("t_name"), rs.getString("t_code"), rs.getInt("price"));
				list.add(htvo);
			}//end while
			
		}finally {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}//end finally
		
		return list;
	}//selectPermHairType
	
	public List<HairTypeVO> selectSpecialPermType() throws SQLException {
		List<HairTypeVO> list = new ArrayList<HairTypeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder selectSpecialPermType = new StringBuilder();
			selectSpecialPermType
			.append(" select t_name, t_category,t_type,t_code, price  ")
			.append(" from treatment ")
			.append(" where t_category like 'Æ¯¼öÆß' ");
//			.append(" where t_type like %? ");
			
			pstmt = con.prepareStatement(selectSpecialPermType.toString());
			
//			pstmt.setString(1, "ÄÆ");
			rs = pstmt.executeQuery();
			HairTypeVO htvo = null;
			while(rs.next()) {
				htvo = new HairTypeVO(rs.getString("t_type"), rs.getString("t_category"), rs.getString("t_name"), rs.getString("t_code"), rs.getInt("price"));
				list.add(htvo);
			}//end while
			
		}finally {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}//end finally
		
		return list;
	}//selectPermHairType
	
	public List<HairTypeVO> selectDyeType() throws SQLException {
		List<HairTypeVO> list = new ArrayList<HairTypeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder selectDyeType = new StringBuilder();
			selectDyeType
			.append(" select t_name, t_category,t_type,t_code, price  ")
			.append(" from treatment ")
			.append(" where t_category like '¿°»ö' ");
//			.append(" where t_type like %? ");
			
			pstmt = con.prepareStatement(selectDyeType.toString());
			
//			pstmt.setString(1, "ÄÆ");
			rs = pstmt.executeQuery();
			HairTypeVO htvo = null;
			while(rs.next()) {
				htvo = new HairTypeVO(rs.getString("t_type"), rs.getString("t_category"), rs.getString("t_name"), rs.getString("t_code"), rs.getInt("price"));
				list.add(htvo);
			}//end while
			
		}finally {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}//end finally
		
		return list;
	}//selectPermHairType
	
	public List<HairTypeVO> selectBleachType() throws SQLException {
		List<HairTypeVO> list = new ArrayList<HairTypeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder selectBleachType = new StringBuilder();
			selectBleachType
			.append(" select t_name, t_category,t_type,t_code, price  ")
			.append(" from treatment ")
			.append(" where t_category like 'Å»»ö' ");
//			.append(" where t_type like %? ");
			
			pstmt = con.prepareStatement(selectBleachType.toString());
			
//			pstmt.setString(1, "ÄÆ");
			rs = pstmt.executeQuery();
			HairTypeVO htvo = null;
			while(rs.next()) {
				htvo = new HairTypeVO(rs.getString("t_type"), rs.getString("t_category"), rs.getString("t_name"), rs.getString("t_code"), rs.getInt("price"));
				list.add(htvo);
			}//end while
			
		}finally {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}//end finally
		
		return list;
	}//selectBleachType
	
	public List<HairTypeVO> selectClinicType() throws SQLException {
		List<HairTypeVO> list = new ArrayList<HairTypeVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			StringBuilder selectClinicType = new StringBuilder();
			selectClinicType
			.append(" select t_name, t_category,t_type,t_code, price  ")
			.append(" from treatment ")
			.append(" where t_type like 'Å¬¸®´Ð' ");
//			.append(" where t_type like %? ");
			
			pstmt = con.prepareStatement(selectClinicType.toString());
			
//			pstmt.setString(1, "ÄÆ");
			rs = pstmt.executeQuery();
			HairTypeVO htvo = null;
			while(rs.next()) {
				htvo = new HairTypeVO(rs.getString("t_type"), rs.getString("t_category"), rs.getString("t_name"), rs.getString("t_code"), rs.getInt("price"));
				list.add(htvo);
			}//end while
			
		}finally {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
		}//end finally
		
		return list;
	}//selectBleachType
	
	public static void main(String[] args) {
		BookingDAO bd = BookingDAO.getInstance();
		try {
			System.out.println(bd.selectBleachType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
}//class
