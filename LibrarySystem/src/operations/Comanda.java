package operations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import login.DBConnection;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Comanda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable displayTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comanda frame = new Comanda();
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
	private JTextField textTitlu;
	private JTextField textNrbucatiCom;
	private JTextField textCauta;
	private JTextField textPret;
	private JTextField textId;
	private JTextField textNume;
	private JTextField textTelefon;
	
	public Comanda() {
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
	
	public void initialize() {
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
		panel_1.setBounds(0, 50, 934, 66);
		contentPane_1.add(panel_1);
		
		JButton btnBrowse = new JButton("Vezi cartile");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veziProduse v = new veziProduse();
				dispose();
				v.setTitle("Produse");
				v.setVisible(true);
				v.setLocationRelativeTo(null);
			}
		});
		btnBrowse.setForeground(Color.WHITE);
		btnBrowse.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnBrowse.setBackground(new Color(153, 51, 51));
		btnBrowse.setBounds(46, 11, 180, 41);
		panel_1.add(btnBrowse);
		
		JButton btnComanda = new JButton("Comanda");
		btnComanda.setForeground(Color.WHITE);
		btnComanda.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnComanda.setBackground(new Color(153, 51, 51));
		btnComanda.setBounds(266, 11, 180, 41);
		panel_1.add(btnComanda);
		
		JButton btnVeziRecenziile = new JButton("Vezi recenziile");
		btnVeziRecenziile.setForeground(Color.WHITE);
		btnVeziRecenziile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziRecenziile.setBackground(new Color(153, 51, 51));
		btnVeziRecenziile.setBounds(487, 11, 180, 41);
		panel_1.add(btnVeziRecenziile);
		
		JButton btnScrieORecenzie = new JButton("Scrie o recenzie");
		btnScrieORecenzie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrieRecenzie s = new scrieRecenzie();
				dispose();
				s.setTitle("Produse");
				s.setVisible(true);
				s.setLocationRelativeTo(null);
			}
		});
		btnScrieORecenzie.setForeground(Color.WHITE);
		btnScrieORecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnScrieORecenzie.setBackground(new Color(153, 51, 51));
		btnScrieORecenzie.setBounds(705, 11, 180, 41);
		panel_1.add(btnScrieORecenzie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 175, 633, 193);
		contentPane_1.add(scrollPane);
		
		textTitlu = new JTextField();
		textTitlu.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textTitlu.setColumns(10);
		textTitlu.setBounds(750, 189, 173, 28);
		contentPane_1.add(textTitlu);
		
		textNrbucatiCom = new JTextField();
		textNrbucatiCom.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textNrbucatiCom.setColumns(10);
		textNrbucatiCom.setBounds(750, 264, 173, 28);
		contentPane_1.add(textNrbucatiCom);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Id");
		lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(688, 156, 39, 22);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Titlu");
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(688, 195, 52, 22);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Pret");
		lblNewLabel_1_1_2_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(688, 237, 52, 22);
		contentPane_1.add(lblNewLabel_1_1_2_1);
		
		textPret = new JTextField();
		textPret.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textPret.setColumns(10);
		textPret.setBounds(751, 228, 173, 28);
		contentPane_1.add(textPret);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nr. bucati");
		lblNewLabel_1_1_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(663, 270, 88, 22);
		contentPane_1.add(lblNewLabel_1_1_2);
		
		DefaultTableModel model;
		displayTable = new JTable();
		displayTable.setRowHeight(20);
		displayTable.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		displayTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
		displayTable.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		displayTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = displayTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
				textId.setText(model.getValueAt(i,0).toString());
				textTitlu.setText(model.getValueAt(i,1).toString());
				textPret.setText(model.getValueAt(i, 4).toString());
				textNrbucatiCom.setText("");
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID", "Titlu", "Autor", "Nr bucati", "Pret"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		displayTable.setModel(model);
		scrollPane.setViewportView(displayTable);
		
		textCauta = new JTextField();
		textCauta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model= (DefaultTableModel)displayTable.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
				displayTable.setRowSorter(sorter);
							
				sorter.setRowFilter(RowFilter.regexFilter(textCauta.getText(),1));
				
			}
		});
		textCauta.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textCauta.setColumns(10);
		textCauta.setBounds(194, 136, 255, 28);
		contentPane_1.add(textCauta);
		
		JLabel lblCautaDupaTitlu = new JLabel("Cauta dupa titlu");
		lblCautaDupaTitlu.setForeground(new Color(139, 0, 0));
		lblCautaDupaTitlu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCautaDupaTitlu.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		lblCautaDupaTitlu.setBounds(10, 134, 193, 28);
		contentPane_1.add(lblCautaDupaTitlu);
		
		JTextArea Factura = new JTextArea();
		Factura.setFont(new Font("Monospaced", Font.PLAIN, 14));
		Factura.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Factura.setBounds(20, 389, 633, 149);
		contentPane_1.add(Factura);
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			int i = 0;
			public void actionPerformed(ActionEvent e) {
						
				if(textNrbucatiCom.getText().isEmpty() || textTitlu.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selectati un produs si nr bucati.", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					Double PretTotal = Double.valueOf(textPret.getText().toString()) * Integer.valueOf(textNrbucatiCom.getText());
					i++;

					if(i==1) {
						Factura.setText(Factura.getText() + "\t------Comanda librarie------\n" + "\tID TITLU                      PRET   NR.BUCARI    TOTAL \n\t" + textId.getText() + " " + textTitlu.getText() + "        " + textPret.getText() + "        " + textNrbucatiCom.getText() + "     " + PretTotal + "\n\t");
					
					}
					else {
						Factura.setText(Factura.getText() + textId.getText() + " " + textTitlu.getText() + "        " + textPret.getText() + "        " + textNrbucatiCom.getText() + "     " + PretTotal + "\n\t");
					}
						
				}
				
				
			}
		});	
		btnAdauga.setForeground(Color.WHITE);
		btnAdauga.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnAdauga.setBackground(new Color(255, 102, 51));
		btnAdauga.setBounds(705, 316, 175, 41);
		contentPane_1.add(btnAdauga);
		
		JButton btnTrimite = new JButton("Trimite!");
		btnTrimite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Factura.print();
				} catch (PrinterException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				Connection dbconn = DBConnection.connectDB();
				PreparedStatement st = null;
				try {
					///	AICI ESTI
					st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO `comenzi` ( `numeClient`, `telefon`, `itemID`, `itemQty`) VALUES ('"+textNume.getText()+"', '"+textTelefon.getText()+"', '"+textId.getText()+"', '"+textNrbucatiCom.getText()+"')");
				
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
		btnTrimite.setForeground(Color.WHITE);
		btnTrimite.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnTrimite.setBackground(new Color(255, 102, 51));
		btnTrimite.setBounds(705, 497, 175, 41);
		contentPane_1.add(btnTrimite);
		
		textId = new JTextField();
		textId.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textId.setColumns(10);
		textId.setBounds(750, 150, 173, 28);
		contentPane_1.add(textId);
		
		textNume = new JTextField();
		textNume.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textNume.setColumns(10);
		textNume.setBounds(735, 389, 173, 28);
		contentPane_1.add(textNume);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Adresa");
		lblNewLabel_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(663, 395, 64, 22);
		contentPane_1.add(lblNewLabel_1_1_1_1);
		
		textTelefon = new JTextField();
		textTelefon.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textTelefon.setColumns(10);
		textTelefon.setBounds(735, 434, 173, 28);
		contentPane_1.add(textTelefon);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Telefon");
		lblNewLabel_1_1_1_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(663, 440, 64, 22);
		contentPane_1.add(lblNewLabel_1_1_1_2);
		
		
		
		
		
		
	}
}
