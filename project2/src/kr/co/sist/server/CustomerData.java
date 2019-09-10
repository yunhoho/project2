package kr.co.sist.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerData extends JDialog implements ActionListener{
	private DefaultTableModel dtmClientList;
	private JTable jtClientList;
	private JTextField jtfClientName;
	private JComboBox<String> jcClient;
	private DefaultComboBoxModel<String> dcbmClient;
	private JButton jbtSearch;
	private JTabbedPane jtp;

	public CustomerData() {
		String[] clientColumnNames= {"고객명","전화번호","성별","생년월일","마지막 시술일자"};
		dtmClientList=new DefaultTableModel(clientColumnNames,0);

		String[]data= {"고객명", "전화번호"};
		dcbmClient=new DefaultComboBoxModel<String>(data);
		
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
		jtClientList.getColumnModel().getColumn(3).setPreferredWidth(80);
		jtClientList.getColumnModel().getColumn(4).setPreferredWidth(120);
		jtClientList.setRowHeight(20);
		
		jbtSearch=new JButton("검색");
		jtfClientName=new JTextField(15);
		jcClient=new JComboBox<String>(dcbmClient);
		/////////////////고객 데이터 리스트//////////////
		
		JScrollPane jspClientList=new JScrollPane(jtClientList);
		
		JPanel jpClientDataNorth=new JPanel();
		jpClientDataNorth.add(jcClient);
		jpClientDataNorth.add(jtfClientName);
		jpClientDataNorth.add(jbtSearch);
		JPanel jpClientData=new JPanel();
		jpClientData.setLayout(new BorderLayout());
		
		
		jpClientData.add("Center",jspClientList);
		jpClientData.add("North",jpClientDataNorth);
		
		jtp=new JTabbedPane();
		jtp.addTab("고객Data",jpClientData );
		add("Center",jtp);
		
		
		setBounds(100,100,800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//ClientData
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed
	public static void main(String[] args) {
		new CustomerData();
	}//m


}//c
