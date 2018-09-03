

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

class HomeListener implements MouseListener
{
	LogedinPage mainpage;
	Sunglasses sunglasses;
	
	HomeListener(LogedinPage p,Sunglasses g)
	{
		mainpage = p;
		sunglasses = g;
	}

	

	@Override
	public void mouseClicked(MouseEvent evt) 
	{
		int count = evt.getClickCount();
        if (count == 1)
        {
        	mainpage.MainPageVisible(sunglasses);
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
public class Sunglasses extends JPanel
{
	JLabel Tittle,logo,welcome;
	JLabel s1,s2,s3,s4;
	JTextField search;
	JButton s,cart;
	JMenuBar mb;
	LogedinPage mainpage;
	
	
	
	
	
	
	public Sunglasses(LogedinPage page)
    {	
		mainpage = page;
		setBackground(Color.WHITE);
		welcome=new JLabel();
	    
		logo=new JLabel(new ImageIcon("d:\\Project-icons\\flop.png"));
		logo.setBounds(180,35,50,50);
        
       
		Tittle=new JLabel("Flopkart");		
		Tittle.addMouseListener(new HomeListener(mainpage,this));
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
		s1=new JLabel(new ImageIcon("d:\\sunglasses\\s1.png"));
		s1.setBounds(50, 150, 250, 400);
		s1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                int count = evt.getClickCount();
                if (count == 1)
                {
                	mainpage.setMainvisible();
                }
            }
        });
		s2=new JLabel(new ImageIcon("d:\\sunglasses\\s2.png"));
		s2.setBounds(300, 150, 250, 400);
		s3=new JLabel(new ImageIcon("d:\\sunglasses\\s3.png"));
		s3.setBounds(550, 150, 250, 400);
		s4=new JLabel(new ImageIcon("d:\\sunglasses\\s4.png"));
		s4.setBounds(800, 150, 250, 400);
		setLayout(null);
		add(mb);add(s1);add(s2);add(s3);add(s4);
		
		
	
   }
	
	
	/*public static void main(String[] args) 
	{
		new Sunglasses();

	}*/

}
