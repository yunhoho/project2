package kr.co.sist.server.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Tab extends JFrame {
//	
	private CustomerData cd;
	private AdminPassword ap;
	
	public Tab() {
		JTabbedPane jtp=new JTabbedPane();
		
		cd=new CustomerData();
		ap=new AdminPassword();
		
		jtp.addTab("������Ȳ", new JLabel());
		jtp.addTab("��������", cd);
		jtp.addTab("����", new JLabel());
		jtp.addTab("��������", new JLabel());
		jtp.addTab("�޴�����", new JLabel());
		jtp.addTab("�����ڼ���", ap);
		
		add("Center",jtp);

		
//		JScrollPane jscp=new JScrollPane
//				(jtp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		setContentPane(jscp);
		
		setBounds(10, 10, 800, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Tab();
	}
}

