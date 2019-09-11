package kr.co.sist.server.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
//
@SuppressWarnings("serial")
public class AdminMainView extends JFrame{


	private CustomerData cd;
	private AdminPassword ap;
	private BookingView bv;
	private EmpMainView emv;
	
	public AdminMainView() {
		JTabbedPane jtp=new JTabbedPane();
		
		cd=new CustomerData();
		ap=new AdminPassword();
		bv=new BookingView();
		emv=new EmpMainView();
		
		jtp.addTab("예약현황", bv);
		jtp.addTab("고객데이터", cd);
		jtp.addTab("정산", new JLabel());
		jtp.addTab("직원관리", emv);
		jtp.addTab("메뉴관리", new JLabel());
		jtp.addTab("관리자설정", ap);
		
		add("Center",jtp);

		

		
		setBounds(10, 10, 800, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
		
		

	public static void main(String[] args) {
		new AdminMainView();
	}//main

}//class
