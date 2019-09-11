package kr.co.sist.user.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Booking extends JPanel {

	private JLabel jlblName,jlblPhone,jlblGender,jlblDesigner,jlblDate,
	jlblHairType,jlblTotal,jlblNote,jlblPass,
	jlblImg;
	
	private JRadioButton jrbFemale,jrbMale,
	jrbCut,jrbPerm,jrbDye,jrbClinic;
	
	private JTextField jtfName,jtfPhone;
	private JPasswordField jtfPass;
	
	private JComboBox<String> jcbDesigner,jcbTime;
	private JComboBox<Integer> jcbYear,jcbMonth,jcbDay;
	
	private DefaultListModel<String> dlmHairName,dlmHair;
	private JList<String> jlstHairName,jlstHair;
	
	private DefaultTableModel dtmHairName,dtmHair;
	private JTable jtHairName,jtHair;
	
	private JTextArea jtaTotal,jtaNote;
	
	private JButton jbtnAdd,jbtnDelete,jbtnBook,jbtnCancle;
	
	private LineBorder line;
	
	public Booking() {
		
//		JLabel
		jlblName=new JLabel("°í°´ÀÌ¸§");
		jlblName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jlblPhone=new JLabel("ÀüÈ­¹øÈ£");
		jlblPhone.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jlblGender=new JLabel("¼ºº°");
		jlblGender.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jlblDesigner=new JLabel("µðÀÚÀÌ³Ê");
		jlblDesigner.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jlblDate=new JLabel("¿¹¾àÀÏÀÚ");
		jlblDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jlblHairType=new JLabel("½Ã¼úÁ¾·ù");
		jlblHairType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		line=new LineBorder(Color.GRAY, 2);
		jlblHairType.setBorder(line);
		jlblTotal=new JLabel("ÃÑ ±Ý¾×");
		jlblTotal.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		jlblNote=new JLabel("ºñ°í");
		jlblNote.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jlblPass=new JLabel("ºñ¹Ð¹øÈ£");
		jlblPass.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		
		jlblName.setHorizontalAlignment(JLabel.CENTER);
		jlblPhone.setHorizontalAlignment(JLabel.CENTER);
		jlblGender.setHorizontalAlignment(JLabel.CENTER);
		jlblDesigner.setHorizontalAlignment(JLabel.CENTER);
		jlblDate.setHorizontalAlignment(JLabel.CENTER);
		jlblHairType.setHorizontalAlignment(JLabel.CENTER);
//		jlblTotal.setHorizontalAlignment(JLabel.CENTER);
//		jlblNote.setHorizontalAlignment(JLabel.CENTER);
		jlblPass.setHorizontalAlignment(JLabel.CENTER);
		
		ImageIcon advertisement=new ImageIcon("C:/dev/workspace/html_prj/WebContent/common/images/lemon.png");
		jlblImg=new JLabel(advertisement);
		
//		JTextField
		jtfName=new JTextField();
		jtfPhone=new JTextField();
		
//		JPasswordField
		jtfPass=new JPasswordField();
		
//		JRadioButton
		jrbFemale=new JRadioButton("¿©ÀÚ");
		jrbFemale.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jrbMale=new JRadioButton("³²ÀÚ");
		jrbMale.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ButtonGroup bgGender=new ButtonGroup();
		bgGender.add(jrbFemale);
		bgGender.add(jrbMale);
		
		jrbCut=new JRadioButton("ÄÆ");
		jrbCut.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jrbPerm=new JRadioButton("Æß");
		jrbPerm.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jrbDye=new JRadioButton("¿°»ö");
		jrbDye.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		jrbClinic=new JRadioButton("Å¬¸®´Ð");
		jrbClinic.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ButtonGroup bgHairType=new ButtonGroup();
		bgHairType.add(jrbCut);
		bgHairType.add(jrbPerm);
		bgHairType.add(jrbDye);
		bgHairType.add(jrbClinic);
		
//		ComboBox
		jcbDesigner=new JComboBox<String>();
		jcbTime=new JComboBox<String>();
		
		jcbYear=new JComboBox<Integer>();
		jcbMonth=new JComboBox<Integer>();
		jcbDay=new JComboBox<Integer>();
		
//		JList
		dlmHairName=new DefaultListModel<String>();
		jlstHairName=new JList<String>(dlmHairName);
		JScrollPane jspHairName=new JScrollPane(jlstHairName);
		dlmHair=new DefaultListModel<String>();
		jlstHair=new JList<String>(dlmHair);
		JScrollPane jspHair=new JScrollPane(jlstHair);
		
//		JButton
		jbtnAdd=new JButton("Ãß°¡");
		jbtnAdd.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		jbtnDelete=new JButton("»èÁ¦");
		jbtnDelete.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		jbtnBook=new JButton("¿¹¾à");
		jbtnBook.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		jbtnCancle=new JButton("¿¹¾àÃë¼Ò");
		jbtnCancle.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		
//		JTextArea
		jtaTotal=new JTextArea();
		jtaNote=new JTextArea();
		JScrollPane jspNote=new JScrollPane(jtaNote);
		
//		¹èÄ¡
		jlblName.setBounds(getX()+350, getY()+30, 60, 20);
		jtfName.setBounds(getX()+430, getY()+30, 225, 20);
		
		jlblPhone.setBounds(getX()+350, getY()+55, 60, 20);
		jtfPhone.setBounds(getX()+430, getY()+55, 225, 20);
		
		jlblGender.setBounds(getX()+350, getY()+80, 60, 20);
		
		JPanel jpGender=new JPanel();
		jpGender.add(jrbFemale);
		jpGender.add(jrbMale);
		jpGender.setBounds(getX()+430, getY()+75, 225, 40);		
		
		jlblDesigner.setBounds(getX()+350, getY()+120, 60, 20);
		jcbDesigner.setBounds(getX()+430, getY()+120, 225, 20);
		
		jlblDate.setBounds(getX()+350, getY()+145, 60, 20);
		jcbYear.setBounds(getX()+430, getY()+145, 80, 20);
		jcbMonth.setBounds(getX()+525, getY()+145, 60, 20);
		jcbDay.setBounds(getX()+595, getY()+145, 60, 20);
		jcbTime.setBounds(getX()+430, getY()+170, 225, 20);
		
		jlblHairType.setBounds(getX()+350, getY()+205, 305, 20);
		
		JPanel jpHairType=new JPanel();
		jpHairType.add(jrbCut);
		jpHairType.add(jrbPerm);
		jpHairType.add(jrbDye);
		jpHairType.add(jrbClinic);
		jpHairType.setBounds(getX()+350, getY()+220, 305, 40);
		
		jspHairName.setBounds(getX()+350, getY()+260, 305, 60);
		jbtnAdd.setBounds(getX()+595, getY()+325, 60, 20);
		jspHair.setBounds(getX()+350, getY()+350, 305, 60);
		jbtnDelete.setBounds(getX()+595, getY()+415, 60, 20);
		
		jlblImg.setBounds(getX()+30, getY()+30, 300, 280);
		jlblImg.setBorder(new TitledBorder("±¤°í"));
		
		jlblTotal.setBounds(getX()+30, getY()+300, 300, 60);
		jtaTotal.setBounds(getX()+30, getY()+350, 300, 60);
		
		jlblNote.setBounds(getX()+30, getY()+440, 60, 20);
		jspNote.setBounds(getX()+30, getY()+465, 625, 50);
		
		jlblPass.setBounds(getX()+350, getY()+520, 60, 20);
		jtfPass.setBounds(getX()+430, getY()+520, 225, 20);
		
		jbtnBook.setBounds(getX()+430, getY()+550, 100, 20);
		jbtnCancle.setBounds(getX()+555, getY()+550, 100, 20);
		
		add(jlblName);
		add(jtfName);
		add(jlblPhone);
		add(jtfPhone);
		add(jlblGender);
		add(jpGender);
		add(jlblDesigner);
		add(jcbDesigner);
		add(jlblDate);
		add(jcbYear);
		add(jcbMonth);
		add(jcbDay);
		add(jlblDate);
		add(jcbTime);
		add(jlblHairType);
		add(jpHairType);
		add(jspHairName);
		add(jbtnAdd);
		add(jspHair);
		add(jbtnDelete);
		add(jlblTotal);
		add(jtaTotal);
		add(jlblNote);
		add(jspNote);
		add(jlblPass);
		add(jtfPass);
		add(jbtnBook);
		add(jbtnCancle);
		add(jlblImg);
		
		setLayout(null);
		
//		JScrollPane jscp=new JScrollPane
//				(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		setContentPane(jscp);
		
		
		
		
//		setBounds(10, 10, 700, 400);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new Booking();
//	}
}
