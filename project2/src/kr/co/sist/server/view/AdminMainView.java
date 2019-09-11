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
		
		jtp.addTab("������Ȳ", bv);
		jtp.addTab("��������", cd);
		jtp.addTab("����", new JLabel());
		jtp.addTab("��������", emv);
		jtp.addTab("�޴�����", new JLabel());
		jtp.addTab("�����ڼ���", ap);
		
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
