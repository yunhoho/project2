package kr.co.sist.server.view;

import java.awt.BorderLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BookingView extends JPanel{

	private DefaultTableModel dtmBookingList;
	private JTable jtBookingList;
	private JComboBox<String> jcbsrch, jcbYear1, jcbMonth1, jcbDay1,
			jcbYear2,jcbMonth2, jcbDay2;
	private ComboBoxModel<String> cbm;
	private JTextField jtfsrchInput;
	private JButton jbtsrch;
	private JLabel jlsrchPeriod, jlDash;
	private JPopupMenu jpm;
	private JMenuItem bookingDetail, changeBooking, paymentFlag, deleteBooking;
	
	private JPanel jpBookingList;
	
	public BookingView() {
		jlsrchPeriod=new JLabel("검색 기간");
		jlDash=new JLabel("-");
		
		String[] bookingColumn= {"예약일자","고객명","전화번호","디자이너 이름","결제금액","결제완료"};
		dtmBookingList=new DefaultTableModel(bookingColumn,0);
		jtBookingList=new JTable(dtmBookingList) {
				@Override
				public Class<?> getColumnClass(int column) {
					return getValueAt(0, column).getClass();
				}

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
		};
		jtBookingList.setRowHeight(25);
		
		jpm=new JPopupMenu();
		
		bookingDetail=new JMenuItem("시술상세정보");
		changeBooking=new JMenuItem("시술사항변경");
		paymentFlag=new JMenuItem("결제완료변경");
		deleteBooking=new JMenuItem("예약 삭제");
		
		jpm.add(bookingDetail);
		jpm.add(changeBooking);
		jpm.add(paymentFlag);
		jpm.add(deleteBooking);
		
		jtBookingList.setComponentPopupMenu(jpm);
		
		jcbsrch=new JComboBox<String>();
		jcbsrch.addItem("고객명");
		jcbsrch.addItem("디자이너명");
		
		jcbYear1=new JComboBox<String>();
		jcbMonth1=new JComboBox<String>();
		jcbDay1=new JComboBox<String>();
		jcbYear2=new JComboBox<String>();
		jcbMonth2=new JComboBox<String>();
		jcbDay2=new JComboBox<String>();
		
		jcbYear1.addItem("2019");
		jcbYear2.addItem("2019");
		jcbMonth1.addItem("1월");
		jcbMonth2.addItem("1월");
		jcbDay1.addItem("1일");
		jcbDay2.addItem("1일");
		
		
		
		jbtsrch=new JButton("검색");
		
		jtfsrchInput=new JTextField(15);
		
		//////////Jpanel//////
		JScrollPane jspbookingList=new JScrollPane(jtBookingList);

		
		
		
		JPanel jpBookingNorth=new JPanel();
		jpBookingNorth.add(jcbsrch);
		jpBookingNorth.add(jtfsrchInput);
		jpBookingNorth.add(jbtsrch);
		
		
		JPanel jpBookingDate=new JPanel();
		jpBookingDate.add(jlsrchPeriod);
		jpBookingDate.add(jcbYear1);
		jpBookingDate.add(jcbMonth1);
		jpBookingDate.add(jcbDay1);
		jpBookingDate.add(jlDash);
		jpBookingDate.add(jcbYear2);
		jpBookingDate.add(jcbMonth2);
		jpBookingDate.add(jcbDay2);
		
		
		jpBookingNorth.setBounds(0, 10, 800, 35);
		jpBookingDate.setBounds(0, 45, 800, 35);
		jspbookingList.setBounds(0,85, 790, 350);
		
		add(jpBookingNorth);
		add(jpBookingDate);
		add(jspbookingList);
		

		
		setLayout(null);
		setBounds(100,100,800,500);
		
	}//BookingView


	
	


}//class
