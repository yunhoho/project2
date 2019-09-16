package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.BookingDAO;
import kr.co.sist.user.view.UserPrice;
import kr.co.sist.user.vo.HairTypeVO;

public class UsePriceEvt implements ActionListener {
	
	private UserPrice up;
	
	
	public UsePriceEvt(UserPrice up) {
		this.up=up;
		setCutList();
		setPermList();
		setSpecialPermList();
		setDyeList();
		setBleachList();
		setClinicList();
	}//UsePriceEvt
	
	public void setCutList() {
		DefaultTableModel dtm = up.getDtmCutInfo();
		dtm.setRowCount(0);//JTable�� ���ڵ� �ʱ�ȭ
		
		Object[] rowData = null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		BookingDAO bDAO = BookingDAO.getInstance();
		try {
			List<HairTypeVO> list = bDAO.selectCutHairType();
			if(list.isEmpty()) {//hairType����Ʈ�� �������
				JOptionPane.showMessageDialog(up, "���� �غ�����ʾҽ��ϴ�.");
			}//end if
			HairTypeVO htvo = null;
			for(int i=0; i<list.size(); i++) {
				htvo=list.get(i);
				rowData = new Object[2];
				rowData[0]=htvo.getHairName();
				rowData[1]=htvo.getHairPrice();
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(up, "���񽺰� ��Ȱ���� ���մϴ�.");
			e.printStackTrace();
		}//end catch
	}//selectAllList
	
	public void setPermList() {
		DefaultTableModel dtm = up.getDtmPermInfo();
		dtm.setRowCount(0);//JTable�� ���ڵ� �ʱ�ȭ
		
		Object[] rowData = null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		BookingDAO bDAO = BookingDAO.getInstance();
		try {
			List<HairTypeVO> list = bDAO.selectPermHairType();
			if(list.isEmpty()) {//hairType����Ʈ�� �������
				JOptionPane.showMessageDialog(up, "���� �غ�����ʾҽ��ϴ�.");
			}//end if
			HairTypeVO htvo = null;
			for(int i=0; i<list.size(); i++) {
				htvo=list.get(i);
				rowData = new Object[2];
				rowData[0]=htvo.getHairName();
				rowData[1]=htvo.getHairPrice();
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(up, "���񽺰� ��Ȱ���� ���մϴ�.");
			e.printStackTrace();
		}//end catch
	}//setPermList

	public void setSpecialPermList() {
		DefaultTableModel dtm = up.getDtmPermSpecialInfo();
		dtm.setRowCount(0);//JTable�� ���ڵ� �ʱ�ȭ
		
		Object[] rowData = null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		BookingDAO bDAO = BookingDAO.getInstance();
		try {
			List<HairTypeVO> list = bDAO.selectSpecialPermType();
			if(list.isEmpty()) {//hairType����Ʈ�� �������
				JOptionPane.showMessageDialog(up, "���� �غ�����ʾҽ��ϴ�.");
			}//end if
			HairTypeVO htvo = null;
			for(int i=0; i<list.size(); i++) {
				htvo=list.get(i);
				rowData = new Object[2];
				rowData[0]=htvo.getHairName();
				rowData[1]=htvo.getHairPrice();
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(up, "���񽺰� ��Ȱ���� ���մϴ�.");
			e.printStackTrace();
		}//end catch
	}//setSpecialPermList
	
	public void setDyeList() {
		DefaultTableModel dtm = up.getDtmDyeInfo();
		dtm.setRowCount(0);//JTable�� ���ڵ� �ʱ�ȭ
		
		Object[] rowData = null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		BookingDAO bDAO = BookingDAO.getInstance();
		try {
			List<HairTypeVO> list = bDAO.selectDyeType();
			if(list.isEmpty()) {//hairType����Ʈ�� �������
				JOptionPane.showMessageDialog(up, "���� �غ�����ʾҽ��ϴ�.");
			}//end if
			HairTypeVO htvo = null;
			for(int i=0; i<list.size(); i++) {
				htvo=list.get(i);
				rowData = new Object[2];
				rowData[0]=htvo.getHairName();
				rowData[1]=htvo.getHairPrice();
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(up, "���񽺰� ��Ȱ���� ���մϴ�.");
			e.printStackTrace();
		}//end catch
	}//setDyeList
	
	public void setBleachList() {
		DefaultTableModel dtm = up.getDtmBleachingInfo();
		dtm.setRowCount(0);//JTable�� ���ڵ� �ʱ�ȭ
		
		Object[] rowData = null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		BookingDAO bDAO = BookingDAO.getInstance();
		try {
			List<HairTypeVO> list = bDAO.selectBleachType();
			if(list.isEmpty()) {//hairType����Ʈ�� �������
				JOptionPane.showMessageDialog(up, "���� �غ�����ʾҽ��ϴ�.");
			}//end if
			HairTypeVO htvo = null;
			for(int i=0; i<list.size(); i++) {
				htvo=list.get(i);
				rowData = new Object[2];
				rowData[0]=htvo.getHairName();
				rowData[1]=htvo.getHairPrice();
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(up, "���񽺰� ��Ȱ���� ���մϴ�.");
			e.printStackTrace();
		}//end catch
	}//setBleachList
	
	public void setClinicList() {
		DefaultTableModel dtm = up.getDtmClinicInfo();
		dtm.setRowCount(0);//JTable�� ���ڵ� �ʱ�ȭ
		
		Object[] rowData = null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		BookingDAO bDAO = BookingDAO.getInstance();
		try {
			List<HairTypeVO> list = bDAO.selectClinicType();
			if(list.isEmpty()) {//hairType����Ʈ�� �������
				JOptionPane.showMessageDialog(up, "���� �غ�����ʾҽ��ϴ�.");
			}//end if
			HairTypeVO htvo = null;
			for(int i=0; i<list.size(); i++) {
				htvo=list.get(i);
				rowData = new Object[2];
				rowData[0]=htvo.getHairName();
				rowData[1]=htvo.getHairPrice();
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(up, "���񽺰� ��Ȱ���� ���մϴ�.");
			e.printStackTrace();
		}//end catch
	}//setBleachList
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setCutList();
		setPermList();
		setSpecialPermList();
		setDyeList();
		setBleachList();
		setClinicList();
	}//actionPerformed
	
}//class
