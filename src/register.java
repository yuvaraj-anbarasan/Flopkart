
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
class Reg extends JPanel implements ActionListener
{
	String name,Emailid,Pass,Mobnum;
	JPanel p;
	JTextField t1,t2,t3,t4;
	JLabel background;
	JButton login;
	LogedinPage mainpage;
	Reg(LogedinPage page)
	{
		mainpage=page;
		
		login=new JButton("Login");
		login.setBounds(528,445,320,33);				
		t1=new JTextField();
		
		t1.setBounds(528,188,320,33);		
		t2=new JTextField();
		t2.setBounds(528,258,320,33);		
		t3=new JTextField();
		t3.setBounds(528,328,320,33);		
		t4=new JPasswordField(15);
		String pass = t4.getText();
		t4.setBounds(528,395,320,33);
		
		login.setBackground(Color.ORANGE);
		login.setForeground(Color.WHITE);
		background=new JLabel(new ImageIcon("D:\\Project-icons\\RegPage.png"));
		background.setBounds(0, 0, 1366, 786);
		background.add(login);background.add(t1);background.add(t2);background.add(t3);background.add(t4);
		setLayout(null);
		add(background);
		add(t1);add(t2);add(t3);add(t4);
		//add(login);
		//add(p,BorderLayout.CENTER);
		login.addActionListener(new ActionListener()
		   {
				public void actionPerformed(ActionEvent e)
				{
					//open.openname();
				    name=t1.getText();
					//write.writename(name);
					Mobnum=t2.getText();
					Emailid=t3.getText();
					Pass = t4.getText();
					//open.openpass();
					//write.writepassword(Pass);
					
					String url="jdbc:mysql://Localhost:3306/project?useSSL=false";
					String user="root";
					String password="yuva";
					try 
					{
						//1.establish connection
						Connection connect=DriverManager.getConnection(url,user,password);
					
						//2.create a sql query
							Statement mystmt=connect.createStatement();
						//3.execute sql query
							String sql="insert into users"
									+"(name,MobNum,Email,Password)"
									+"values('"+name+"','"+Mobnum+"','"+Emailid+"','"+Pass+"')";					
						//4.process the result set			
							mystmt.executeUpdate(sql);
					} catch (SQLException ex) 
					{
						ex.printStackTrace();
					}
					
					mainpage.RegToMainPageVisible();
					mainpage.Login.setVisible(false);
					mainpage.welcome.setText("Welcome "+name);
					mainpage.welcome.setBounds(1180, 10, 130, 30);
					//mainpage.p.add()
					mainpage.signup.setVisible(false);
					//mainpage.setContentPane(background);
				}
			}); 
		//add(p);
	}
	
	public void enter()
	{
		Scanner in=new Scanner(System.in);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
