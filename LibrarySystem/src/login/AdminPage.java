package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import operations.Manage;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

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
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
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
		
		JButton btnNewButton = new JButton("Manage products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage m = new Manage();
				dispose();
				m.setTitle("Manage stock");
				m.setVisible(true);
				m.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 51, 51));
		btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnNewButton.setBounds(58, 11, 210, 41);
		panel_1.add(btnNewButton);
		
		JButton btnVeziComenzile = new JButton("Vezi comenzile");
		btnVeziComenzile.setForeground(new Color(255, 255, 255));
		btnVeziComenzile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziComenzile.setBackground(new Color(153, 51, 51));
		btnVeziComenzile.setBounds(365, 11, 210, 41);
		panel_1.add(btnVeziComenzile);
		
		JButton btnVeziRecenzii = new JButton("Vezi recenzii");
		btnVeziRecenzii.setForeground(new Color(255, 255, 255));
		btnVeziRecenzii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVeziRecenzii.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
		btnVeziRecenzii.setBackground(new Color(153, 51, 51));
		btnVeziRecenzii.setBounds(653, 11, 210, 41);
		panel_1.add(btnVeziRecenzii);
	}

}
