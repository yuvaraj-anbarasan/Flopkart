


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class SignUpListener implements ActionListener
{
	LogedinPage mainpage;
	
	SignUpListener(LogedinPage p)
	{
		mainpage = p;
	}
	
	public void actionPerformed(ActionEvent e)
	{ 
		mainpage.setRegInvisible();
	}
}
class loginListener implements ActionListener
{
	LogedinPage mainpage;
	
	loginListener(LogedinPage p)
	{
		mainpage = p;
	}
	
	public void actionPerformed(ActionEvent e)
	{ 
		mainpage.setLogInvisible();
	}
		
}

class Sunglass implements MouseListener  //Sunglass label to sunglass page
{
	LogedinPage mainpage;
	
	Sunglass(LogedinPage p)
	{
		mainpage = p;
	}
	public void mouseClicked(MouseEvent evt) 
	{
		int count = evt.getClickCount();
        if (count == 1)
        {
        	mainpage.MainToSunglass();
        }
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
}

class BagPacks implements MouseListener     //Bag label to bag page
{
	LogedinPage mainpage;
	
	BagPacks(LogedinPage p)
	{
		mainpage = p;
	}
	
	public void mouseClicked(MouseEvent evt) 
	{
		int count = evt.getClickCount();
        if (count == 1)
        {
        	mainpage.MainToBags();
        }
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
}
class searchListener implements ActionListener {
	
	LogedinPage mainpage;
	
	searchListener(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		String copy=mainpage.GetSearchText();
		if(copy.equals("sunglasses"))
		{
			mainpage.MainToSunglass();			
			//System.out.println(copy);
		}
		
	}
}
class MenuListener_Sunglass implements ActionListener {
	
	LogedinPage mainpage;
	
	MenuListener_Sunglass(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		
		mainpage.MainToSunglass();			
			//System.out.println(copy);				
	}
}
 
class MenuListener_Footwear implements ActionListener {
	
	LogedinPage mainpage;
	
	MenuListener_Footwear(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		
		mainpage.MainToFootwear();			
			//System.out.println(copy);				
	}
}

class MenuListener_Wfootwear implements ActionListener {
	
	LogedinPage mainpage;
	
	MenuListener_Wfootwear(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		
		mainpage.MainToWFootwear();			
			//System.out.println(copy);				
	}
}

class MenuListener_Watch implements ActionListener {
	
	LogedinPage mainpage;
	
	MenuListener_Watch(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		
		mainpage.MainToWatch();			
			//System.out.println(copy);				
	}
}

class MenuListener_Wwatch implements ActionListener {
	
	LogedinPage mainpage;
	
	MenuListener_Wwatch(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		
		mainpage.MainToWwatch();			
			//System.out.println(copy);				
	}
}
class ButtonListener implements ActionListener
{
	LogedinPage mainpage;
	
	ButtonListener(LogedinPage p)
	{
		mainpage = p;
	}
	public void actionPerformed(ActionEvent e)
	{ 
		
		mainpage.Cart();			
			//System.out.println(copy);				
	}
	
}
public class LogedinPage extends JFrame 
{
	private Timer timer;
	private boolean count;
	public boolean loginStatus;

	public JLabel Tittle,logo,add,add1,welcome;
	public JLabel FormalShoe,Saree,Lenova,Furnishing,sunglass,Watch,Bag;
	public JTextField search;
	public JButton s,cart,signup,Login,left,right;
	public JMenuBar mb;
	public JPanel p;
	
	public JMenu Men,Maccess;
	public JMenuItem Mfoot,Mapp,Mwatch,Msp,Mgroom,Msunglass;
	public JMenu Wmen,Wapp,Wfoot;
	public JMenuItem Wgroom,Wwatch,Waccess,Wsp,Wsaree,Wshoes;
	public JMenu Fur;
	public JMenuItem Kd,furnitures,furnishing,Hdecor,Lighting,Th;
	public JMenu App;
	public JMenuItem Tv,Wm,Air,Ref,Gey,Kapp,Happ;
	public JMenu Elec;
	public JScrollPane scroll;
	public JMenuItem Mob,MobAcc,Mobacc,Lap,Comp,CompAcc,C,Cacc,Tab,Cperi,HomE,Ncomp;
	
	Login login;
	Reg reg;
	Sunglasses SunglassPanel;
	SunglassesMain BuySunglass;
	BuyPage bp;
	Cart c;
	Footwear footwear;
	Watch watch;
	Wfootwear wfootwear;
	Wwatch wwatch;
	Bags bags;
	
	public LogedinPage()
    {	
		Saree=new JLabel(new ImageIcon("d:\\Items\\Women.png"));
		Saree.setBounds(0,430,250,270);
		Lenova=new JLabel(new ImageIcon("d:\\Items\\Lenova.png"));
		Lenova.setBounds(1100,430,250,270);
		Furnishing=new JLabel(new ImageIcon("d:\\Items\\furnishing.png"));
		Furnishing.setBounds(885,430,250,270);
		sunglass=new JLabel(new ImageIcon("d:\\Items\\Ray-ban.png"));
		sunglass.addMouseListener(new Sunglass(this));
		sunglass.setBounds(660,430,250,270);
		Watch=new JLabel(new ImageIcon("d:\\Items\\Watch.png"));
		Watch.setBounds(440,430,250,270);
		Bag=new JLabel(new ImageIcon("d:\\Items\\bag.png"));
		Bag.setBounds(220,430,250,270);
		Bag.addMouseListener(new BagPacks(this));
		welcome=new JLabel();
	    left = new JButton("<");
	    left.setBounds(0,175,50,67);
	    left.setBackground(Color.WHITE);
	    right = new JButton(">");
	    right.setBounds(1298,175,50,67);
	    right.setBackground(Color.WHITE);
		add=new JLabel();
		logo=new JLabel(new ImageIcon("d:\\Project-icons\\flop.png"));
		logo.setBounds(180,35,50,50);
        count = true; 
        timer = new Timer(3000, new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(count) 
                {
                    add.setIcon(new ImageIcon("d:\\Project-icons\\add1.png"));
                    add.setBounds(5, 85, 1366, 400);
                    right.addActionListener(new ActionListener()
             	   {
            			public void actionPerformed(ActionEvent e)
            			{
            				add.setIcon(new ImageIcon("d:\\Project-icons\\add.png"));
            			}
             	   });
                    left.addActionListener(new ActionListener()
              	   {
             			public void actionPerformed(ActionEvent e)
             			{
             				add.setIcon(new ImageIcon("d:\\Project-icons\\add1.png"));
             			}
              	   });
                    count = false;
                } 
                else 
                {
                    add.setIcon(new ImageIcon("d:\\Project-icons\\add.png"));
                    add.setBounds(5, 85, 1366, 400);
                    right.addActionListener(new ActionListener()
              	   {
             			public void actionPerformed(ActionEvent e)
             			{
             				add.setIcon(new ImageIcon("d:\\Project-icons\\add1.png"));
             			}
              	   });
                     left.addActionListener(new ActionListener()
               	   {
              			public void actionPerformed(ActionEvent e)
              			{
              				add.setIcon(new ImageIcon("d:\\Project-icons\\add.png"));
              			}
               	   });
                    count = true;
                }
            }
        });
        timer.start();
        add.add(left);add.add(right);
		Tittle=new JLabel("Flopkart");												
		Font myFont=new Font("SANS_SERIF", Font.ITALIC,26);
		Tittle.setFont(myFont);
		Tittle.setBounds(80,40,100,40);
		Tittle.setForeground(Color.WHITE);
		s=new JButton(new ImageIcon("d:\\Project-icons\\search-button.png"));
		s.setBackground(Color.orange);
		s.addActionListener(new searchListener(this));  
		s.setBounds(1000, 40, 70, 40);
		cart=new JButton(new ImageIcon("d:\\Project-icons\\cart1.png"));
		cart.setBackground(Color.BLUE);
		cart.setForeground(Color.WHITE);
		cart.setText(" CART");
		cart.setBounds(1080,40,120,40);
		cart.addActionListener(new ButtonListener(this));
		signup=new JButton("Signup");
		signup.setBackground(Color.BLUE);
		signup.setForeground(Color.WHITE);
		signup.setBounds(1100, 10, 80, 20);
		Login=new JButton("Log In");
		Login.setBackground(Color.BLUE);
		Login.setForeground(Color.WHITE);
		Login.setBounds(1180, 10, 80, 20);
		
		p=new JPanel();
		search=new JTextField();
	
		search.setBounds(250, 40, 750, 40);		
	    
	    mb=new JMenuBar();
	    
	    /*****************************  Menu's & Menu Items****************************************/
		Men=new JMenu("MEN");
		Men.setForeground(Color.WHITE);
		Mfoot=new JMenuItem("Footwear");
		Mfoot.addActionListener(new MenuListener_Footwear(this));
		Mapp=new JMenuItem("Appearels");
		Mgroom=new JMenuItem("Men's grooming");
		Mwatch=new JMenuItem("Watches");	
		Mwatch.addActionListener(new MenuListener_Watch(this));
		Maccess=new JMenu("Accessories");
		Msunglass=new JMenuItem("sunglasses");
		Msunglass.addActionListener(new MenuListener_Sunglass(this));
		Maccess.add(Msunglass);
		Msp=new JMenuItem("Sports and Fitness");  
		Men.setBounds(200, 85, 100, 40);
		Men.add(Mfoot); Men.add(Mapp); Men.add(Mgroom);Men.add(Mwatch);Men.add(Maccess);Men.add(Msp);	
		
		mb.add(Men);
		/*****************WOMEN*************************/
		Wmen=new JMenu("WOMEN");
		Wmen.setForeground(Color.WHITE);
		Wfoot=new JMenu("Footwear");
		Wshoes=new JMenuItem("sport shoes");
		Wshoes.addActionListener(new MenuListener_Wfootwear(this));
		Wfoot.add(Wshoes);
		Wapp=new JMenu("Appearels");
		Wsaree=new JMenuItem("Saree");
		Wapp.add(Wsaree);
		Wgroom=new JMenuItem("Beuty & grooming");
		Wwatch=new JMenuItem("Watches");
		Wwatch.addActionListener(new MenuListener_Wwatch(this));
		Waccess=new JMenuItem("Accessories");
		Wsp=new JMenuItem("Sports and Fitness"); 
		Wmen.setBounds(380, 85, 100, 40);
		Wmen.add(Wfoot); Wmen.add(Wapp); Wmen.add(Wgroom);Wmen.add(Wwatch);Wmen.add(Waccess);Wmen.add(Wsp);
		
		mb.add(Wmen);
		/*****************HOME FURNITURES****************/
		Fur=new JMenu("HOME & FURNITURE");
		Fur.setForeground(Color.WHITE);
		Kd=new JMenuItem("Kitchen & Dining");
		furnitures=new JMenuItem("Furnitures");
		furnishing=new JMenuItem("Furnishing");
		Hdecor=new JMenuItem("Home Decor");
		Lighting=new JMenuItem("Lighting");	
		Th=new JMenuItem("Tools & Hardware"); 
		Fur.setBounds(580, 85, 120, 40);
		Fur.add(Kd); Fur.add(furnitures); Fur.add(furnishing);Fur.add(Hdecor);Fur.add(Lighting);Fur.add(Th);	
		
		mb.add(Fur);
		/****************APPLIANCES*********************/
		App=new JMenu("APPLIANCES");
		App.setForeground(Color.WHITE);
		Tv=new JMenuItem("TV's");
		Wm=new JMenuItem("Washing Machines");
		Ref=new JMenuItem("Refrigirators");
		Air=new JMenuItem("Air Conditioners");
		Gey=new JMenuItem("Geyser's");	
		Kapp=new JMenuItem("Kitchen Appliances");  
		Happ=new JMenuItem("Health Care Appliances");
		App.setBounds(800, 85, 100, 40);
		App.add(Tv); App.add(Wm); App.add(Air);App.add(Ref);App.add(Gey);App.add(Kapp);App.add(Happ);   
		
		mb.add(App);
		/***************ELECTRONICS*********************/
		Elec=new JMenu("ELECTRONICS");
		Elec.setForeground(Color.WHITE);
		Mob=new JMenuItem("Mobile");
		MobAcc=new JMenuItem("Mobile Accessories");
		Lap=new JMenuItem("Laptops");
		Comp=new JMenuItem("Computers");
		CompAcc=new JMenuItem("Computer Accessories");	
		C=new JMenuItem("Camera");  
		Cacc=new JMenuItem("Camera Accessories");
		Tab=new JMenuItem("Tablets");
		Cperi=new JMenuItem("Computer Peripherals");
		HomE=new JMenuItem("Home Entertainments");
		Ncomp=new JMenuItem("Network Components");
		Elec.setBounds(1000, 85, 100, 40);
		Elec.add(Mob); Elec.add(MobAcc);Elec.add(Lap);Elec.add(Comp);Elec.add(CompAcc);Elec.add(C);Elec.add(Cacc);
		Elec.add(Tab);Elec.add(Cperi);Elec.add(HomE);Elec.add(Ncomp);
		mb.add(Elec);
	/****************************************************************************************************************/
		mb.setBackground(Color.BLUE);
		mb.setBounds(0, 0, 1366, 130);
		mb.setLayout(null);
		mb.add(search);mb.add(s);mb.add(cart);mb.add(Tittle);mb.add(logo);mb.add(signup);mb.add(Login);mb.add(welcome);
		p.setLayout(null);
		p.add(add);p.add(Saree);p.add(Lenova);p.add(Furnishing);p.add(sunglass);p.add(Watch);p.add(Bag);
		p.add(mb);/*p.add(search);p.add(s);p.add(cart);*/
		
		SunglassPanel=new Sunglasses(this); 
		BuySunglass=new SunglassesMain(this);
		login= new Login(this);
		reg= new Reg(this);
		bp=new BuyPage(this);
		c=new Cart(this);
		footwear=new Footwear(this);
		watch=new Watch(this);
		wfootwear=new Wfootwear(this);
		wwatch=new Wwatch(this);
		bags=new Bags(this);
		
		Login.addActionListener(new loginListener(this));  
		
		signup.addActionListener(new SignUpListener(this));
		add(p);
		
	
   }
	
	public void setLogInvisible()		//removing main page panel and adding login
	{
		remove(p);
		add(login);
		revalidate();
		repaint();
	}
	public void setRegInvisible()		//removing main page panel and adding register
	{
		remove(p);
		add(reg);
		revalidate();
		repaint();
	}
	public void MainPageVisible(JPanel panel)	//any page to main page
	{
		remove(panel);
		add(p);
		revalidate();
		repaint();
	}
	public void setMainPageVisible()	//login page to mainpage
	{
		remove(login);
		add(p);
		revalidate();
		repaint();
	}
	public void RegToMainPageVisible()	//register page to mainpage
	{
		remove(reg);
		add(p);
		revalidate();
		repaint();
	}
	public void setMainvisible() 	//adding sunglass main panel to sunglass
	{
		remove(SunglassPanel);
		add(BuySunglass);
		revalidate();
		repaint();
	}
	public void MainToSunglass() //removing main panel and adding sunglass items panel
	{
		remove(p);
		add(SunglassPanel);
		revalidate();
		repaint();
	}
	public void BuyPageVisible() //removing main panel and adding sunglass buy panel
	{
		remove(BuySunglass);
		add(bp);
		revalidate();	
		repaint();
	}
	public void MainToFootwear() //removing main panel and adding sunglass items panel
	{
		remove(p);
		add(footwear);
		revalidate();
		repaint();
	}
	
	public void MainToWatch() //removing main panel and adding sunglass items panel
	{
		remove(p);
		add(watch);
		revalidate();
		repaint();
	}
	
	public void MainToWFootwear() //removing main panel and adding sunglass items panel
	{
		remove(p);
		add(wfootwear);
		revalidate();
		repaint();
	}
	
	public void MainToWwatch() //removing main panel and adding sunglass items panel
	{
		remove(p);
		add(wwatch);
		revalidate();
		repaint();
	}
	
	public void MainToBags() //removing main panel and adding sunglass items panel
	{
		remove(p);
		add(bags);
		revalidate();
		repaint();
	}
	public String GetSearchText()
	{
		return search.getText();
		
	}
	
	public void Cart()
	{
		remove(p);
		add(c);
		revalidate();
		repaint();
	}
	
	public void buyToLogin()
	{
		//remove(p);
		add(login);
		revalidate();
		repaint();
	}
   public static void main(String args[])
   { 
       //new LogedinPage();
       LogedinPage frame=new LogedinPage();
       frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	   frame.setTitle("Welcome To Flopkart");
	   frame.setSize(1366,730);
	   frame.setVisible(true);
	   
   }
   

	
	
}

