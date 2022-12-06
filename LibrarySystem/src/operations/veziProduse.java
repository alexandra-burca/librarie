package operations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import login.DBConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class veziProduse extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DBConnection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					veziProduse frame = new veziProduse();
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
	public veziProduse() {
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
		DefaultTableModel model = (DefaultTableModel)table.getModel();
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
		btnBrowse.setForeground(Color.WHITE);
		btnBrowse.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnBrowse.setBackground(new Color(153, 51, 51));
		btnBrowse.setBounds(44, 11, 180, 41);
		panel_1.add(btnBrowse);
		
		
		JButton btnComanda = new JButton("Comanda");
		btnComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comanda c = new Comanda();
				dispose();
				c.setTitle("Comanda");
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		btnComanda.setForeground(Color.WHITE);
		btnComanda.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnComanda.setBackground(new Color(153, 51, 51));
		btnComanda.setBounds(264, 11, 180, 41);
		panel_1.add(btnComanda);
		
		JButton btnVeziRecenziile = new JButton("Vezi recenziile");
		btnVeziRecenziile.setForeground(Color.WHITE);
		btnVeziRecenziile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziRecenziile.setBackground(new Color(153, 51, 51));
		btnVeziRecenziile.setBounds(485, 11, 180, 41);
		panel_1.add(btnVeziRecenziile);
		
		JButton btnScrieORecenzie = new JButton("Scrie o recenzie");
		btnScrieORecenzie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrieRecenzie r = new scrieRecenzie();
				dispose();
				r.setTitle("Comanda");
				r.setVisible(true);
				r.setLocationRelativeTo(null);
			}
		});
		btnScrieORecenzie.setForeground(Color.WHITE);
		btnScrieORecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnScrieORecenzie.setBackground(new Color(153, 51, 51));
		btnScrieORecenzie.setBounds(703, 11, 180, 41);
		panel_1.add(btnScrieORecenzie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 151, 864, 381);
		contentPane_1.add(scrollPane);
		
		DefaultTableModel model;
		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID", "Titlu", "Autor", "Nr bucati", "Pret"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
