package kr.co.sist.server.view;


import javax.swing.DefaultComboBoxModel;
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

import kr.co.sist.server.controller.BookingServerEvt;
import kr.co.sist.server.helper.MonthlyMaxDay;
import kr.co.sist.server.vo.DateVO;

@SuppressWarnings("serial")
public class BookingView extends JPanel{

	private DefaultTableModel dtmBookingList;
	private JTable jtBookingList;
	private JComboBox<String> jcbsrch, jcbYear1, jcbMonth1, jcbDay1,
			jcbYear2,jcbMonth2, jcbDay2;
	private DefaultComboBoxModel<String> dcbmSrch, dcbmYear1,dcbmYear2,dcbmMonth1,dcbmMonth2,dcbmDay1,dcbmDay2;
	private JTextField jtfsrchInput;
	private JButton jbtsrch;
	private JLabel jlsrchPeriod, jlDash;
	private JPopupMenu jpm;
	private JMenuItem bookingDetail, paymentFlag, deleteBooking;
	
	
	
	
	
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
		paymentFlag=new JMenuItem("결제완료변경");
		deleteBooking=new JMenuItem("예약 삭제");
		
		jpm.add(bookingDetail);
		jpm.add(paymentFlag);
		jpm.add(deleteBooking);
		
		jtBookingList.setComponentPopupMenu(jpm);
		
		dcbmSrch=new DefaultComboBoxModel<String>();
		dcbmSrch.addElement("고객명");
		dcbmSrch.addElement("디자이너명");
		jcbsrch=new JComboBox<String>(dcbmSrch);
//		jcbsrch.addItem("고객명");
//		jcbsrch.addItem("디자이너명");
		
		dcbmYear1=new DefaultComboBoxModel<String>();
		dcbmYear2=new DefaultComboBoxModel<String>();
		dcbmMonth1=new DefaultComboBoxModel<String>();
		dcbmMonth2=new DefaultComboBoxModel<String>();
		
		
		
		for(int i=2019; i<2022; i++) {
			String year=Integer.toString(i);
			dcbmYear1.addElement(year);
			dcbmYear2.addElement(year);
		}
		
		for(int i = 1; i<13; i++) {
			String month=Integer.toString(i);
			dcbmMonth1.addElement(month);
			dcbmMonth2.addElement(month);
		}
//		dcbmDay1.addElement("1일");
//		dcbmDay2.addElement("1일");
		
		BookingServerEvt bse=new BookingServerEvt(this);
		
		jcbYear1=new JComboBox<String>(dcbmYear1);
		jcbMonth1=new JComboBox<String>(dcbmMonth1);
		jcbYear2=new JComboBox<String>(dcbmYear2);
		jcbMonth2=new JComboBox<String>(dcbmMonth2);
		try {
		jcbDay1=new JComboBox<String>(dcbmDay1);
		jcbDay2=new JComboBox<String>(dcbmDay2);
		}catch(NullPointerException e){
			dcbmDay1=new DefaultComboBoxModel<String>();
			jcbDay1=new JComboBox<String>(dcbmDay1);
			dcbmDay2=new DefaultComboBoxModel<String>();
			jcbDay2=new JComboBox<String>(dcbmDay2);
		}
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
		
		
		jbtsrch.addActionListener(bse);
		jcbMonth1.addActionListener(bse);
		
		
		
	}//BookingView


	public DefaultTableModel getDtmBookingList() {
		return dtmBookingList;
	}


	public JTable getJtBookingList() {
		return jtBookingList;
	}


	public JComboBox<String> getJcbsrch() {
		return jcbsrch;
	}


	public JComboBox<String> getJcbYear1() {
		return jcbYear1;
	}


	public JComboBox<String> getJcbMonth1() {
		return jcbMonth1;
	}


	public JComboBox<String> getJcbDay1() {
		return jcbDay1;
	}


	public JComboBox<String> getJcbYear2() {
		return jcbYear2;
	}


	public JComboBox<String> getJcbMonth2() {
		return jcbMonth2;
	}


	public JComboBox<String> getJcbDay2() {
		return jcbDay2;
	}


	public JTextField getJtfsrchInput() {
		return jtfsrchInput;
	}


	public JButton getJbtsrch() {
		return jbtsrch;
	}


	public JPopupMenu getJpm() {
		return jpm;
	}


	public JMenuItem getBookingDetail() {
		return bookingDetail;
	}


	public JMenuItem getPaymentFlag() {
		return paymentFlag;
	}


	public JMenuItem getDeleteBooking() {
		return deleteBooking;
	}


	public void setDcbmDay1(DefaultComboBoxModel<String> dcbmDay1) {
		this.dcbmDay1 = dcbmDay1;
	}







	
	


}//class
