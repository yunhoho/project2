package kr.co.sist.server.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpMainView extends JPanel {
	private DefaultTableModel dtmEmpList;
	private JTable jtEmpList;
	private JButton jbtAddForm, jbtUpdateForm, jbtDelete;
//	private JTabbedPane jtp;
	
	public EmpMainView(/*String adminName*/) {
//		super("HairSalon - 관리자화면 [" + adminName + "]님");
	
		String[] salonColumnNames = {"이미지", "이름", "전화번호", "주소", "직급", "입사일"};
		dtmEmpList = new DefaultTableModel(salonColumnNames, 0);		
		
		jtEmpList=new JTable(dtmEmpList) {
			
			@Override
			public Class<?> getColumnClass(int column){
				return getValueAt(0, column).getClass();
			}
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
						
		};
		
		
		//테이블의 넓이 변경
		jtEmpList.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtEmpList.getColumnModel().getColumn(1).setPreferredWidth(10);
		jtEmpList.getColumnModel().getColumn(2).setPreferredWidth(40);
		jtEmpList.getColumnModel().getColumn(3).setPreferredWidth(70);
		jtEmpList.getColumnModel().getColumn(4).setPreferredWidth(10);
		jtEmpList.getColumnModel().getColumn(5).setPreferredWidth(40);
		
		//테이블의 높이 변경
		jtEmpList.setRowHeight(20);
		
		jbtAddForm = new JButton("직원정보추가");
		jbtUpdateForm = new JButton("직원정보수정");
		jbtDelete=new JButton("직원정보삭제");
		
//		JPanel jpEmp = new JPanel();
//		jpEmp.setLayout(new BorderLayout());
		
		JScrollPane jspEmpList = new JScrollPane(jtEmpList);
		
		JPanel jpSalonNorth = new JPanel();
		jpSalonNorth.add(jbtAddForm);
		jpSalonNorth.add(jbtUpdateForm);
		jpSalonNorth.add(jbtDelete);
		
//		jpEmp.add("Center", jspEmpList);
//		jpEmp.add("North", jpSalonNorth);
		
		
		
//		jtp = new JTabbedPane();
//		jtp.addTab("직원관리", jpEmp);
//		
//		add("Center", jtp);
		
		
//		jbtAddForm.addActionListener();
		
		
		jpSalonNorth.setBounds(0, 5, 800, 35);
		jspEmpList.setBounds(0, 50, 790, 385);
		add(jpSalonNorth);
		add(jspEmpList);
		
		setLayout(null);
		setBounds(100, 100, 800, 500);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}//EmpMain

	public DefaultTableModel getDtmEmpList() {
		return dtmEmpList;
	}

	public JTable getJtEmpList() {
		return jtEmpList;
	}

	public JButton getJbtAddForm() {
		return jbtAddForm;
	}

	public JButton getJbtUpdateForm() {
		return jbtUpdateForm;
	}

	public JButton getJbtDelete() {
		return jbtDelete;
	}


}//class
