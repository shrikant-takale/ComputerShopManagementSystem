import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.LineBorder;
import java.sql.*;

public class loginFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	private Image img_username = new ImageIcon(loginFrame.class.getResource("res/ad2.png")).getImage()
			.getScaledInstance(82, 59, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(loginFrame.class.getResource("res/LockVidya.png")).getImage()
			.getScaledInstance(82, 60, Image.SCALE_SMOOTH);
	private Image img_log_in = new ImageIcon(loginFrame.class.getResource("res/Key.jpg")).getImage()
			.getScaledInstance(100, 70, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			loginFrame dialog = new loginFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public loginFrame() {
		setUndecorated(true);
		setBounds(100, 100, 727, 535);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 727, 564);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(211, 211, 211)));
		panelMain.setOpaque(false);
		panelMain.setBounds(169, 136, 368, 290);
		contentPanel.add(panelMain);
		panelMain.setLayout(null);

		JPanel panelUsername = new JPanel();
		panelUsername.setOpaque(false);
		panelUsername.setBorder(new LineBorder(new Color(211, 211, 211)));
		panelUsername.setBounds(4, 2, 362, 70);
		panelMain.add(panelUsername);
		panelUsername.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setOpaque(false);
		txtUsername.setForeground(Color.BLUE);
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().contentEquals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
		});
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(9, 22, 252, 33);
		panelUsername.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIconUsername.setBounds(267, 0, 92, 70);
		lblIconUsername.setIcon(new ImageIcon(img_username));
		panelUsername.add(lblIconUsername);

		JPanel panelPassword = new JPanel();
		panelPassword.setOpaque(false);
		panelPassword.setBorder(new LineBorder(new Color(211, 211, 211)));
		panelPassword.setLayout(null);
		panelPassword.setBounds(4, 92, 364, 70);

		panelMain.add(panelPassword);

		txtPassword = new JPasswordField();
		txtPassword.setOpaque(false);
		txtPassword.setForeground(new Color(0, 0, 255));
		txtPassword.setEchoChar((char) 0);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().contentEquals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char) 0);
				}
			}
		});
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPassword.setText("Password");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(10, 17, 253, 33);
		panelPassword.add(txtPassword);

		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIconPassword.setBounds(269, 0, 92, 70);
		lblIconPassword.setIcon(new ImageIcon(img_password));
		panelPassword.add(lblIconPassword);

		final JLabel lblLoginMessage = new JLabel("");
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setForeground(Color.RED);
		lblLoginMessage.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLoginMessage.setBounds(4, 165, 366, 48);
		panelMain.add(lblLoginMessage);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setOpaque(false);
		panel_1_2.setBorder(new LineBorder(new Color(211, 211, 211)));
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * if(txtUsername.getText().equals("admin") &&
				 * txtPassword.getText().equals("admin123")) { // if user inputs are correct
				 * lblLoginMessage.setText("");
				 * JOptionPane.showMessageDialog(null,"Login successfull"); } else
				 * if(txtUsername.getText().equals("") ||
				 * txtUsername.getText().equals("Username") || txtPassword.getText().equals("")
				 * || txtPassword.getText().equals("Password")){
				 * lblLoginMessage.setText("Plase input all requirements!"); } else {
				 * lblLoginMessage.setText("Username and Password didn't match"); }
				 */
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelleryshopmanagement",
							"root", "shrikant@123");
					Statement stmt = con.createStatement();
					String sql = "Select * from FramLogin where Username='" + txtUsername.getText() + "' and Password='"
							+ txtPassword.getText().toString() + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
			
						lblLoginMessage.setText("");
						JOptionPane.showMessageDialog(null, "Login Successfully.....");
						loginFrame.this.dispose();
						mainPage frm = new mainPage();
						frm.setVisible(true);
					} else if (txtUsername.getText().equals("") || txtUsername.getText().equals("Username")
							|| txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
						lblLoginMessage.setText("Plase input all requirements!");
					} else {
						lblLoginMessage.setText("Username and Password is Invalid");
						con.close();
					}
				} catch (Exception ex) {
					System.out.println("SQL Exception:" + ex.getMessage());
				}

			}

		});
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(4, 217, 364, 70);
		panelMain.add(panel_1_2);

		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIconLogin.setBounds(12, 3, 100, 64);
		lblIconLogin.setIcon(new ImageIcon(img_log_in));
		panel_1_2.add(lblIconLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLogin.setBounds(162, 6, 82, 60);
		panel_1_2.add(lblLogin);

		final JLabel lblX = new JLabel("x");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?",
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					loginFrame.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.BLUE);
		lblX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblX.setBounds(687, 5, 33, 24);
		contentPanel.add(lblX);

		JLabel lblX_1 = new JLabel("");
		lblX_1.setIcon(new ImageIcon(loginFrame.class.getResource("/res/background.jpg")));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setForeground(Color.BLUE);
		lblX_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblX_1.setBounds(0, 0, 727, 534);
		contentPanel.add(lblX_1);

		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

	}
}
