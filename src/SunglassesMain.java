
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
class mainPage  implements MouseListener
{
	LogedinPage mainpage;
	SunglassesMain Sunglasses;
	
	mainPage(LogedinPage p,SunglassesMain s)
	{
		mainpage = p;
		Sunglasses = s;
	}

	

	@Override
	public void mouseClicked(MouseEvent evt) 
	{
		int count = evt.getClickCount();
        if (count == 1)
        {
        	mainpage.MainPageVisible(Sunglasses);
        }
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
public class SunglassesMain extends JPanel 
{
	
	JLabel s1;
	JLabel Tittle,logo,welcome;
	JTextField search;
	JButton s,cart,addcart,Buynow;
	JMenuBar mb;
	
	LogedinPage mainpage;
	SunglassesMain(LogedinPage page)
	{
		mainpage = page;		
		setBackground(Color.WHITE);
		welcome=new JLabel();	    
		logo=new JLabel(new ImageIcon("d:\\Project-icons\\flop.png"));
		logo.setBounds(180,35,50,50);
		addcart=new JButton("Add to cart");
		addcart.setBounds(1000,200,300,50);
		addcart.setBackground(Color.orange);
		addcart.addActionListener(new ActionListener()
		   {
				public void actionPerformed(ActionEvent e)
				{
					String url="jdbc:mysql://Localhost:3306/products?useSSL=false";
					String user="root";
					String password="yuva";
					String p=null,Pid=null,Pname=null;
					int cost,d_charges,total,column=2,row=0;
					String[][] cart = null;
					if(mainpage.loginStatus==true)
					{
						setVisible(false);
						
						try 
						{
							//1.establish connection
							Connection connect=DriverManager.getConnection(url,user,password);
						
							//2.create a sql query
							
							Statement mystmt1=connect.createStatement();
							Statement mystmt2=connect.createStatement();
							Statement mystmt3=connect.createStatement();
							
							//3.execute sql query
							ResultSet Price=mystmt1.executeQuery("select price from products.sunglasses;");
							ResultSet pname=mystmt2.executeQuery("select pname from products.sunglasses;");
							ResultSet pid=mystmt3.executeQuery("select pid from products.sunglasses;");

							while (Price.next() && pname.next() && pid.next()) 
							{	
								
								p=Price.getString("price");
								Pname=pname.getString("pname");
								Pid=pid.getString("pid");
								if(Pname.equals("arizona aviator sunglasses"))
									break;						
							}
							
							
							Statement mystmt=connect.createStatement();
							String sql="insert into products.cart"
									+"(pid,pname,price)"
									+"values('"+Pid+"','"+Pname+"','"+p+"')";
							
							mystmt.executeUpdate(sql);
						} catch (SQLException ex) 
						{
							ex.printStackTrace();
						}
						
						mainpage.Cart();	
					}
					else
					{
						setVisible(false);
						mainpage.buyToLogin();
					}
				}
			}); 
		Buynow=new JButton("Buy now");
		Buynow.setBounds(1000,300,300,50);
		Buynow.setBackground(Color.orange);
		Buynow.addActionListener(new ActionListener()
		   {
				public void actionPerformed(ActionEvent e)
				{
					if(mainpage.loginStatus==true)
					{
						mainpage.BuyPageVisible();
						mainpage.Login.setVisible(false);
						
						mainpage.welcome.setBounds(1180, 10, 100, 30);
						//mainpage.p.add()
						mainpage.signup.setVisible(false);
					}
					else
					{
						setVisible(false);
						mainpage.buyToLogin();
					}
				}
			}); 
		Tittle=new JLabel("Flopkart");		
		Tittle.addMouseListener(new mainPage(mainpage,this));
		Font myFont=new Font("SANS_SERIF", Font.ITALIC,26);
		Tittle.setFont(myFont);
		Tittle.setBounds(80,40,100,40);
		Tittle.setForeground(Color.WHITE);
		s=new JButton(new ImageIcon("d:\\Project-icons\\search-button.png"));
		s.setBackground(Color.orange);
		s.setBounds(1000, 40, 70, 40);
		cart=new JButton(new ImageIcon("d:\\Project-icons\\cart1.png"));
		cart.setBackground(Color.BLUE);
		cart.setForeground(Color.WHITE);
		cart.setText(" CART");
		cart.setBounds(1080,40,120,40);
		search=new JTextField();
		search.setBounds(250, 40, 750, 40);		
	    mb=new JMenuBar();	    	    
		mb.setBackground(Color.BLUE);
		mb.setBounds(0, 0, 1366, 100);
		mb.setLayout(null);
		mb.add(search);mb.add(s);mb.add(cart);mb.add(Tittle);mb.add(logo);mb.add(welcome);
		s1=new JLabel(new ImageIcon("d:\\sunglasses\\s1(background).png"));
		s1.setBounds(0,0, 1366, 786);
		s1.add(addcart);s1.add(Buynow);
		setLayout(null);
		add(s1);add(mb);
	}
	/*public static void main(String[] args) 
	{
		
		new SunglassesMain();
	}*/

}
