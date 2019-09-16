package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.BookingDAO;
import kr.co.sist.user.view.Booking;
import kr.co.sist.user.vo.DesignerDateVO;
import kr.co.sist.user.vo.HairTypeVO;

public class BookingEvt extends MouseAdapter implements ActionListener {
	
	private Booking bk;
	
	private String flag;
	private int y_flag,m_flag,d_flag;
	private BookingDAO bDAO=BookingDAO.getInstance();
	
	private int designerPrice;
	
	public BookingEvt(Booking bk) {
		this.bk=bk;
	}
	
	public void hairType() {
		
		String[] column= {"",""};
		DefaultTableModel dtmHairName=bk.getDtmHairName();
		
		dtmHairName.setRowCount(0);
		
		Object[] rowData=new Object[2];
		
		
		List<HairTypeVO> hairTypeList;
		
		int cutCount=0;
		int permCount=0;
		int dyeCount=0;
		int clinicCount=0;
		
		int justPermCnt=0;
		int specialPermCnt=0;
		int justDyeCnt=0;
		int bleachingCnt=0;
		
		try {
			hairTypeList = bDAO.selectHairType();
			if( flag == null) {
				JOptionPane.showMessageDialog(bk, "½Ã¼úÀ» ¸ÕÀú ¼±ÅÃÇÏ½Ã¾î¾ßÇÕ´Ï´Ù.!!!");
				return;
			}//end if
			for(int i=0; i<hairTypeList.size(); i++) {
				if(hairTypeList.get(i).getHairType().equals("ÄÆ")) {
					cutCount+=1;
				}else if(hairTypeList.get(i).getHairType().contains("Æß")) {
					permCount+=1;
					if(hairTypeList.get(i).getHairCategory().equals("ÀÏ¹ÝÆß")) {
						justPermCnt+=1;
					}else if(hairTypeList.get(i).getHairCategory().equals("Æ¯¼öÆß")) {
						specialPermCnt+=1;
					}//end if
				}else if(hairTypeList.get(i).getHairType().contains("¿°»ö")) {
					dyeCount+=1;
					if(hairTypeList.get(i).getHairCategory().equals("¿°»ö")) {
						justDyeCnt+=1;
					}else if(hairTypeList.get(i).getHairCategory().equals("Å»»ö")) {
						bleachingCnt+=1;
					}//end if	
				}else {
					clinicCount+=1;
				}//end if
			}//end for
		
		if(flag.equals("c")) {
					
			for(int i=0; i<cutCount; i++) {
				
				rowData[0]=hairTypeList.get(i).getHairName();
				rowData[1]=hairTypeList.get(i).getHairPrice()+designerPrice;
				
				dtmHairName.addRow(rowData);
			}//end for
			
		}else if(flag.equals("p")) {
						
			for(int i=0; i<hairTypeList.size(); i++) {
				if(hairTypeList.get(i).getHairType().equals("Æß")) {
					if(dtmHairName.getDataVector().isEmpty()) {
						rowData[0]="<"+hairTypeList.get(i).getHairCategory()+">";
						rowData[1]=null;
						
						dtmHairName.addRow(rowData);
					}//end if
					if(hairTypeList.get(i).getHairCategory().equals("ÀÏ¹ÝÆß")) {
						rowData[0]=hairTypeList.get(i).getHairName();
						rowData[1]=hairTypeList.get(i).getHairPrice()+designerPrice;
						
						dtmHairName.addRow(rowData);
					}//end if
				}//end if
			}//end for
			
				rowData[0]="<"+hairTypeList.get(cutCount+justPermCnt).getHairCategory()+">";
				rowData[1]=null;
				
				dtmHairName.addRow(rowData);
				
			for(int i=(cutCount+justPermCnt); i<(cutCount+permCount); i++) {
				rowData[0]=hairTypeList.get(i).getHairName();
				rowData[1]=hairTypeList.get(i).getHairPrice()+designerPrice;
				
				dtmHairName.addRow(rowData);
			}//end for
			
		}else if(flag.equals("d")) {
			
			rowData[0]="<"+hairTypeList.get(cutCount+permCount).getHairCategory()+">";
			rowData[1]=null;
			
			dtmHairName.addRow(rowData);
			
			for(int i=(cutCount+permCount); i<(cutCount+permCount+justDyeCnt); i++) {
				rowData[0]=hairTypeList.get(i).getHairName();
				rowData[1]=hairTypeList.get(i).getHairPrice()+designerPrice;
				
				dtmHairName.addRow(rowData);
			}//end for
			
			rowData[0]="<"+hairTypeList.get(cutCount+permCount+justDyeCnt).getHairCategory()+">";
			rowData[1]=null;
			
			dtmHairName.addRow(rowData);
			
			for(int i=(cutCount+permCount+justDyeCnt); i<(cutCount+permCount+dyeCount); i++) {
				rowData[0]=hairTypeList.get(i).getHairName();
				rowData[1]=hairTypeList.get(i).getHairPrice()+designerPrice;
				
				dtmHairName.addRow(rowData);
			}//end for
			
		}else if(flag.equals("cl")) {
			
			rowData[0]="<"+hairTypeList.get(cutCount+permCount+dyeCount).getHairCategory()+">";
			rowData[1]=null;
			
			dtmHairName.addRow(rowData);
			
			for(int i=(cutCount+permCount+dyeCount); i<hairTypeList.size(); i++) {
				rowData[0]=hairTypeList.get(i).getHairName();
				rowData[1]=hairTypeList.get(i).getHairPrice()+designerPrice;
				
				dtmHairName.addRow(rowData);
			}//end for
			
		}//end if
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//hairType
	
	public DefaultComboBoxModel<String> hairDesigner() {
		
		DefaultComboBoxModel<String> dcbHairDesigner=new DefaultComboBoxModel<String>();
		List<DesignerDateVO> designerList;
		
		try {
			designerList=bDAO.selectDesigner();
			
			for(int i=0; i<designerList.size(); i++) {
				if(designerList.get(i).getP_code().equals("pos_0001")) {
					dcbHairDesigner.addElement(designerList.get(i).getDesigner()+" Director");
				}else if(designerList.get(i).getP_code().equals("pos_0002")) {
					dcbHairDesigner.addElement(designerList.get(i).getDesigner()+" Manager");
				}else if(designerList.get(i).getP_code().equals("pos_0003")) {
					dcbHairDesigner.addElement(designerList.get(i).getDesigner()+" Designer");
				}//end if
			}//end for
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return dcbHairDesigner;
	}//hairDesigner
	
	public void chooseHairDesigner(String  designer) {
		
		List<DesignerDateVO> designerList=null;
		
		int endIndex=designer.indexOf(" ");
		String designerName=designer.substring(0, endIndex);
		
		
		try {
			designerList=bDAO.selectDesigner();
			
			System.out.println(designerName);
			for(int i=0; i<designerList.size(); i++) {
				if(designerName.equals(designerList.get(i).getDesigner())) {
					designerPrice=designerList.get(i).getP_charge();
				}//end if
			}//end for
			hairType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//chooseHairDesigner
	
//	public List<DefaultComboBoxModel> Date() {
//		
//		DefaultComboBoxModel<Integer> dcbYear=new DefaultComboBoxModel<Integer>();
//		DefaultComboBoxModel<Integer> dcbMonth=new DefaultComboBoxModel<Integer>();
//		DefaultComboBoxModel<Integer> dcbDay=new DefaultComboBoxModel<Integer>();
//		
//		List<DefaultComboBoxModel> dateList=new ArrayList<DefaultComboBoxModel>();
//		
//		Calendar date=Calendar.getInstance();
//		
//		for(int i=0; i<2; i++) {
//			dcbYear.addElement(date.get(Calendar.YEAR)+i);
//		}
//		
//		for(int i=1; i<=12; i++) {
//			dcbMonth.addElement(date.get(Calendar.MONTH));
//		}
//		
//		date.get(Calendar)
//		for(int i=1; i<=)
//		dateList.add(dcbYear);			
//		return dateList;
//	}//Date
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(bk.getJrbCut().isSelected()) {
			flag="c";
			hairType();
		}//end if
		if(bk.getJrbPerm().isSelected()) {
			flag="p";
			hairType();
		}//end if
		if(bk.getJrbDye().isSelected()) {
			flag="d";
			hairType();
		}//end if
		if(bk.getJrbClinic().isSelected()) {
			flag="cl";
			hairType();
		}//end if
		
		if(ae.getSource()==bk.getJcbDesigner()) {
			chooseHairDesigner((String)bk.getJcbDesigner().getSelectedItem());
		}//end if
		
		if(ae.getSource()==bk.getJcbYear()) {
			y_flag=(int)bk.getJcbDesigner().getSelectedItem();
		}//end if
		if(ae.getSource()==bk.getJcbMonth()) {
			m_flag=(int)bk.getJcbDesigner().getSelectedItem();
		}//end if
		if(ae.getSource()==bk.getJcbDay()) {
			d_flag=(int)bk.getJcbDesigner().getSelectedItem();
		}//end if

	}//actionPerformed
	
	
}
