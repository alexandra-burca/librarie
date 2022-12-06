package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import operations.Comanda;
import operations.Manage;
import operations.scrieRecenzie;
import operations.veziProduse;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
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
	public UserPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		setTitle("User Page");
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 934, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Librarie");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel.setBounds(45, 11, 847, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(0, 50, 934, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
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
		btnBrowse.setBounds(44, 11, 180, 41);
		panel_1.add(btnBrowse);
		
		JButton btnComanda = new JButton("Comanda");
		btnComanda.setBounds(264, 11, 180, 41);
		panel_1.add(btnComanda);
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
		
		JButton btnVeziRecenziile = new JButton("Vezi recenziile");
		btnVeziRecenziile.setBounds(485, 11, 180, 41);
		panel_1.add(btnVeziRecenziile);
		btnVeziRecenziile.setForeground(Color.WHITE);
		btnVeziRecenziile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziRecenziile.setBackground(new Color(153, 51, 51));
		
		JButton btnScrieORecenzie = new JButton("Scrie o recenzie");
		btnScrieORecenzie.setBounds(703, 11, 180, 41);
		panel_1.add(btnScrieORecenzie);
		btnScrieORecenzie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrieRecenzie r = new scrieRecenzie();
				dispose();
				r.setTitle("Scrie recenzie");
				r.setVisible(true);
				r.setLocationRelativeTo(null);
			}
		});
		btnScrieORecenzie.setForeground(Color.WHITE);
		btnScrieORecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnScrieORecenzie.setBackground(new Color(153, 51, 51));
		
		JLabel lblNewLabel_5 = new JLabel("Bine ati venit!");
		lblNewLabel_5.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(86, 258, 215, 129);
		contentPane.add(lblNewLabel_5);
	}
}
