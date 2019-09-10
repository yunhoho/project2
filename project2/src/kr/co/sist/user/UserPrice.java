package kr.co.sist.user;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UserPrice extends JFrame{
	private JLabel jlCut, jlPerm, jlDyeing, jlClinic;
	private DefaultTableModel dtmCutInfo, dtmPermInfo, dtmPermSpecialInfo, dtmDyeInfo, dtmBleachingInfo, dtmClinicInfo;
	private JTable jtCutList, jtPermList, jtSpecialPermList, jtDyeingList, jtBleachingList, jtClinicList;
	    
	public UserPrice() {
		//1. Model 생성
		// - 가데이터 넣어보기
		String[][] rowCut = { { "기본컷", "15,000"}, {"디자이너","33,000"}};
		String[][] rowPerm = {{"숏펌","150,000"}, {"단발펌","220,000"}, {"미디움펌","250,000"}, {"롱펌","280,000"}};
		String[][] rowSpecialPerm = {{"숏펌","200,000"}, {"단발펌","270,000"}, {"미디움펌","320,000"}, {"롱펌","330,000"}};
		String[][] rowDyeing = {{"숏","110,000"}, {"단발","150,000"}, {"미디움","190,000"}, {"롱","240,000"}};
		String[][] rowBleching = {{"숏","160,000"}, {"단발","210,000"}, {"미디움","240,000"}, {"롱","290,000"}};
		String[][] rowClinic = {{"숏","150,000"}, {"단발","190,000"}, {"미디움","230,000"}, {"롱","270,000"}};
		// - 컬럼명 생성
		String[] cutColumnNames = {"컷", "가격"};
		String[] permColumnNames = {"일반펌", "가격"};
		String[] permSpecialColumnNames = {"스페셜펌", "가격"};
		String[] DeyingColumnNames = {"염색", "가격"};
		String[] BleachingColumnNames = {"탈색", "가격"};
		String[] clinicColumnNames = {"모발 & 두피", "가격"};
		
		
		dtmCutInfo = new DefaultTableModel(rowCut, cutColumnNames);
		dtmPermInfo = new DefaultTableModel(rowPerm, permColumnNames);
		dtmPermSpecialInfo = new DefaultTableModel(rowSpecialPerm, permSpecialColumnNames);
		dtmDyeInfo = new DefaultTableModel(rowDyeing, DeyingColumnNames);
		dtmBleachingInfo = new DefaultTableModel(rowBleching, BleachingColumnNames);
		dtmClinicInfo = new DefaultTableModel(rowClinic, clinicColumnNames);
		
		//2. View 생성하고, Model과 has a 관계 설정
		jtCutList = new JTable(dtmCutInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {//테이블을 직접 수정하지 못하게 막음
				return false;
			}
		};
		
		jtPermList = new JTable(dtmPermInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtSpecialPermList = new JTable(dtmPermSpecialInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtDyeingList = new JTable(dtmDyeInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtBleachingList = new JTable(dtmBleachingInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtClinicList = new JTable(dtmClinicInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//컬럼의 넓이 변경
		//컷
		jtCutList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtCutList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//펌
		jtPermList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtPermList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//스페셜펌
		jtSpecialPermList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtSpecialPermList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//염색
		jtDyeingList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtDyeingList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//탈색
		jtBleachingList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtBleachingList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//클리닉
		jtClinicList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtClinicList.getColumnModel().getColumn(1).setPreferredWidth(50);

		// 컬럼의 높이 변경
		jtCutList.setRowHeight(40);
		jtPermList.setRowHeight(40);
		jtSpecialPermList.setRowHeight(40);
		jtDyeingList.setRowHeight(40);
		jtBleachingList.setRowHeight(40);
		jtClinicList.setRowHeight(40);
		
		JScrollPane jspCut = new JScrollPane(jtCutList);
		JScrollPane jspPerm = new JScrollPane(jtPermList);
		JScrollPane jspSpecialPerm = new JScrollPane(jtSpecialPermList);
		JScrollPane jspDyeing = new JScrollPane(jtDyeingList);
		JScrollPane jspBleaching = new JScrollPane(jtBleachingList);
		JScrollPane jspClinic = new JScrollPane(jtClinicList);
		
		jspCut.setBounds(40, 65, 620, 100);
		jspPerm.setBounds(40, 215, 300, 100);
		jspSpecialPerm.setBounds(360, 215, 300, 100);
		jspDyeing.setBounds(40, 365, 300, 100);
		jspBleaching.setBounds(360, 365, 300, 100);
		jspClinic.setBounds(40, 515, 620, 100);
		
		//3. 배치
		add(jspCut);		
		add(jspPerm);		
		add(jspSpecialPerm);		
		add(jspDyeing);		
		add(jspBleaching);		
		add(jspClinic);		
		
		jlCut = new JLabel("컷( 직급별 차등요금 : 실장 +30,000원 / 원장 +60,000원 )");
		jlPerm = new JLabel("펌( 직급별 차등요금 : 실장 +30,000원 / 원장 +60,000원 )");
		jlDyeing = new JLabel("염색&탈색( 직급별 차등요금 : 실장 +30,000원 / 원장 +60,000원 )");
		jlClinic = new JLabel("클리닉( 직급별 차등요금 : 실장 +30,000원 / 원장 +60,000원 )");
		
		setLayout(null);
		jlCut.setBounds(50, 20, 700, 50);
		jlPerm.setBounds(50, 170, 700, 50);
		jlDyeing.setBounds(50, 320, 700, 50);
		jlClinic.setBounds(50, 470, 700, 50);
		
		add(jlCut);
		add(jlPerm);
		add(jlDyeing);
		add(jlClinic);
		
		setBounds(10, 10, 700, 700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UserPrice
	
	
	
	public JTable getJtCutList() {
		return jtCutList;
	}



	public JTable getJtPermList() {
		return jtPermList;
	}



	public JTable getJtSpecialPermList() {
		return jtSpecialPermList;
	}



	public JTable getJtDyeingList() {
		return jtDyeingList;
	}



	public JTable getJtBleachingList() {
		return jtBleachingList;
	}



	public JTable getJtClinicList() {
		return jtClinicList;
	}



	public static void main(String[] args) {
		new UserPrice();
	}//main

}//class
