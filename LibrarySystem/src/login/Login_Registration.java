package login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login_Registration extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Registration window = new Login_Registration();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	DBConnection conn;
	
	public Login_Registration() {
		initialize();
		conn = new DBConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Data base connection not available.", "Connection Error",JOptionPane.ERROR_MESSAGE);	
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 102, 102));
		panel.setBounds(0, 0, 584, 73);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Librarie");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel.setBounds(37, 21, 488, 41);
		panel.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBackground(new Color(0, 0, 0));
		lblUser.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(201, 151, 63, 34);
		frame.getContentPane().add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtUser.setBounds(275, 152, 240, 34);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblPassword.setBounds(169, 200, 95, 27);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		txtPassword.setForeground(new Color(0, 0, 0));
		txtPassword.setBounds(275, 197, 240, 34);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUser.getText();
				String password = String.valueOf(txtPassword.getPassword());
				
				if(username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "User or password is empty.", "Login Error",JOptionPane.ERROR_MESSAGE);				
				}	
				else
				{	
					if(username.contentEquals("admin") && password.contentEquals("1234")) {
						adminLogin(username, password);
					}
					else {
						userLogin(username, password);
						
					}	
				}
				
			}

			private void adminLogin(String username, String password) {
				AdminPage a = new AdminPage();
				frame.dispose();
				a.setTitle("Admin Page");
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				
			}

			private void userLogin(String username, String password) {
				Connection dbconn = DBConnection.connectDB();
				
				if(dbconn != null) {
				try {
					PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("Select * from users WHERE username = ? AND password = ?");
					st.setString(1, username);
					st.setString(2, password);
					ResultSet res = st.executeQuery();
					if(res.next()) {
						//display next page
						UserPage u = new UserPage();
						frame.dispose();
						u.setTitle("User Page");
						u.setVisible(true);
						u.setLocationRelativeTo(null);
						
					} else {
						JOptionPane.showMessageDialog(null, "User does not exist.", "Login Error",JOptionPane.ERROR_MESSAGE);
						}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}else {
					System.out.println("Connection not available.");
					}					
			}
			

		});
		
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(153, 51, 51));
		btnLogin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnLogin.setBounds(241, 262, 131, 47);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register r = new Register();
				//frame.dispose();
				r.setTitle("Register");
				r.setVisible(true);
				r.setLocationRelativeTo(null);
				
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnRegister.setBackground(new Color(204, 153, 102));
		btnRegister.setBounds(400, 262, 131, 47);
		frame.getContentPane().add(btnRegister);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
