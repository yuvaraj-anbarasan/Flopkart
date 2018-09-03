
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
class Mpage  implements MouseListener
{
	LogedinPage mainpage;
	BuyPage bp;
	
	Mpage(LogedinPage p,BuyPage s)
	{
		mainpage = p;
		bp = s;
	}

	

	@Override
	public void mouseClicked(MouseEvent evt) 
	{
		int count = evt.getClickCount();
        if (count == 1)
        {
        	mainpage.MainPageVisible(bp);
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
public class BuyPage extends JPanel 
{
	
	JLabel s1,ConfirmMessage;
	JLabel Tittle,logo,welcome;
	JLabel price,D_charges,Total;
	JTextField search;
	JButton s,cart,pay;
	JMenuBar mb;
	
	LogedinPage mainpage;
	BuyPage(LogedinPage page)
	{
		mainpage = page;
		String url="jdbc:mysql://Localhost:3306/products?useSSL=false";
		String user="root";
		String password="yuva";
		String p=null,Dc=null,Pname=null;
		int cost,d_charges,total;
		
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
			ResultSet dc=mystmt2.executeQuery("select d_charges from products.sunglasses;");
			ResultSet pname=mystmt3.executeQuery("select pname from products.sunglasses;");

			while (Price.next() && dc.next() && pname.next()) 
			{	
				p=Price.getString("price");
				Dc=dc.getString("d_charges");
				Pname=pname.getString("pname");
				if(Pname.equals("arizona aviator sunglasses"))
					break;						
			}
		} catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		cost=Integer.parseInt(p);
		d_charges=Integer.parseInt(Dc);
		total=cost+d_charges;
		String Amount_payable=String.valueOf(total);
		//System.out.println(Pname);
		price=new JLabel();
		price.setText("Rs"+p);
		price.setBounds(1200,310,80,40);	
		D_charges=new JLabel();
		D_charges.setText("Rs"+Dc);
		D_charges.setBounds(1200,348,80,40);	
		Total=new JLabel();
		Total.setText("Rs"+Amount_payable);
		Total.setBounds(1200,416,80,40);
		setBackground(Color.WHITE);
		welcome=new JLabel();	    
		logo=new JLabel(new ImageIcon("d:\\Project-icons\\flop.png"));
		logo.setBounds(180,35,50,50);		
		Tittle=new JLabel("Flopkart");		
		Tittle.addMouseListener(new Mpage(mainpage,this));
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
		pay=new JButton("Pay");
		pay.setBackground(Color.orange);
		pay.setForeground(Color.WHITE);
		pay.setBounds(500,550, 400, 40);
		pay.addActionListener(new ActionListener()
		   {
				public void actionPerformed(ActionEvent ae)
				{
					s1.setVisible(false);
					pay.setVisible(false);
					ConfirmMessage=new JLabel("Order Placed Successfully");
					Font myFont=new Font("SANS_SERIF", Font.ITALIC,46);
					ConfirmMessage.setFont(myFont);
					ConfirmMessage.setBounds(400, 400, 600, 50);	
					add(ConfirmMessage);
				}
		   });
		s1=new JLabel(new ImageIcon("d:\\sunglasses\\s11(background).png"));
		s1.setBounds(0,0, 1366, 786);
		s1.add(pay);
		s1.add(price);s1.add(D_charges);s1.add(Total);
		setLayout(null);
		add(s1);add(mb);
	}
}
