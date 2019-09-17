package kr.co.sist.server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import kr.co.sist.server.dao.AdminDAOHyj;
import kr.co.sist.server.view.AdminMainView;
import kr.co.sist.server.view.LoginView;
import kr.co.sist.server.vo.LoginVO;
import kr.co.sist.util.cipher.DataEncrypt;

public class LoginEvt implements ActionListener{
	private LoginView lv;
	
	public LoginEvt(LoginView lv) {
		this.lv = lv;
	}//LoginEvt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==lv.getJtfPass()||ae.getSource()==lv.getJbLogin()) {
			String inputPass=new String(lv.getJtfPass().getPassword());
			String inputId=lv.getJtfId().getText();
			String shaPass="";
			
//			System.out.println("id : "+inputId);
//			System.out.println("pass : "+inputPass);
			
			try {
				shaPass=DataEncrypt.messageDigest("MD5", inputPass);
				//System.out.println(shaPass);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			LoginVO lVO=new LoginVO(inputId, shaPass);
			
			AdminDAOHyj aDAOH=AdminDAOHyj.getInstance();
			
			try {
				String name=aDAOH.selectLogin(lVO);
				
				if(!name.isEmpty()) {
					new AdminMainView();
					lv.dispose();
				}else {
					JOptionPane.showMessageDialog(lv, "비밀번호를 확인바랍니다.");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
			
		}//end if
		
		if(ae.getSource()==lv.getJbClose()) {
			lv.dispose();
		}
		
		
	}//actionPerformed

}
