package operations;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.DBConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import login.DBConnection;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

public class scrieRecenzie extends JFrame {

	private JPanel contentPane;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scrieRecenzie frame = new scrieRecenzie();
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
	
	public scrieRecenzie() {
		initialize();
		conn = new DBConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Data base connection not available.", "Connection Error",JOptionPane.ERROR_MESSAGE);	
			
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
		btnBrowse.setBounds(45, 11, 180, 41);
		panel_1.add(btnBrowse);
		
		JButton btnComanda = new JButton("Comanda");
		btnComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comanda c = new Comanda();
				dispose();
				c.setTitle("Produse");
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		btnComanda.setForeground(Color.WHITE);
		btnComanda.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnComanda.setBackground(new Color(153, 51, 51));
		btnComanda.setBounds(265, 11, 180, 41);
		panel_1.add(btnComanda);
		
		JButton btnVeziRecenziile = new JButton("Vezi recenziile");
		btnVeziRecenziile.setForeground(Color.WHITE);
		btnVeziRecenziile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziRecenziile.setBackground(new Color(153, 51, 51));
		btnVeziRecenziile.setBounds(486, 11, 180, 41);
		panel_1.add(btnVeziRecenziile);
		
		JButton btnScrieORecenzie = new JButton("Scrie o recenzie");
		btnScrieORecenzie.setForeground(Color.WHITE);
		btnScrieORecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnScrieORecenzie.setBackground(new Color(153, 51, 51));
		btnScrieORecenzie.setBounds(704, 11, 180, 41);
		panel_1.add(btnScrieORecenzie);
		
		JLabel lblNewLabel_1 = new JLabel("ID Carte");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 155, 99, 27);
		contentPane_1.add(lblNewLabel_1);
		
		textID = new JTextField();
		textID.setBounds(120, 156, 120, 27);
		contentPane_1.add(textID);
		textID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rating");
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(33, 204, 68, 27);
		contentPane_1.add(lblNewLabel_1_1);
		
		String[] rating = { "1", "2", "3", "4", "5" };
		JComboBox Rating = new JComboBox(rating);
		Rating.setMaximumRowCount(5);
		Rating.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		Rating.setBounds(120, 205, 120, 27);
		contentPane_1.add(Rating);
		
		JTextPane textRecenzie = new JTextPane();
		textRecenzie.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textRecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		textRecenzie.setBounds(49, 286, 623, 230);
		contentPane_1.add(textRecenzie);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Recenzia dumneavoastra:");
		lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(33, 242, 241, 27);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JButton btnTrimite = new JButton("Trimite");
		btnTrimite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection dbconn = DBConnection.connectDB();
				PreparedStatement st = null;
				try {
					st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO `recenzii` (`bookID`, `rating`, `textRecenzie`) VALUES ('"+Integer.parseInt(textID.getText())+"', '"+Integer.parseInt((String) Rating.getSelectedItem())+"', '"+textRecenzie.getText()+"')");
					JOptionPane.showMessageDialog(null, "Recenzia a fost trimisa cu succes!", "Trimis",JOptionPane.INFORMATION_MESSAGE);	
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
				
				try {
					int res = st.executeUpdate();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
								
			}
		});
		btnTrimite.setForeground(Color.WHITE);
		btnTrimite.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnTrimite.setBackground(new Color(255, 99, 71));
		btnTrimite.setBounds(715, 475, 131, 41);
		contentPane_1.add(btnTrimite);
	
		
	}
}
