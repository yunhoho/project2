package kr.co.sist.user;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Tab extends JFrame {
	
	private Booking bk;
	private BookSearch bks;
	
	public Tab() {
		JTabbedPane jtp=new JTabbedPane();
		
		bk=new Booking();
		bks=new BookSearch();
		
		jtp.addTab("소개", new JLabel());
		jtp.addTab("스타일리스트 소개", new JLabel());
		jtp.addTab("가격", new JLabel());
		jtp.addTab("예약", bk);
		jtp.addTab("시줄정보", new JLabel());
		jtp.addTab("예약조회", bks);
		
		add("Center",jtp);

		
//		JScrollPane jscp=new JScrollPane
//				(jtp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		setContentPane(jscp);
		
		setBounds(10, 10, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Tab();
	}
}

