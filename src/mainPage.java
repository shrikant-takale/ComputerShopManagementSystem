import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class mainPage extends JFrame {
	private Shop panelShop;
	private Item panelItem;
	private customer panelCustomer;
	private Bill panelBill;
	private Employee panelEmployee;
	private JLabel lblExit;
	private JPanel contentPane;
	
	 private Image img_logo=new ImageIcon(mainPage.class.getResource("res/computer.jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
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
	public mainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(0, 13, 240, 532);
		contentPane.add(panelMenu);

		panelShop=new Shop();
		panelShop.setBackground(new Color(255, 250, 250));
		panelCustomer=new customer();
		panelItem=new Item();
		panelEmployee=new Employee();
		panelBill=new Bill();
		
		JPanel paneShop = new JPanel();
		paneShop.setBackground(new Color(255, 250, 250));
		paneShop.setBounds(2, 254, 235, 36);
		paneShop.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuClicked(panelShop);
			}
		});
		panelMenu.setLayout(null);
		panelMenu.add(paneShop);
		paneShop.setLayout(null);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setForeground(Color.BLACK);
		lblShop.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setBounds(79, 13, 56, 16);
		paneShop.add(lblShop);
		
		JPanel paneItem = new JPanel();
		paneItem.setBackground(new Color(255, 250, 250));
		paneItem.setBounds(2, 301, 235, 38);
		paneItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelItem);
			}
		});
		panelMenu.add(paneItem);
		paneItem.setLayout(null);
		
		JLabel lblItems = new JLabel("Item");
		lblItems.setForeground(Color.BLACK);
		lblItems.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setBounds(79, 13, 56, 16);
		paneItem.add(lblItems);
		
		JPanel paneEmployee = new JPanel();
		paneEmployee.setBackground(new Color(255, 250, 250));
		paneEmployee.setBounds(2, 347, 235, 38);
		paneEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelEmployee);
			}
		});
		panelMenu.add(paneEmployee);
		paneEmployee.setLayout(null);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBackground(new Color(255, 250, 250));
		lblEmployee.setForeground(Color.BLACK);
		lblEmployee.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployee.setBounds(81, 13, 96, 16);
		paneEmployee.add(lblEmployee);
		
		JPanel paneCutsomer = new JPanel();
		paneCutsomer.setBackground(new Color(255, 250, 250));
		paneCutsomer.setBounds(2, 399, 235, 38);
		paneCutsomer.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneCutsomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCustomer);
			}
		});
		panelMenu.add(paneCutsomer);
		paneCutsomer.setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setForeground(Color.BLACK);
		lblCustomer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setBounds(85, 13, 84, 16);
		paneCutsomer.add(lblCustomer);
		
		JPanel paneBill = new JPanel();
		paneBill.setBackground(new Color(255, 250, 250));
		paneBill.setForeground(Color.BLACK);
		paneBill.setBounds(2, 444, 235, 44);
		paneBill.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelBill);
			}
		});
		panelMenu.add(paneBill);
		paneBill.setLayout(null);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setForeground(Color.BLACK);
		lblBill.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBill.setBounds(83, 13, 56, 16);
		paneBill.add(lblBill);
		
		JPanel paneSignOut = new JPanel();
		paneSignOut.setBackground(new Color(255, 250, 250));
		paneSignOut.setBounds(2, 491, 235, 38);
		paneSignOut.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you want to sing out?")==0) {
					loginFrame frmLogin=new loginFrame();
					frmLogin.setVisible(true);
					mainPage.this.dispose();
				}
			}
		});
		panelMenu.add(paneSignOut);
		paneSignOut.setLayout(null);
		
		JLabel lblSignout = new JLabel("SignOut");
		lblSignout.setBackground(new Color(176, 224, 230));
		lblSignout.setForeground(Color.BLACK);
		lblSignout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSignout.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignout.setBounds(84, 13, 78, 16);
		paneSignOut.add(lblSignout);
		
		 JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon("E:\\computer.jpg"));
		lbllogo.setBounds(10, 11, 220, 232);
		lbllogo.setIcon(new ImageIcon(img_logo));
		panelMenu.add(lbllogo);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneMainContent.setBounds(249, 13, 900, 532);
		contentPane.add(paneMainContent);
		Toolkit toolkit =getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		paneMainContent.setLayout(new BoxLayout(paneMainContent, BoxLayout.X_AXIS));

		paneMainContent.add(panelShop);
		paneMainContent.add(panelItem);
		paneMainContent.add(panelCustomer);
		paneMainContent.add(panelBill);
		paneMainContent.add(panelEmployee);
		menuClicked(panelShop);
		menuClicked(panelShop);
		
		
		
		lblExit = new JLabel("x");
		lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) {  
					mainPage.this.dispose();
					}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(1140, -2, 20, 16);
		contentPane.add(lblExit);

	}
	
	
	
	public void menuClicked(JPanel panel) {
		panelShop.setVisible(false);
		panelItem.setVisible(false);
		panelCustomer.setVisible(false);
		panelBill.setVisible(false);
		panelEmployee.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	
	private class PanelButtonMouseAdapter extends MouseAdapter
	{
		JPanel panel;
		public  PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			panel.setBackground(new Color(0, 139, 139));
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
		
			panel.setBackground(new Color(47, 79, 79));  
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			panel.setBackground(new Color(0, 0, 205));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		
			panel.setBackground(new Color(0, 139, 139));
		}
	}
}


