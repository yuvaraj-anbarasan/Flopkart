

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Cart extends JPanel 
{
	JLabel Tittle,logo;
	JTextField search;
	JButton s;
	JMenuBar mb;
	JTable cart;

	LogedinPage mainpage;
	
	Cart(LogedinPage page)
	{
		
		mainpage = page;
		setBackground(Color.WHITE);    
		logo=new JLabel(new ImageIcon("d:\\Project-icons\\flop.png"));
		logo.setBounds(180,35,50,50);
		Tittle=new JLabel("Flopkart");		
		//Tittle.addMouseListener(new mainPage(mainpage,this));
		Font myFont=new Font("SANS_SERIF", Font.ITALIC,26);
		Tittle.setFont(myFont);
		Tittle.setBounds(80,40,100,40);
		Tittle.setForeground(Color.WHITE);
		s=new JButton(new ImageIcon("d:\\Project-icons\\search-button.png"));
		s.setBackground(Color.orange);
		s.setBounds(1000, 40, 70, 40);
		search=new JTextField();
		search.setBounds(250, 40, 750, 40);		
		
		String url="jdbc:mysql://Localhost:3306/products?useSSL=false";
		String user="root";
		String password="yuva";
		String p=null,Dc=null,Pname=null;
		int cost,d_charges,total,row=0;
		String[][] data = new String[20][2];
		String column[]={"Product Name","price"}; 
		
		try 
		{
			//1.establish connection
			Connection connect=DriverManager.getConnection(url,user,password);
		
			//2.create a sql query
				Statement mystmt1=connect.createStatement();
				Statement mystmt2=connect.createStatement();
			//3.execute sql query
			ResultSet Price=mystmt1.executeQuery("select price from products.cart;");
			ResultSet pname=mystmt2.executeQuery("select pname from products.cart;");

			while (Price.next() && pname.next()) 
			{	
				
				p=Price.getString("price");
				Pname=pname.getString("pname");
				
					data[row][0]=Pname;
					data[row][1]=p;
				row++;
				if(Pname.equals("arizona aviator sunglasses"))
					break;						
			}
		} catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
		cart=new JTable(data,column);
		cart.setBounds(400,200,400,80);
		cart.setEnabled(true);
	    mb=new JMenuBar();	    	    
		mb.setBackground(Color.BLUE);
		mb.setBounds(0, 0, 1366, 100);
		mb.setLayout(null);
		mb.add(search);mb.add(s);mb.add(Tittle);mb.add(logo);
		
		//cart.setLayout(null);
		add(mb);add(cart);
		setLayout(null);
	}
	
}