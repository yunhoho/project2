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
		jbtConfirm=new JButton("����");
		
		//Font
		Font font=new Font("���� ���", Font.BOLD, 18);
		jlbOld.setFont(font);
		jlbPass.setFont(font);
		jlbPassConfirm.setFont(font);
		
		
		//Bounds
		jlbOld.setBounds(210, 120, 150, 30);
		jlbPass.setBounds(210, 165, 150, 30);
		jlbPassConfirm.setBounds(210, 210, 150, 30);
		jpfOld.setBounds(390, 120, 200, 30);
		jpfPass.setBounds(390, 165, 200, 30);
		jpfPassConfirm.setBounds(390, 210, 200, 30);
		jbtConfirm.setBounds(350, 270, 120, 30);
		
		//add
		add(jlbOld);
		add(jlbPass);
		add(jlbPassConfirm);
		add(jpfOld);
		add(jpfPass);
		add(jpfPassConfirm);
		add(jbtConfirm);
		setLayout(null);
		setBounds(100,100,800,500);

		
	}//AdminPassword
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}//actionPerformed

	public static void main(String[] args) {
		new AdminPassword();
	}//m

}//c
