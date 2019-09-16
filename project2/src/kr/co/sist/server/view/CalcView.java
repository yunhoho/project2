package kr.co.sist.server.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CalcView extends JPanel{
	private JComboBox<String> jcbCalcIndex, jcbCalcYear1, jcbCalcMonth1, jcbCalcDay1,jcbCalcYear2, jcbCalcMonth2, jcbCalcDay2;
	private JTextField jtfCalc, jtfTotalIncome, jtfTotalclient;
	private JButton jbtCalc;
	private JLabel jlDash, jlTotalIncome, jlTotalClient, jlWon, jlMeyong;
	private DefaultTableModel dtmCalc;
	private JTable jtCalc;
	
	public CalcView() {
		String[] CalcColumn= {"��¥", "�ü�����", "�����̳�", "�����ݾ�"};
		dtmCalc=new DefaultTableModel(CalcColumn,0);
		jtCalc=new JTable(dtmCalc) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jtCalc.setRowHeight(25);
		
		jcbCalcIndex=new JComboBox<String>();
		jcbCalcIndex.addItem("�����̳ʸ�");
		jcbCalcIndex.addItem("�ü�����");
		
		jcbCalcYear1=new JComboBox<String>();
		jcbCalcYear2=new JComboBox<String>();
		jcbCalcMonth1=new JComboBox<String>();
		jcbCalcMonth2=new JComboBox<String>();
		jcbCalcDay1=new JComboBox<String>();
		jcbCalcDay2=new JComboBox<String>();
		
		jcbCalcYear1.addItem("2019");
		jcbCalcYear2.addItem("2019");
		jcbCalcMonth1.addItem("1��");
		jcbCalcMonth2.addItem("1��");
		jcbCalcDay1.addItem("1��");
		jcbCalcDay2.addItem("1��");
		
		jbtCalc=new JButton("�˻�");
		
		jlDash=new JLabel("-");
		jlMeyong=new JLabel("��");
		jlWon=new JLabel("��");
		jlTotalIncome=new JLabel("�� ����");
		jlTotalClient=new JLabel("�� �� ��");
		
		jtfCalc=new JTextField(15);
		jtfTotalIncome=new JTextField(15);
		jtfTotalIncome.setEditable(false);
		jtfTotalclient=new JTextField(15);
		jtfTotalclient.setEditable(false);
		
		JScrollPane jspCalcList=new JScrollPane(jtCalc);
		
		JPanel jpCalcNorth=new JPanel();
		jpCalcNorth.add(jcbCalcIndex);
		jpCalcNorth.add(jtfCalc);
		jpCalcNorth.add(jbtCalc);
		
		JPanel jpCalcDate=new JPanel();
		jpCalcDate.add(jcbCalcYear1);
		jpCalcDate.add(jcbCalcMonth1);
		jpCalcDate.add(jcbCalcDay1);
		jpCalcDate.add(jlDash);
		jpCalcDate.add(jcbCalcYear2);
		jpCalcDate.add(jcbCalcMonth2);
		jpCalcDate.add(jcbCalcDay2);
		
		JPanel jpCalcIncome=new JPanel();
		jpCalcIncome.add(jlTotalIncome);
		jpCalcIncome.add(jtfTotalIncome);
		jpCalcIncome.add(jlWon);
		
		JPanel jpCalcClient=new JPanel();
		jpCalcClient.add(jlTotalClient);
		jpCalcClient.add(jtfTotalclient);
		jpCalcClient.add(jlMeyong);
		
		
		jpCalcNorth.setBounds(0,10,800,35);
		jpCalcDate.setBounds(0,45,800,35);
		jspCalcList.setBounds(0, 85, 790, 300);
		jpCalcIncome.setBounds(0, 385, 800, 25);
		jpCalcClient.setBounds(0, 410, 800, 25);
		
		add(jpCalcNorth);
		add(jpCalcDate);
		add(jspCalcList);
		add(jpCalcIncome);
		add(jpCalcClient);
		
		setLayout(null);
		setBounds(100, 100, 800, 500);
			
		
	}//CalcView

}
