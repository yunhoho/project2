package kr.co.sist.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.server.vo.CustomerDataVO;

public class CustomerDAO {
	private static CustomerDAO cDAO;
	
	//singleton
	private CustomerDAO() {
		
	}//CutomerDAO
	
	public static CustomerDAO getInstance() {
		if(cDAO==null) {
			cDAO=new CustomerDAO();
		}//if
		return cDAO;
	}//getInstance
	private Connection getConnection() throws SQLException{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch (ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}//catch
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="hair";
		String pass="salon";
				
		con=DriverManager.getConnection(url,id,pass);
		return con;
	}//connection
	
	public List<CustomerDataVO> selectAllCustomerData(String cName)throws SQLException {
		List<CustomerDataVO> list=new ArrayList<CustomerDataVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//커넥션 얻기
			con=getConnection();
			//쿼리문 생성객체 얻기 customerData테이블에서
				StringBuilder selectCustomerData=new StringBuilder();
				
				
				
				if(cName!=null) {
				selectCustomerData
				.append(" select c_name, c_phone, c_gender,b_date ")
				.append(" from booking ")
				.append(" where c_name= ? ")
				.append(" order by b_date ");
				pstmt=con.prepareStatement(selectCustomerData.toString());
				pstmt.setString(1, cName);
				} else {
					selectCustomerData
					.append(" select c_name, c_phone, c_gender,b_date ")
					.append(" from booking ")
					.append(" order by b_date ");
					pstmt=con.prepareStatement(selectCustomerData.toString());
				}
				
			//쿼리수행 후 결과 얻기
				rs=pstmt.executeQuery();
				CustomerDataVO cdv=null;
				while (rs.next()) {
					cdv=new CustomerDataVO(rs.getString("c_name"), rs.getString("c_phone"),
								rs.getString("c_gender"), rs.getString("b_date"));
					list.add(cdv);
				}//while
		}finally {
			//연결끊기
		if(rs!=null) {rs.close();}
		if(pstmt!=null) {pstmt.close();}
		if(con!=null) {con.close();}
		}//finally
			return list;
	}//setctAllcustomerDATA
}//customerDAO
