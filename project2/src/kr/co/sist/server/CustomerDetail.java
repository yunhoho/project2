package kr.co.sist.server;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerDetail extends JFrame implements ActionListener{
	private JTextField jtfName,jtfPhone;
	private JRadioButton jrbF, jrbM;
	private ButtonGroup bgGender;
	private JLabel 
		jlbInfo,jlbName,jlbPhone, jlbGender, 
		jlbHair,jlbHairType, jlbThickness, jlbColor, jlbScalp, 
		jlbDesigner,jlbNote,
		jlImg;
	
	private JComboBox<String> 
		jcbHairType, jcbThickness, jcbColor, jcbScalp, jcbDesigner ;
	private DefaultComboBoxModel<String> 
		dcbmHairType, dcbmThickness, dcbmColor, dcbmScalp,dcbmDesigner;
	private JTextArea jtaNote;
	private JButton jbtImg,jbtChange, jbtClose;
	private JScrollPane jspNote ;
	
	public CustomerDetail() {
		//JtextField
		jtfName =new JTextField();
	
		jtfPhone =new JTextField();
		//JLabel
		jlbInfo=new JLabel("�Ż�����");
		jlbName=new JLabel("�̸�");
		jlbPhone=new JLabel("��ȭ��ȣ");
		jlbGender=new JLabel("����");
		
		jlbHair=new JLabel("��߻���");
		jlbHairType=new JLabel("�Ӹ���");
		jlbThickness=new JLabel("����");
		jlbColor=new JLabel("����");
		jlbScalp=new JLabel("����");
		
		jlbDesigner=new JLabel("�������̳�");
		jlbNote=new JLabel("Ư�̻���");
		
		//��Ʈ
		Font font=new Font("���� ���",Font.BOLD,20);
		jlbDesigner.setFont(font);
		jlbNote.setFont(font);
		jlbInfo.setFont(font);
		jlbHair.setFont(font);
		Font fonts=new Font("���� ���", Font.BOLD,16);		
		jlbName.setFont(fonts);
		jlbPhone.setFont(fonts);
		jlbGender.setFont(fonts);
		jlbHairType.setFont(fonts);
		jlbThickness.setFont(fonts);
		jlbColor.setFont(fonts);
		jlbScalp.setFont(fonts);
		
		//JTextArea
		jtaNote=new JTextArea();
		
		//Jbutton
		jbtChange=new JButton("����");
		jbtClose=new JButton("�ݱ�");
		jbtImg=new JButton("�̹��� ����");
		
		//�̹���
		jlImg=new JLabel();//�̹��� ��������
		jlImg.setIcon(new ImageIcon("C:/dev/workspace/team3_2_prj/src/view/images/dfsds.png") );
		
		//JRadioButton
		jrbF =new JRadioButton("����");
		jrbM =new JRadioButton("����");
		jrbF.setSelected(true);

		bgGender=new ButtonGroup();
		bgGender.add(jrbF);
		bgGender.add(jrbM);
		
		//DefaultComboBoxModel
		String[]type= {"����", "����","�ݰ���"};
		dcbmHairType=new DefaultComboBoxModel<String>(type);
		String[]thickness= {"����", "����","����"};
		dcbmThickness=new DefaultComboBoxModel<String>(thickness);
		String[]color= {"������", "����","������","���� ����"};
		dcbmColor=new DefaultComboBoxModel<String>(color);
		String[]scalp= {"����", "�Ǽ�","���ռ�"};
		dcbmScalp=new DefaultComboBoxModel<String>(scalp);
		String[]designer= {"1","2","3","4","5"};//db���� ������ ������!!!!!
		dcbmDesigner=new DefaultComboBoxModel<String>(designer);
		//JComboBox
		
		jcbHairType=new JComboBox<String>(dcbmHairType);
		jcbThickness=new JComboBox<String>(dcbmThickness);
		jcbColor=new JComboBox<String>(dcbmColor);
		jcbScalp=new JComboBox<String>(dcbmScalp);
		jcbDesigner=new JComboBox<String>(dcbmDesigner);
		
		
		//��ũ��
		jspNote=new JScrollPane(jtaNote);
		
		//setBound
		jlImg.setBounds(getX()+70,getY()+ 60, 200, 215);
		jbtImg.setBounds(getX()+70, getY() +290 , 200, 30);
		jbtImg.setBounds(getX()+70, getY() +290 , 200, 30);
		jlbDesigner.setBounds(getX()+70, getY() +510 , 200, 30);
		jcbDesigner.setBounds(getX()+70, getY() +545 , 200, 30);
		jlbInfo.setBounds(getX()+335 , getY()+ 60, 100, 30);
		jlbName.setBounds(getX()+335 , getY()+ 105, 100, 30);
		jtfName.setBounds(getX()+415 , getY()+ 105, 200, 30);
		jlbPhone.setBounds(getX()+335 , getY()+ 175, 100, 30);
		jtfPhone.setBounds(getX()+415 , getY()+ 175, 200, 30);
		jlbGender.setBounds(getX()+335 , getY()+ 210, 100, 30);
		jrbF.setBounds(getX()+415 , getY()+ 210, 100, 30);
		jrbM.setBounds(getX()+515 , getY()+ 210, 100, 30);
		jlbHair.setBounds(getX()+335 , getY()+ 265, 100, 30);
		jlbHairType.setBounds(getX()+335 , getY()+ 310, 100, 30);
		jcbHairType.setBounds(getX()+415 , getY()+ 310, 200, 30);
		jlbThickness.setBounds(getX()+335 , getY()+ 345, 100, 30);
		jcbThickness.setBounds(getX()+415 , getY()+ 345, 200, 30);
		jlbColor.setBounds(getX()+335 , getY()+ 380, 100, 30);
		jcbColor.setBounds(getX()+415 , getY()+ 380, 200, 30);
		jlbScalp.setBounds(getX()+335 , getY()+ 415, 100, 30);
		jcbScalp.setBounds(getX()+415 , getY()+ 415, 200, 30);
		jlbNote.setBounds(getX()+335 , getY()+ 470, 200, 30);
		jspNote.setBounds(getX()+335 , getY()+ 505, 280, 70);
		jbtChange.setBounds(getX()+155 , getY()+ 615, 155, 35);
		jbtClose.setBounds(getX()+370, getY()+ 615, 155, 35);
		
		//��ġ
		add(jlImg);
		add(jbtImg);
		add(jlbDesigner);
		add(jcbDesigner);
		add(jlbInfo);
		add(jlbName);
		add(jtfName);
		add(jlbPhone);
		add(jtfPhone);
		add(jlbGender);
		add(jrbF);
		add(jrbM);
		add(jlbHair);
		add(jlbHairType);
		add(jcbHairType);
		add(jlbThickness);
		add(jcbThickness);
		add(jlbColor);
		add(jcbColor);
		add(jlbScalp);
		add(jcbScalp);
		add(jlbNote);
		add(jspNote);
		add(jbtChange);
		add(jbtClose);
		
		//
		setLayout(null);
		setBounds(100,100,700,760);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ClientDataDetail
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed

	public static void main(String[] args) {
		new CustomerDetail();
	}//m
	

}//c
