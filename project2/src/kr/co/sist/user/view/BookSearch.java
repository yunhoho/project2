package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookSearch extends JPanel{
	
	private JLabel jlblName,jlblPhone,jlblPass;
	
	private JTextField jtfName,jtfPhone,jtfPass;
	
	private JButton jbtnSearch;
	
	public BookSearch() {
		
//		JLabel
		jlblName=new JLabel("�̸�");
		jlblPhone=new JLabel("��ȭ��ȣ");
		jlblPass=new JLabel("��й�ȣ");
		
		jlblName.setHorizontalAlignment(JLabel.CENTER);
		jlblPhone.setHorizontalAlignment(JLabel.CENTER);
		jlblPass.setHorizontalAlignment(JLabel.CENTER);
		
//		JTextField
		jtfName=new JTextField();
		jtfPhone=new JTextField();
		jtfPass=new JTextField();
		
//		JButton
		jbtnSearch=new JButton("��ȸ");
		
		jlblName.setBounds(getX()+200, getY()+100, 60, 20);
		jtfName.setBounds(getX()+280, getY()+100, 225, 20);
		jlblPhone.setBounds(getX()+200, getY()+140, 60, 20);
		jtfPhone.setBounds(getX()+280, getY()+140, 225, 20);
		jlblPass.setBounds(getX()+200, getY()+180, 60, 20);
		jtfPass.setBounds(getX()+280, getY()+180, 225, 20);
		jbtnSearch.setBounds(getX()+445, getY()+220, 60, 20);
		
		add(jlblName);
		add(jtfName);
		add(jlblPhone);
		add(jtfPhone);
		add(jlblPass);
		add(jtfPass);
		add(jbtnSearch);
		
		setLayout(null);
//		setBounds(100, 100, 525, 500);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//BookSearch
	
//	public static void main(String[] args) {
//		new BookSearch();
//	}//main

}
