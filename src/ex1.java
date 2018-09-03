import java.text.SimpleDateFormat;  
import java.util.Date;  
public class ex1 
{

	public static void main(String[] args) 
	{
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 SimpleDateFormat formatt = new SimpleDateFormat("hh:mm a");
		 Date date = new Date();  
		 System.out.println(formatt.format(date));  
	}

}
