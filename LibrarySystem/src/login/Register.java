package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textUsername;
	private JTextField textPassword;
	protected Window frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204, 102, 102));
		panel.setBounds(0, 0, 584, 73);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Librarie");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel.setBounds(37, 21, 488, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Creaza un cont nou");
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(34, 87, 209, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nume");
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(139, 143, 64, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(139, 187, 95, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(139, 231, 95, 33);
		contentPane.add(lblNewLabel_4);
		
		textName = new JTextField();
		textName.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textName.setBounds(260, 143, 172, 33);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textUsername.setColumns(10);
		textUsername.setBounds(260, 187, 172, 33);
		contentPane.add(textUsername);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		textPassword.setColumns(10);
		textPassword.setBounds(260, 231, 172, 33);
		contentPane.add(textPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String username = textUsername.getText();
				String password = textPassword.getText();
				
				if(name.isEmpty() || username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Completati toate campurile.", "Login Error",JOptionPane.ERROR_MESSAGE);				
				}
				else {
					userRegister(name, username, password);
				}
				
			}

			private void userRegister(String name, String username, String password) {
				Connection dbconn = DBConnection.connectDB();
				
				if(dbconn != null) {
				try {
					PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO users (name, username, password) VALUES(?,?,?)");
					
					st.setString(1, name);
					st.setString(2, username);
					st.setString(3, password);
					
					int res = st.executeUpdate();
		
					JOptionPane.showMessageDialog(null, "Contul a fost creat.", "Succes!",JOptionPane.INFORMATION_MESSAGE);
								
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}else {
					System.out.println("Connection not available.");
					}					
				
			}
		});
		btnRegister.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnRegister.setBackground(new Color(233, 150, 122));
		btnRegister.setBounds(320, 288, 157, 40);
		contentPane.add(btnRegister);
		
		JButton btnBackLogin = new JButton("Back to Login");
		btnBackLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				///Login_Registration l = new Login_Registration();
				//l.setTitle("Login Page");
				//l.setVisible(true);
			}
		});
		btnBackLogin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnBackLogin.setBackground(new Color(153, 102, 153));
		btnBackLogin.setBounds(94, 288, 157, 40);
		contentPane.add(btnBackLogin);
	}
}
