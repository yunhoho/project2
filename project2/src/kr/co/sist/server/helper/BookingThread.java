package kr.co.sist.server.helper;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.server.dao.AdminDAOHyj;
import kr.co.sist.server.vo.BookingVO;

public class BookingThread extends Thread{

	private JTable jtBooking;
	private DefaultTableModel dtm;
	
	public BookingThread(JTable jtBooking, DefaultTableModel dtm) {
		this.jtBooking=jtBooking;
		this.dtm=dtm;
	}
	
	public void run() {
		AdminDAOHyj aDAOH=AdminDAOHyj.getInstance();
		
		List<BookingVO> list=null;
		Object[] rowData=null;
		BookingVO bVO=null;
		
		Boolean flag=false;
		
		try {
			
		while(true) {
				list=aDAOH.selectBooking();
				if(!flag) {
					if(list.isEmpty()) {
						JOptionPane.showMessageDialog(jtBooking, "예약 내역이 존재하지 않습니다.");
					}//end if
				}//end if
				dtm.setRowCount(0);
				
				for(int i=0; i<list.size(); i++) {
					bVO=list.get(i);
					rowData=new Object[6];
					rowData[0]=bVO.getBookingTime();
					rowData[1]=bVO.getClientName();
					rowData[2]=bVO.getPhoneNum();
					rowData[3]=bVO.getStaffName();
					rowData[4]=bVO.getPrice();
					rowData[5]=bVO.getPaymentFlag();
					
					dtm.addRow(rowData);
					
				}//end for
				
				try {
					Thread.sleep(1000*30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//end catch
				
		}//end while
		
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}//end catch
	}//run
	
}//class
