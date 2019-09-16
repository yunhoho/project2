package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.vo.DesignerDateVO;
import kr.co.sist.user.vo.HairTypeVO;


public class BookingDAO {
	
	private static BookingDAO bDAO;
	
	private BookingDAO() {
		
	}//BookingDAO
	
	public static BookingDAO getInstance() {
		if(bDAO==null) {
			bDAO=new BookingDAO();
		}
		return bDAO; 
	}//getInstance
	
	private Connection getConn() throws SQLException {
		Connection con=null;
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="hair";
		String pass="salon";
		
		con=DriverManager.getConnection(url, id, pass);
	
		return con;
	}//getConn
	
	public List<HairTypeVO> selectHairType() throws SQLException{
		
		List<HairTypeVO> hairTypeList=new ArrayList<HairTypeVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//2.커넥션 얻기
			con=getConn();
			//3.쿼리문 생성객체 얻기: lunch테이블에서 번호,이미지,도시락명(코드),가격
			StringBuilder selectHairT=new StringBuilder();
			selectHairT
			.append(" select t_code,t_type,t_category,t_name,price")
			.append(" from treatment");

			pstmt=con.prepareStatement(selectHairT.toString());
			//4
			//5
			rs=pstmt.executeQuery();
			
			HairTypeVO htVO=null;
			while(rs.next()) {
				htVO=new HairTypeVO(rs.getString("t_type"),rs.getString("t_category"),
								rs.getString("t_name"),rs.getString("t_code"),rs.getInt("price"));
				hairTypeList.add(htVO);
			}//end while
			
		}finally {
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}
		
		return hairTypeList;
	}//selectHairType

	public List<DesignerDateVO> selectDesigner() throws SQLException{
		
		List<DesignerDateVO> hairDesigner=new ArrayList<DesignerDateVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConn();
			
			StringBuilder selectHairD=new StringBuilder();
			selectHairD
			.append(" select e.empno empno,e.p_code p_code,e.e_name e_name,p.p_charge p_charge")
			.append(" from emp e")
			.append(" inner join position_charge p")
			.append(" on e.p_code=p.p_code")
			.append(" order by e.p_code");
			
			pstmt=con.prepareStatement(selectHairD.toString());
			
			rs=pstmt.executeQuery();
			
			DesignerDateVO ddVO=null;
			while(rs.next()) {
				ddVO=new DesignerDateVO(rs.getString("e_name"),null,null,
					null,null,rs.getString("p_code"),rs.getInt("p_charge"),rs.getInt("empno"));
			
				hairDesigner.add(ddVO);
			}//end while
			
		}finally {
			if(rs!=null) {rs.close();}//end if
			if(pstmt!=null) {pstmt.close();}//end if
			if(con!=null) {con.close();}//end if
		}
		
		return hairDesigner;
	}
}
