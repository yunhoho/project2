package kr.co.sist.server.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AdminPassword extends JPanel implements ActionListener {
	private JPasswordField jpfPass,jpfPassConfirm,jpfOld;
	private JButton jbtConfirm;
	private JLabel jlbOld, jlbPass,jlbPassConfirm;
	
	public AdminPassword() {
		//jlabel, jpasswordField
		jlbOld=new JLabel("���� ��й�ȣ");
		jpfOld=new JPasswordField(20);
		jlbPass=new JLabel("�� ��й�ȣ");
		jpfPass=new JPasswordField(20);
		jlbPassConfirm=new JLabel("�� ��й�ȣ Ȯ��");
		jpfPassConfirm=new JPasswordField(20);
		//jbutton
		jbtConfirm=new JButton("Ȯ��");
		
		//Font
		Font font=new Font("���� ���", Font.BOLD, 18);
		jlbOld.setFont(font);
		jlbPass.setFont(font);
		jlbPassConfirm.setFont(font);
		
		
		//Bounds
		jlbOld.setBounds(220, 150, 150, 30);
		jlbPass.setBounds(220, 195, 150, 30);
		jlbPassConfirm.setBounds(220, 240, 150, 30);
		jpfOld.setBounds(400, 150, 200, 30);
		jpfPass.setBounds(400, 195, 200, 30);
		jpfPassConfirm.setBounds(400, 240, 200, 30);
		
		//add
		add(jlbOld);
		add(jlbPass);
		add(jlbPassConfirm);
		add(jpfOld);
		add(jpfPass);
		add(jpfPassConfirm);
		
		setLayout(null);
		setBounds(100,100,800,500);
//		setVisible(true);
//		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
	}//AdminPassword
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}//actionPerformed

	public static void main(String[] args) {
		new AdminPassword();
	}//m

}//c
