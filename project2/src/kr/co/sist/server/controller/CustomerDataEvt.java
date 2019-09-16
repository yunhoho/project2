package kr.co.sist.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import kr.co.sist.server.dao.AdminDAO;
import kr.co.sist.server.dao.CustomerDAO;
import kr.co.sist.server.view.CustomerData;
import kr.co.sist.server.vo.CustomerDataVO;

public class CustomerDataEvt extends MouseAdapter implements ActionListener {
	private CustomerData cd;
	
	public CustomerDataEvt(CustomerData cd) {
		this.cd=cd;
		setCustomerList(null);
	}//CustomerDataEvt
	
	
	public DefaultTableModel setCustomerList(String cName) {
		DefaultTableModel dtm=cd.getDtmCustomerList();
		//JTable�� ���ڵ� �ʱ�ȭ
		dtm.setRowCount(0);
		
		Object[] rowData=null;//JTable�� ���� ������
		
		//DBMS���� ��ȸ
		CustomerDAO cDAO=CustomerDAO.getInstance();
		try {
			List<CustomerDataVO> list=cDAO.selectAllCustomerData(cName);
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(cd, "�������Ͱ� �����ϴ�. �� �����͸� ������ �ֽñ� �ٶ��ϴ�.");
			}//if
			CustomerDataVO cdVO=null;
			for (int i = 0; i < list.size(); i++) {
				
				cdVO=list.get(i);
				rowData=new Object[4];
				
				rowData[0]=cdVO.getcName();
				rowData[1]=cdVO.getcPhone();
				rowData[2]=cdVO.getcGender();
				rowData[3]=cdVO.getbDate();
				
				dtm.addRow(rowData);
				
			}//for
			
			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(cd, "�˼��մϴ�. ���񽺰� ��Ȱ���� �ʽ��ϴ�.");
			se.printStackTrace();
		}//catch
		return dtm;
	}//setCustomerList
	

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cd.getJtfCustomerName()) {
			setCustomerList(cd.getJtfCustomerName().getText().trim());
		}
	}
	@Override
	public void mouseClicked(MouseEvent me) {

	}
	

}
