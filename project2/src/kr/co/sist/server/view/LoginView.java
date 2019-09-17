package kr.co.sist.server.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.server.controller.LoginEvt;



@SuppressWarnings("serial")
public class LoginView extends JFrame {
	private JLabel jlId, jlPass, jlTitle;
	private JTextField jtfId;
	private JPasswordField jtfPass;
	private JButton jbLogin, jbClose;
	
	public LoginView() {
		super("��� ��� �α���");
		
		jlId=new JLabel("���̵�");
		jlPass=new JLabel("��й�ȣ");
		jlTitle=new JLabel("����� ������ ���α׷�");
		jtfId=new JTextField(10);
		jtfId.setText("admin");
		jtfPass=new JPasswordField(10);
		jbLogin=new JButton("�α���");
		jbClose=new JButton("�ݱ�");
		
		
		
		JPanel jp=new JPanel();
		jp.add(jlId);
		jp.add(jtfId);
		jp.add(jlPass);
		jp.add(jtfPass);
		
		JPanel jpBtn=new JPanel();
		jpBtn.add(jbLogin);
		jpBtn.add(jbClose);
		
		add("North", jlTitle);
		add("Center", jp);
		add("South", jpBtn);
		
		LoginEvt le=new LoginEvt(this);
		
		jtfId.addActionListener(le);
		jtfPass.addActionListener(le);	
		jbLogin.addActionListener(le);
		jbClose.addActionListener(le);
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//loginView
	
	
	
	public JTextField getJtfId() {
		return jtfId;
	}



	public JPasswordField getJtfPass() {
		return jtfPass;
	}



	public JButton getJbLogin() {
		return jbLogin;
	}



	public JButton getJbClose() {
		return jbClose;
	}



//	public static void main(String [] args) {
//		new LoginView();
//	}
	
}//class
