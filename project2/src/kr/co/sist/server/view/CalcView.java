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
		String[] CalcColumn= {"날짜", "시술종류", "디자이너", "결제금액"};
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
		jcbCalcIndex.addItem("디자이너명");
		jcbCalcIndex.addItem("시술종류");
		
		jcbCalcYear1=new JComboBox<String>();
		jcbCalcYear2=new JComboBox<String>();
		jcbCalcMonth1=new JComboBox<String>();
		jcbCalcMonth2=new JComboBox<String>();
		jcbCalcDay1=new JComboBox<String>();
		jcbCalcDay2=new JComboBox<String>();
		
		jcbCalcYear1.addItem("2019");
		jcbCalcYear2.addItem("2019");
		jcbCalcMonth1.addItem("1월");
		jcbCalcMonth2.addItem("1월");
		jcbCalcDay1.addItem("1일");
		jcbCalcDay2.addItem("1일");
		
		jbtCalc=new JButton("검색");
		
		jlDash=new JLabel("-");
		jlMeyong=new JLabel("명");
		jlWon=new JLabel("원");
		jlTotalIncome=new JLabel("총 매출");
		jlTotalClient=new JLabel("총 고객 수");
		
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
