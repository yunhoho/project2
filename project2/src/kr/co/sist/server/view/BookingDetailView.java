package kr.co.sist.server.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BookingDetailView extends JFrame {
	
	
	private DefaultTableModel dtmTreatmentList;
	private JTable jtTreatmentTable;
	private JLabel jlOrderList, jlExtraMsg, jlTotalPrice;
	private JButton jbtAddStyle, jbtUpdateBooking, jbtCloseDetail;
	private JTextArea jtaExtraMsg;
	private JTextField jtfPrice;
	
	public BookingDetailView() {
		super("예약 상세 내역");
		
		String[] treatmentColumn= {"시술명","가격"};
		dtmTreatmentList=new DefaultTableModel(treatmentColumn,0);
		jtTreatmentTable=new JTable(dtmTreatmentList);
		JScrollPane jsp=new JScrollPane(jtTreatmentTable);
		jlOrderList=new JLabel("시술 사항");
		jlExtraMsg=new JLabel("비고");
		jlTotalPrice=new JLabel("총 결제 금액");
		jtaExtraMsg=new JTextArea();
		jtfPrice=new JTextField();
		
		jbtAddStyle=new JButton("추가");
		jbtUpdateBooking=new JButton("변경");
		jbtCloseDetail=new JButton("닫기");
		
		
		
		add(jlOrderList);
		add(jlExtraMsg);
		add(jsp);
		add(jtaExtraMsg);
		add(jlTotalPrice);
		add(jtfPrice);
		add(jbtAddStyle);
		add(jbtUpdateBooking);
		add(jbtCloseDetail);
		
		jlOrderList.setBounds(25, 50, 80,20);
		jsp.setBounds(25, 70, 350,150);
		jbtAddStyle.setBounds(290, 230, 80,30);
		jlExtraMsg.setBounds(25, 260, 80,20);
		jtaExtraMsg.setBounds(25, 280, 350,150);
		jlTotalPrice.setBounds(50, 450, 80,20);
		jtfPrice.setBounds(200, 450, 150,20);
		jbtUpdateBooking.setBounds(80, 500, 80,30);
		jbtCloseDetail.setBounds(240, 500, 80,30);
		
		
		
		
		
		
		setLayout(null);
		setBounds(100, 100, 415, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BookingDetailView();
	}//main
}//class
