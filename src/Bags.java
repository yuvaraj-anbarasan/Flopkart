

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Bags extends JPanel 
{
	JLabel Tittle,logo;
	JTextField search;
	JButton s,cart;
	JMenuBar mb;

	LogedinPage mainpage;
	
	Bags(LogedinPage page)
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
		cart=new JButton(new ImageIcon("d:\\Project-icons\\cart1.png"));
		cart.setBackground(Color.BLUE);
		cart.setForeground(Color.WHITE);
		cart.setText(" CART");
		cart.setBounds(1080,40,120,40);
	    mb=new JMenuBar();	    	    
		mb.setBackground(Color.BLUE);
		mb.setBounds(0, 0, 1366, 100);
		mb.setLayout(null);
		mb.add(search);mb.add(s);mb.add(Tittle);mb.add(logo);
		setLayout(null);
		add(mb);
	}
	
}