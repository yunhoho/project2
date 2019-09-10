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
		
		jtp.addTab("�Ұ�", new JLabel());
		jtp.addTab("��Ÿ�ϸ���Ʈ �Ұ�", new JLabel());
		jtp.addTab("����", new JLabel());
		jtp.addTab("����", bk);
		jtp.addTab("��������", new JLabel());
		jtp.addTab("������ȸ", bks);
		
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

