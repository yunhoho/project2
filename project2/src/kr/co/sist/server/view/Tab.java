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
		
		jtp.addTab("예약현황", new JLabel());
		jtp.addTab("고객데이터", cd);
		jtp.addTab("정산", new JLabel());
		jtp.addTab("직원관리", new JLabel());
		jtp.addTab("메뉴관리", new JLabel());
		jtp.addTab("관리자설정", ap);
		
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

