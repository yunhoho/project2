package kr.co.sist.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultComboBoxModel;

import kr.co.sist.server.helper.BookingThread;
import kr.co.sist.server.helper.MonthlyMaxDay;
import kr.co.sist.server.view.AdminMainView;
import kr.co.sist.server.view.BookingView;
import kr.co.sist.server.vo.DateVO;

public class BookingServerEvt extends MouseAdapter implements ActionListener{

	private BookingThread bt;
	private BookingView bv;
	private MonthlyMaxDay mmd;
	public DateVO dVO;
	
	public BookingServerEvt(BookingView bv) {
		this.bv=bv;
		bt=new BookingThread(bv.getJtBookingList(), bv.getDtmBookingList());
		bt.start();
	}//BookingServerEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==bv.getJcbMonth1()) {
			String year=(String)bv.getJcbYear1().getSelectedItem();
			String month=(String)bv.getJcbMonth1().getSelectedItem();
			DefaultComboBoxModel<String> dcbmEvt=new DefaultComboBoxModel<String>();
			dcbmEvt.addElement(month);
			bv.setDcbmDay1(dcbmEvt);
			
			System.out.println(year+" / "+month);
			new BookingView();
			new AdminMainView();
			
		}
		
		
	}//actionPerformed


}//BookingServerEvt
