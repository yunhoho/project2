package kr.co.sist.server.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerData extends JPanel implements ActionListener{
	private DefaultTableModel dtmClientList;
	private JTable jtClientList;
	private JTextField jtfClientName;
	private JLabel jlbClient;
	private JButton jbtSearch;
	private JTabbedPane jtp;

	public CustomerData() {
		String[] clientColumnNames= {"고객명","전화번호","성별","마지막 시술일자"};
		dtmClientList=new DefaultTableModel(clientColumnNames,0);

		jlbClient=new JLabel("고객명");
		
		//컬럼에 입력된 데이터형을 그대로 보여주기
		jtClientList=new JTable(dtmClientList) {

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}//getColumnClass

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
			
		};//jt
		
		jtClientList.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtClientList.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtClientList.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtClientList.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtClientList.setRowHeight(20);
		
		jbtSearch=new JButton("검색");
		jtfClientName=new JTextField(15);
		/////////////////고객 데이터 리스트//////////////
		
		JScrollPane jspClientList=new JScrollPane(jtClientList);
		
		JPanel jpClientData=new JPanel();
		jpClientData.add(jlbClient);
		jpClientData.add(jtfClientName);
		jpClientData.add(jbtSearch);
//		JPanel jpClientData=new JPanel();
		
		jpClientData.setBounds(0, 10, 800, 35);
		jspClientList.setBounds(0,50, 790, 385);
		add(jpClientData);
		add(jspClientList);
//		jpClientData.add("North",jpClientDataNorth);
//		jpClientData.add("Center",jspClientList);
//		
//		jtp=new JTabbedPane();
//		jtp.addTab("고객Data",jpClientData );
//		add("Center",);
//		add(jpClientData);
		
		setLayout(null);
		setBounds(100,100,800,500);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//ClientData
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed
//	public static void main(String[] args) {
//		new CustomerData();
//	}//m


}//c
