package kr.co.sist.server.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.server.controller.CustomerDataEvt;

public class CustomerData extends JPanel {
	private DefaultTableModel dtmCustomerList;
	private JTable jtCustomerList;
	private JTextField jtfCustomerName;
	private JLabel jlbCustomer;
	private JButton jbtSearch;


	public CustomerData() {
		String[] customerColumnNames= {"����","��ȭ��ȣ","����","������ �ü�����"};
		dtmCustomerList=new DefaultTableModel(customerColumnNames,0);

		jlbCustomer=new JLabel("����");
		
		//�÷��� �Էµ� ���������� �״�� �����ֱ�
		jtCustomerList=new JTable(dtmCustomerList) {

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}//getColumnClass

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}//isCellEditable
			
		};//jt
		
		jtCustomerList.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtCustomerList.getColumnModel().getColumn(1).setPreferredWidth(120);
		jtCustomerList.getColumnModel().getColumn(2).setPreferredWidth(50);
		jtCustomerList.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtCustomerList.setRowHeight(20);
		
		jbtSearch=new JButton("�˻�");
		jtfCustomerName=new JTextField(15);
		/////////////////�� ������ ����Ʈ//////////////
		
		JScrollPane jspCustomerList=new JScrollPane(jtCustomerList);
		
		JPanel jpCustomerData=new JPanel();
		jpCustomerData.add(jlbCustomer);
		jpCustomerData.add(jtfCustomerName);
		jpCustomerData.add(jbtSearch);

		CustomerDataEvt cdEVT=new CustomerDataEvt(this);
		dtmCustomerList=cdEVT.setCustomerList(null);
		jtfCustomerName.addActionListener(cdEVT);
		
		
		jpCustomerData.setBounds(0, 10, 800, 35);
		jspCustomerList.setBounds(0,50, 790, 385);
		add(jpCustomerData);
		add(jspCustomerList);

		setLayout(null);
		setBounds(100,100,800,500);

		
	}//CustomerData


	public DefaultTableModel getDtmCustomerList() {
		return dtmCustomerList;
	}


	public JTable getJtCustomerList() {
		return jtCustomerList;
	}


	public JTextField getJtfCustomerName() {
		return jtfCustomerName;
	}


	public JLabel getJlbCustomer() {
		return jlbCustomer;
	}


	public JButton getJbtSearch() {
		return jbtSearch;
	}
	
	

	



}//c
