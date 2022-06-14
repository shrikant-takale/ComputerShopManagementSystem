import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
public class Item extends JPanel {
	private JTextField txtSrno;
	private JTextField txtPrice;
	private JTextField txtSearch;
    private JComboBox<String>cmbCategories;
	private JComboBox<Integer>cmbQuantity;
	private JComboBox <String>cmbName;
	Connection con;
	int Srno;
	
	private JTable tblItem;
	private JTextField txtDate1;
	private JTextField txtDate2;
	/**
	 * Create the panel.
	 */
	public Item() {
		setBounds(249, 16, 980, 550);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 5, 955, 46);
		add(panel);
		getMySqLConnection();
		JLabel lblItemform = new JLabel("ItemForm");
		lblItemform.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemform.setForeground(Color.BLACK);
		lblItemform.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblItemform.setBounds(374, 7, 120, 32);
		panel.add(lblItemform);
		
		JPanel panel_Menus = new JPanel();
		panel_Menus.setBackground(new Color(240, 128, 128));
		panel_Menus.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Menus.setLayout(null);
		panel_Menus.setForeground(Color.BLACK);
		panel_Menus.setBounds(10, 54, 955, 108);
		add(panel_Menus);
		
		JLabel label_1 = new JLabel("SrNo:-");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(19, 9, 55, 20);
		panel_Menus.add(label_1);
		
		JLabel lblItemcategories = new JLabel("Compony:-");
		lblItemcategories.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemcategories.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemcategories.setForeground(Color.BLACK);
		lblItemcategories.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblItemcategories.setBounds(439, 7, 105, 20);
		panel_Menus.add(lblItemcategories);
		
		JLabel lblItemname = new JLabel("I-Name:-");
		lblItemname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemname.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemname.setForeground(Color.BLACK);
		lblItemname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblItemname.setBounds(227, 9, 80, 20);
		panel_Menus.add(lblItemname);
		
		JLabel lblItemprice = new JLabel("Price:-");
		lblItemprice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblItemprice.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemprice.setForeground(Color.BLACK);
		lblItemprice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblItemprice.setBounds(14, 43, 71, 20);
		panel_Menus.add(lblItemprice);
		
		txtSrno = new JTextField();
		txtSrno.setHorizontalAlignment(SwingConstants.LEFT);
		txtSrno.setEditable(false);
		txtSrno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSrno.setColumns(10);
		txtSrno.setBounds(89, 7, 130, 26);
		panel_Menus.add(txtSrno);
		
		txtPrice = new JTextField();
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(95, 40, 122, 26);
		panel_Menus.add(txtPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:-");
		lblQuantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblQuantity.setBounds(703, 10, 80, 20);
		panel_Menus.add(lblQuantity);
		
		cmbQuantity = new JComboBox();
        cmbQuantity.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		cmbQuantity.setSelectedItem(null);
		cmbQuantity.setBounds(788, 6, 158, 26);
		panel_Menus.add(cmbQuantity);
		
		cmbCategories = new JComboBox();
		cmbCategories.setModel(new DefaultComboBoxModel(new String[] {"Dell", "HP", "LENOVO", "Apple"}));//COMPNY NAME<-------
		cmbCategories.setSelectedItem(null);
		cmbCategories.setBounds(569, 6, 129, 26);
		panel_Menus.add(cmbCategories);
		
		cmbName = new JComboBox();
		cmbName.setBounds(307, 7, 125, 26);
		cmbName.setModel(new DefaultComboBoxModel(new String[] {"CPU", "Mouse", "Printer", "Scanner", "Moniter","Pendrive","Motherboard"}));//z
		cmbName.setSelectedItem(null);
		panel_Menus.add(cmbName);
		
		JPanel panel_Date = new JPanel();
		panel_Date.setBounds(237, 38, 712, 67);
		panel_Date.setVisible(false);
		panel_Menus.add(panel_Date);
		panel_Date.setLayout(null);
		
		txtDate1 = new JTextField();
		txtDate1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDate1.setColumns(10);
		txtDate1.setBounds(6, 6, 122, 26);
		panel_Date.add(txtDate1);
		
		txtDate2 = new JTextField();
		txtDate2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDate2.setColumns(10);
		txtDate2.setBounds(6, 38, 122, 26);
		panel_Date.add(txtDate2);
		
		JButton btnDay = new JButton("Day");
		btnDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Query="SELECT * FROM items WHERE Date IN ("+txtDate1.getText()+")";
				fetchJobs(Query);
			}
		});
		btnDay.setForeground(Color.BLACK);
		btnDay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDay.setBounds(134, 4, 87, 18);
		panel_Date.add(btnDay);
		
		JButton btnMonth = new JButton("Month");
		btnMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Query="SELECT * FROM items WHERE YEAR(Date) = "+txtDate1.getText()+" AND MONTH(Date) ="+txtDate2.getText();
				fetchJobs(Query);
			}
		});
		btnMonth.setForeground(Color.BLACK);
		btnMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnMonth.setBounds(134, 24, 87, 18);
		panel_Date.add(btnMonth);
		
		JButton btnYear = new JButton("Year");
		btnYear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Query="SELECT * FROM items WHERE YEAR(Date) =" +txtDate1.getText();
				fetchJobs(Query);
			}
		});
		btnYear.setForeground(Color.BLACK);
		btnYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnYear.setBounds(134, 44, 87, 18);
		panel_Date.add(btnYear);
		
		JButton btnClear = new JButton(".");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDate1.setText("");
				txtDate2.setText("");
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnClear.setBounds(225, 20, 32, 31);
		panel_Date.add(btnClear);
		
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBackground(new Color(240, 128, 128));
		panel_Search.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Search.setLayout(null);
		panel_Search.setBounds(10, 223, 955, 40);
		add(panel_Search);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String Query="SELECT * FROM items WHERE Item_Name LIKE '%" + txtSearch.getText() + "%'";
				fetchJobs(Query);
			}
		});
		txtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSearch.setColumns(10);
		txtSearch.setBounds(142, 7, 800, 26);
		panel_Search.add(txtSearch);
		
		JLabel lblSearchitem = new JLabel("SearchItem:-");
		lblSearchitem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearchitem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchitem.setForeground(Color.BLACK);
		lblSearchitem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSearchitem.setBounds(29, 10, 113, 20);
		panel_Search.add(lblSearchitem);
		
		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Table.setLayout(null);
		panel_Table.setBounds(-19, 271, 957, 279);
		add(panel_Table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 14, 930, 250);
		panel_Table.add(scrollPane_1);
		
		tblItem = new JTable();
		scrollPane_1.setViewportView(tblItem);
		
		JPanel panel_Buttons = new JPanel();
		panel_Buttons.setBackground(new Color(240, 128, 128));
		panel_Buttons.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Buttons.setLayout(null);
		panel_Buttons.setBounds(9, 170, 956, 50);
		add(panel_Buttons);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// SAVE BUTTON
		        String Name=cmbName.getSelectedItem().toString();
		        int Quantity=Integer.parseInt(cmbQuantity.getSelectedItem().toString());
		        String Categories=cmbCategories.getSelectedItem().toString();
		       
		        double Price=Double.parseDouble(txtPrice.getText());
		       
		       
		        
		        //int Price1=Price;
		        String Query1="SELECT * FROM ITEMS";
		        
               // Price=(Price1 * Quantity * Gram);
                //txtPrice.setText(String.valueOf(Price));
		        
		        String Query="insert into items(Item_Name,Item_Categories,Item_Quantity,Item_Price,Date,Time) values (?,?,?,?,?,?)";				
		PreparedStatement ps=null;
		if(Name.length()!=0 ) {
		//Obtaining current date
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		String date=formatter.format(calendar.getTime());
		//Obtaining Current Time
		formatter=new SimpleDateFormat("HH:mm:ss");
		String time=formatter.format(calendar.getTime());
		try{            ps=con.prepareStatement(Query);
		                ps.setString(1, Name);
		                ps.setString(2, Categories);
		                ps.setInt(3, Quantity);
		                ps.setDouble(4, Price);
		                ps.setString(5, date);
		                ps.setString(6, time);
		                ps.execute();
		                fetchJobs(Query1);
		                JOptionPane.showMessageDialog(null, "Insertion Successfully.....");
		                
		            }catch(SQLException e){
		                System.out.println(e.getMessage());
		            }
				}
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(210, 4, 115, 40);
		panel_Buttons.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//txtSrno.setText(rs.getString("SrNo"));
				 try{
				 String Name=cmbName.getSelectedItem().toString();
				 String Categories=cmbCategories.getSelectedItem().toString();
			     int Quantity=Integer.parseInt(cmbQuantity.getSelectedItem().toString());
			     double Price=Double.parseDouble(txtPrice.getText());
			    // int Price1=Price;
			     
			     //txtPrice.setText(String.valueOf(Price));
			     
			    
			     String Query="SELECT * FROM ITEMS";
		         PreparedStatement ps=con.prepareStatement("update Items set Item_Name=?,Item_Categories=?,Item_Quantity=?,Item_Price=? where SrNo=?");
		         ps.setString(1, Name);
		         ps.setString(2, Categories);
		         ps.setInt(3, Quantity);
		         ps.setDouble(4, Price);
		         ps.setInt(5, Srno);
		         ps.execute();
		         fetchJobs(Query);
		         JOptionPane.showMessageDialog(null, "Update Successfully.....");
		         Reset();
				 }
			        catch(SQLException ex){
			        }
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(340, 5, 115, 40);
		panel_Buttons.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					
					String Query="Select * From Items";
			        PreparedStatement ps=con.prepareStatement("delete from Items where SrNo=?");
			         ps.setInt(1,Srno);
			         ps.execute();
			        fetchJobs(Query);
			        JOptionPane.showMessageDialog(null, "Delete Successfully.....");
			        Reset();
			        }
			        catch(SQLException e){}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(466, 5, 115, 40);
		panel_Buttons.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//String Query="Select * From Items";
				String Query="SELECT * FROM ITEMS";							
						
				Reset();
	            fetchJobs(Query);
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBounds(596, 5, 115, 40);
		panel_Buttons.add(btnReset);
		
		JButton btnDate_Report = new JButton("DateReport");
		btnDate_Report.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnDate_Report.setForeground(Color.BLACK);
		btnDate_Report.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDate_Report.setBounds(726, 4, 125, 40);
		panel_Buttons.add(btnDate_Report);
		setVisible(true);
		
		tblItem = new JTable();
		scrollPane_1.setViewportView(tblItem);
		tblItem.addMouseListener(new MouseAdapter(){
		       @Override
		       public void mouseClicked(MouseEvent e){
		       if(e.getClickCount()==2){
		           JTable target=(JTable)e.getSource();
		           int row=target.getSelectedRow();
		           Srno=Integer.parseInt(tblItem.getValueAt(row,0).toString());
		           loadData();  
		       }
		       }
		   });

	}
			public void getMySqLConnection(){
		    try{
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shrikantvidya","root","shrikant@123");
			    }catch(SQLException e){
			    System.out.println("SQL Exception:"+e.getMessage());
			    }
		    }
			public void fetchJobs(String Query){
				 //This funcion runs when tab view jobs selected or refresh button clicked
				 //Fetch jos on Jtable
				   String Query1=Query;
				 Object [][]data=null;
				 try{
				 PreparedStatement ps=con.prepareStatement(Query1);
				 int rowCount=0;
				 ResultSet rs=ps.executeQuery();
				 while(rs.next()){
				 rowCount ++;
				 }
				 data=new Object[rowCount][7];
				 rs=ps.executeQuery();
				 rowCount=0;
				
				 while(rs.next()){
				 data[rowCount][0]=rs.getInt("SrNo");
				 data[rowCount][1]=rs.getString("Item_Name");
				 data[rowCount][2]=rs.getString("Item_Categories");
				 data[rowCount][3]=rs.getString("Item_Quantity"); 
				 data[rowCount][4]=rs.getDouble("Item_Price");
				 data[rowCount][5]=rs.getDate("Date");
				 data[rowCount][6]=rs.getTime("Time");
				 rowCount ++;
				 
				 }
				
				 
				 }catch(Exception e){
				 e.printStackTrace();
				 }
				 String [] colNames ={"SrNo","Item_Name","Item_Categories","Item_Quantity","Item_Price","Date","Time"};
				 setTableData(data,colNames);
				 } 
			//Method setTableData
			   public void setTableData(Object[][] data,String[] colNames){
			   DefaultTableModel dtm=new DefaultTableModel(data,colNames){
			   @Override 
			   public boolean isCellEditable(int row,int column)//this makes all columns non-editable
			   {
			   return false;
			   }
			   }; 
			   tblItem.setModel(dtm);
			   }
			   public void loadData(){
			    	 try{
			    		 String Query="select * from items where SrNo=?";
			    	     PreparedStatement ps=con.prepareStatement(Query);
			    	     ps.setInt(1,Srno);
			    	     ResultSet rs=ps.executeQuery();
			    	     if (rs.next()){
			    	     txtSrno.setText(rs.getString("SrNo"));
			    	     cmbName.setSelectedItem((rs.getString("Item_Name")));
			    	     cmbCategories.setSelectedItem((rs.getString("Item_Categories")));
			    	     cmbQuantity.setSelectedItem((rs.getString("Item_Quantity")));
			    	     txtPrice.setText(rs.getString("Item_Price"));
			    	     
			    	     //jLabel5.setText("  Date: "+rs.getDate("date"));
			    	     //jLabel6.setText("  Time: "+rs.getTime("time"));
			    	     /* int itemIndex=0;
			    	     String status=rs.getString("status");
			    	     if(status.equals("Pending"))
			    	     itemIndex=0;
			    	      else if(status.equals("Done"))
			    	      itemIndex=1;
			    	     else 
			    	      itemIndex=2;
			    	      //jComboBox1.setSelectedIndex(itemIndex); 
			    	     */
			    	     }
			    	 }
			    	 catch (SQLException e){
			    	 System.out.println("Sql Exception in SELECT");
			    	 }
			    	 }
				 public void Reset() {
						//txtSrno.setText("");
					 cmbName.setSelectedItem(null);
					 cmbCategories.setSelectedItem(null);
					 cmbQuantity.setSelectedItem(null);
					 
					 
					 txtPrice.setText("");
				 }  
				 public void check(String Categories,int Purity,int Quantity,int Gram) {
					 String Categories1=Categories;
					 int Purity1=Purity;
					 int Quantity1=Quantity; 
					 double Price;
					 int Gram1= Gram;
						 if(Categories1=="Gold" && Purity1==24){
							 // int Price1=Price;
							 double g1=4804.00;
						     Price=( Quantity1 * Gram1 * g1);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("4804.00")); 
						 }
						 else if(Categories1=="Gold" && Purity1==22) {
							 // int Price1=Price;
							 double g2=4730.00;
						     Price=(Quantity1 * Gram1 * g2);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("4730.00")); 
						 }
						 else if(Categories1=="Silver" && Purity1==24) {
							// int Price1=Price;
							 double g3=70.00;
						     Price=( Quantity1 * Gram1 * g3);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("70.00")); 
						 }
						 else if(Categories1=="Silver" && Purity1==22) {
							// int Price1=Price;
							 double g4=67.50;
						     Price=(Quantity1 * Gram1 * g4);
						     //txtPrice.setText(String.valueOf(Price));
							 txtPrice.setText(String.valueOf("67.50")); 
						 }
						 else if(Categories1=="Platinum" && Purity1==24) {
							// int Price1=Price;
							 double g5=2583.00;
						     Price=(Quantity1 * Gram1 * g5);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("2583.00")); 
						 }
						 else if(Categories1=="Platinum" && Purity1==22) {
							// int Price1=Price;
							 double g6=1583.00;
						     Price=(Quantity1 * Gram1 * g6);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("1583.00")); 
						 }
						 else if(Categories1=="Diamond" && Purity1==1) {
							// int Price1=Price;
							 double g7=50000.00;
						     Price=(Quantity1 * Gram1 * g7);
						     txtPrice.setText(String.valueOf(Price));
							// txtPrice.setText(String.valueOf("50000.00")); 
						 }
						 else if(Categories1=="Diamond" && Purity1==2) {
							// int Price1=Price;
							 double g8=5000.00;
						     Price=( Quantity1 * Gram1 * g8);
						     txtPrice.setText(String.valueOf(Price));
							 //txtPrice.setText(String.valueOf("5000.00")); 
						 }
						 else {
							System.out.println("not allowed");
						 }
				 }
}			
