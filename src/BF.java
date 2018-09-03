


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
class Login extends JPanel
 {
	String name,pass; 
   JButton SUBMIT;
   JPanel panel;
   JLabel label1,label2,background;
   final JTextField  text1,text2;
   LogedinPage mainpage;
   
   Login(LogedinPage page)
   {
	   
	   //page=new LogedinPage();
	   label1 = new JLabel();
	   //label1.setText("Username:");
	   text1 = new JTextField();
	   //label1.setBounds(450,50,300,50);
	   
	   text1.setBounds(540,196,300,35);
	   label2 = new JLabel();
	   //label2.setText("Password:");
	   text2 = new JPasswordField(15);
	   //label2.setBounds(450,150,300,50);
	   text2.setBounds(540,263,300,33);
	   SUBMIT=new JButton("Login");
	   SUBMIT.setBounds(540,315,300,33);
	   SUBMIT.setBackground(Color.ORANGE);
	   SUBMIT.setForeground(Color.WHITE);
	   mainpage = page;
	   
	   //panel=new JPanel();
	   add(label1);
	   add(text1);
	   add(label2);
	   add(text2);
	   background=new JLabel(new ImageIcon("F:\\Yuvaraj\\Project-icons\\LoginPage.png"));
	   background.setBounds(0, 0, 1366, 786);
	   background.add(SUBMIT);
	   add(background);
	   setLayout(null);
	   //add(panel,BorderLayout.CENTER);
	   SUBMIT.addActionListener(new ActionListener()
	   {
			public void actionPerformed(ActionEvent e)
			{
				name=text1.getText();
				pass=text2.getText();
				
				
				String x=null,y=null;
				String url="jdbc:mysql://Localhost:3306/project?useSSL=false";
				String user="root";
				String password="yuva";
				try 
				{
					//1.establish connection
					Connection connect=DriverManager.getConnection(url,user,password);
				
					//2.create a sql query
						Statement mystmt1=connect.createStatement();
						Statement mystmt2=connect.createStatement();
					//3.execute sql query
					ResultSet Name=mystmt1.executeQuery("select name from project.users ;");
					ResultSet Pass=mystmt2.executeQuery("select Password from project.users ;");					
					while (Name.next() && Pass.next()) 
					{	
						x=Name.getString("name");
						y=Pass.getString("Password");
						if(x.equals(name))
							break;						
					}
				} catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
				if(x.equals(name)&& y.equals(pass))
				{
					if(mainpage.loginStatus!=false)
					{ 
						setVisible(false);
						mainpage.Cart();
					}
					else
					{
						mainpage.setMainPageVisible();
						mainpage.Login.setVisible(false);
						mainpage.welcome.setText("Welcome "+name);
						mainpage.welcome.setBounds(1180, 10, 100, 30);
						//mainpage.p.add()
						mainpage.signup.setVisible(false);
						mainpage.loginStatus=true;
					}
				}
				else
					JOptionPane.showMessageDialog(page,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
				/*open.openname();
				int x = read.readname(name);
				open.openpass();
				int y = read.repassword(pass);
				if (x == 0 && y == 0)
				{
					JOptionPane.showMessageDialog(page,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(x == y)
				{
				mainpage.setMainPageVisible();
				mainpage.Login.setVisible(false);
				mainpage.welcome.setText("Welcome "+name);
				mainpage.welcome.setBounds(1180, 10, 100, 30);
				//mainpage.p.add()
				mainpage.signup.setVisible(false);
				
				}*/
				 
				//mainpage.setContentPane(background);
			}
		}); 
	   
	   //setTitle("LOGIN ");
	   //add(panel);
	   
   }
   
 }
