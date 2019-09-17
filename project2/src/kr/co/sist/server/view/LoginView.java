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
		super("헤어 살롱 로그인");
		
		jlId=new JLabel("아이디");
		jlPass=new JLabel("비밀번호");
		jlTitle=new JLabel("헤어살롱 관리자 프로그램");
		jtfId=new JTextField(10);
		jtfId.setText("admin");
		jtfPass=new JPasswordField(10);
		jbLogin=new JButton("로그인");
		jbClose=new JButton("닫기");
		
		
		
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
