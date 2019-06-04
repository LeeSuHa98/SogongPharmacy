/**
 * @systemName		SOGONG Pharmacy Management System
 * @subSystemName	SupplierManagement
 * @className 		SupplierDeleteView
 * @author 			�̼���
 */
package �Ұ��౹_�ŷ�ó����;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class SupplierDeleteView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel tableModel; 
	private JTable supplierTable;

	SupplierManager supplierInfo = new SupplierManager();
	
	public void showView() {
		SupplierManager sm = new SupplierManager();
		
		sm.readAllSuppliers();
		
		ArrayList<Supplier> al = sm.list;
		
		
		for(int i = 0; i < al.size(); i++) {
			Supplier s = al.get(i);
					
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			Object [] temp_row= new Object[]{s.getSupplierCode(), s.getSupplierName(), s.getContactNum(), s.getClosed(), s.getProductClassify(), s.getCost()};
			
			model.addRow(temp_row);
			model.fireTableDataChanged();
		}
	}
	
	public void RequestRegisterSupplierInfo() {
		tableModel = (DefaultTableModel)table.getModel();
		
		int row = table.getSelectedRow();
		
		if(row < 0) {
			return ;
		}

		String code = (String) tableModel.getValueAt(row, 0);
		String name = (String) tableModel.getValueAt(row, 1);
		String phone = (String) tableModel.getValueAt(row, 2);
		String closed = (String) tableModel.getValueAt(row, 3);
		String product = (String) tableModel.getValueAt(row, 4);
		int cost = (int) tableModel.getValueAt(row, 5);

		Supplier s = new Supplier(code, name, phone, closed, product, cost);
		supplierInfo.deleteSupplier(s);

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierDeleteView frame = new SupplierDeleteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SupplierDeleteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�ŷ�ó ����");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 40));
		lblNewLabel.setBounds(624, 34, 213, 38);
		contentPane.add(lblNewLabel);
		
		Object supplierColumn[]  = new Object[6];
		String[] supplierColumnList = {"�ŷ�ó�ڵ�","�ŷ�ó ��", "����ó", "�޹���", "�����ǰ��", "�ŷ���ǰ ����"};
		tableModel = new DefaultTableModel(supplierColumnList,0);
		
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestRegisterSupplierInfo();
				if (e.getSource().equals(btnNewButton))
				{
					JOptionPane.showMessageDialog(contentPane, "������  �Ϸ�Ǿ����ϴ�.");
				}
				
				tableModel.setRowCount(0);
			}
		});
		btnNewButton.setBounds(1329, 665, 139, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����ȭ��");
		btnNewButton_1.setBounds(29, 665, 139, 64);
		contentPane.add(btnNewButton_1);
		table = new JTable(tableModel);
		JScrollPane scrollPane_2 = new JScrollPane(table);
		scrollPane_2.setBounds(79, 129, 1298, 433);
		contentPane.add(scrollPane_2);
		JScrollPane scrollPane_1 = new JScrollPane(supplierTable);
		scrollPane_2.setColumnHeaderView(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_2.setColumnHeaderView(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("\uAC70\uB798\uCC98 \uC870\uD68C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showView();
			}
		});
		btnNewButton_2.setBounds(1238, 78, 139, 27);
		contentPane.add(btnNewButton_2);

	}
}