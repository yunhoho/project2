package kr.co.sist.server.view;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class AdminMainView extends JFrame{

	
	BookingView bv;
	
	public AdminMainView() {
		bv=new BookingView();
		
		JTabbedPane jtp=new JTabbedPane();
		jtp.addTab("예약현황", bv);
		

		
		add("Center", jtp);
		
		setBounds(100, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//AdminMainView
	
		
		

	public static void main(String[] args) {
		new AdminMainView();
	}//main

}//class
