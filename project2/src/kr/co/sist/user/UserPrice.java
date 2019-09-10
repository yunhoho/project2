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
		//1. Model ����
		// - �������� �־��
		String[][] rowCut = { { "�⺻��", "15,000"}, {"�����̳�","33,000"}};
		String[][] rowPerm = {{"����","150,000"}, {"�ܹ���","220,000"}, {"�̵����","250,000"}, {"����","280,000"}};
		String[][] rowSpecialPerm = {{"����","200,000"}, {"�ܹ���","270,000"}, {"�̵����","320,000"}, {"����","330,000"}};
		String[][] rowDyeing = {{"��","110,000"}, {"�ܹ�","150,000"}, {"�̵��","190,000"}, {"��","240,000"}};
		String[][] rowBleching = {{"��","160,000"}, {"�ܹ�","210,000"}, {"�̵��","240,000"}, {"��","290,000"}};
		String[][] rowClinic = {{"��","150,000"}, {"�ܹ�","190,000"}, {"�̵��","230,000"}, {"��","270,000"}};
		// - �÷��� ����
		String[] cutColumnNames = {"��", "����"};
		String[] permColumnNames = {"�Ϲ���", "����"};
		String[] permSpecialColumnNames = {"�������", "����"};
		String[] DeyingColumnNames = {"����", "����"};
		String[] BleachingColumnNames = {"Ż��", "����"};
		String[] clinicColumnNames = {"��� & ����", "����"};
		
		
		dtmCutInfo = new DefaultTableModel(rowCut, cutColumnNames);
		dtmPermInfo = new DefaultTableModel(rowPerm, permColumnNames);
		dtmPermSpecialInfo = new DefaultTableModel(rowSpecialPerm, permSpecialColumnNames);
		dtmDyeInfo = new DefaultTableModel(rowDyeing, DeyingColumnNames);
		dtmBleachingInfo = new DefaultTableModel(rowBleching, BleachingColumnNames);
		dtmClinicInfo = new DefaultTableModel(rowClinic, clinicColumnNames);
		
		//2. View �����ϰ�, Model�� has a ���� ����
		jtCutList = new JTable(dtmCutInfo) {
			@Override
			public boolean isCellEditable(int row, int column) {//���̺��� ���� �������� ���ϰ� ����
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
		
		//�÷��� ���� ����
		//��
		jtCutList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtCutList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//��
		jtPermList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtPermList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//�������
		jtSpecialPermList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtSpecialPermList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//����
		jtDyeingList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtDyeingList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//Ż��
		jtBleachingList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtBleachingList.getColumnModel().getColumn(1).setPreferredWidth(50);
		//Ŭ����
		jtClinicList.getColumnModel().getColumn(0).setPreferredWidth(50); 
		jtClinicList.getColumnModel().getColumn(1).setPreferredWidth(50);

		// �÷��� ���� ����
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
		
		//3. ��ġ
		add(jspCut);		
		add(jspPerm);		
		add(jspSpecialPerm);		
		add(jspDyeing);		
		add(jspBleaching);		
		add(jspClinic);		
		
		jlCut = new JLabel("��( ���޺� ������ : ���� +30,000�� / ���� +60,000�� )");
		jlPerm = new JLabel("��( ���޺� ������ : ���� +30,000�� / ���� +60,000�� )");
		jlDyeing = new JLabel("����&Ż��( ���޺� ������ : ���� +30,000�� / ���� +60,000�� )");
		jlClinic = new JLabel("Ŭ����( ���޺� ������ : ���� +30,000�� / ���� +60,000�� )");
		
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
