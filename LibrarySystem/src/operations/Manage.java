package operations;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import login.DBConnection;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;



public class Manage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textTitlu;
	private JTextField textNrbucati;
	private JTextField textPret;
	private JTextField textAutor;
	private JTable displayTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage frame = new Manage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	DBConnection conn;
	
	public Manage() {
		initialize();
		conn = new DBConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Data base connection not available.", "Connection Error",JOptionPane.ERROR_MESSAGE);	
			
		}
		ShowTable();
	}
	
	public ArrayList<Book> getBooks()
	   {
	       ArrayList<Book> bookList = new ArrayList<Book>();
	       Connection dbconn = DBConnection.connectDB();
	       
	       String query = "SELECT * FROM  books";
	       Statement st;
	       ResultSet rs;
	       
	       try {
	           st = dbconn.createStatement();
	           rs = st.executeQuery(query);
	           Book book;
	           while(rs.next())
	           {
	               book = new Book(rs.getInt("bookID"),rs.getString("titlu"),rs.getString("autor"),rs.getInt("nrbucati"),rs.getDouble("pret"));
	               bookList.add(book);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return bookList;
	   }
	
	public void ShowTable() {
		ArrayList<Book> list = getBooks();
		DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getTitlu();
			row[2] = list.get(i).getAutor();
			row[3] = list.get(i).getNrbucati();
			row[4] = list.get(i).getPret();
			
			model.addRow(row);
		}	
		
	}
	public void RefreshQuery() {
		DefaultTableModel model= (DefaultTableModel)displayTable.getModel();
		model.setRowCount(0);
		ShowTable();
		
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(255, 250, 240));
		contentPane_1.setBounds(0, 0, 934, 561);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 934, 50);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("Librarie");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel.setBounds(45, 11, 847, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(0, 50, 934, 64);
		contentPane_1.add(panel_1);
		
		JButton btnManage = new JButton("Manage products");
		btnManage.setForeground(Color.WHITE);
		btnManage.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnManage.setBackground(new Color(153, 51, 51));
		btnManage.setBounds(58, 11, 210, 41);
		panel_1.add(btnManage);
		
		JButton btnVeziComenzile = new JButton("Vezi comenzile");
		btnVeziComenzile.setForeground(Color.WHITE);
		btnVeziComenzile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziComenzile.setBackground(new Color(153, 51, 51));
		btnVeziComenzile.setBounds(365, 11, 210, 41);
		panel_1.add(btnVeziComenzile);
		
		JButton btnVeziRecenzii = new JButton("Vezi recenzii");
		btnVeziRecenzii.setForeground(Color.WHITE);
		btnVeziRecenzii.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziRecenzii.setBackground(new Color(153, 51, 51));
		btnVeziRecenzii.setBounds(653, 11, 210, 41);
		panel_1.add(btnVeziRecenzii);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(56, 133, 37, 22);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Titlu");
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(56, 166, 64, 22);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Autor");
		lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(56, 202, 81, 22);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nr. bucati");
		lblNewLabel_1_1_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(496, 133, 88, 22);
		contentPane_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Pret");
		lblNewLabel_1_1_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(496, 166, 64, 22);
		contentPane_1.add(lblNewLabel_1_1_3);
		
		textID = new JTextField();
		textID.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textID.setBounds(144, 125, 212, 28);
		contentPane_1.add(textID);
		textID.setColumns(10);
		
		textTitlu = new JTextField();
		textTitlu.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textTitlu.setColumns(10);
		textTitlu.setBounds(144, 163, 212, 28);
		contentPane_1.add(textTitlu);
		
		textNrbucati = new JTextField();
		textNrbucati.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textNrbucati.setColumns(10);
		textNrbucati.setBounds(597, 125, 212, 28);
		contentPane_1.add(textNrbucati);
		
		textPret = new JTextField();
		textPret.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textPret.setColumns(10);
		textPret.setBounds(597, 163, 212, 28);
		contentPane_1.add(textPret);
		
		textAutor = new JTextField();
		textAutor.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textAutor.setColumns(10);
		textAutor.setBounds(144, 202, 212, 28);
		contentPane_1.add(textAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 280, 820, 244);
		contentPane_1.add(scrollPane);
		
		DefaultTableModel model;
		displayTable = new JTable();
		displayTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
		displayTable.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		displayTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = displayTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
				textID.setText(model.getValueAt(i,0).toString());
				textTitlu.setText(model.getValueAt(i,1).toString());
				textAutor.setText(model.getValueAt(i,2).toString());
				textNrbucati.setText(model.getValueAt(i,3).toString());
				textPret.setText(model.getValueAt(i,4).toString());
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID", "Titlu", "Autor", "Nr bucati", "Pret"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		displayTable.setModel(model);
		scrollPane.setViewportView(displayTable);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection dbconn = DBConnection.connectDB();
				PreparedStatement st = null;
				try {
					st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO `books` (`bookID`, `titlu`, `autor`, `nrbucati`, `pret`) VALUES ('"+textID.getText()+"', '"+textTitlu.getText()+"', '"+textAutor.getText()+"', '"+textNrbucati.getText()+"', '"+textPret.getText()+"')");
				
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
				
				try {
					int res = st.executeUpdate();
					RefreshQuery();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 102, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(383, 211, 100, 40);
		contentPane_1.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection dbconn = DBConnection.connectDB();
				PreparedStatement st = null;
				try {
					st = (PreparedStatement)dbconn.prepareStatement("DELETE FROM `books` WHERE `bookID` ="+textID.getText());
				
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
				
				try {
					int res = st.executeUpdate();
					RefreshQuery();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnDelete.setBackground(new Color(255, 102, 51));
		btnDelete.setBounds(659, 211, 100, 40);
		contentPane_1.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection dbconn = DBConnection.connectDB();
				PreparedStatement st = null;
				try {
					st = (PreparedStatement)dbconn.prepareStatement("UPDATE `books` SET `titlu`='"+textTitlu.getText()+"',`autor`='"+textAutor.getText()+"',`nrbucati`='"+textNrbucati.getText()+"' ,`pret`="+textPret.getText()+" WHERE `bookID` = "+textID.getText());
				
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 			
				try {
					int res = st.executeUpdate();
					RefreshQuery();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnEdit.setBackground(new Color(255, 102, 51));
		btnEdit.setBounds(521, 211, 100, 40);
		contentPane_1.add(btnEdit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textID.setText("");
				textTitlu.setText("");
				textAutor.setText("");
				textNrbucati.setText("");
				textPret.setText("");
				
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnClear.setBackground(new Color(255, 102, 51));
		btnClear.setBounds(800, 211, 100, 40);
		contentPane_1.add(btnClear);
		
		
		
	}
}
