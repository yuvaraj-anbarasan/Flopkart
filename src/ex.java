import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ex 
{
public static void main(String args[])
{
	LocalTime time=java.time.LocalTime.now();
	String url="jdbc:mysql://Localhost:3306/rfid?useSSL=false";
	String user="root";
	String password="yuva";
	int Id=1660445;
	String x,y;
	int X,Y=0;
	int status=0;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	SimpleDateFormat formatt = new SimpleDateFormat("hh:mm a");
	Date date = new Date();  
	//System.out.println(formatter.format(date)); 
	try 
	{
		//1.establish connection
		Connection connect=DriverManager.getConnection(url,user,password);
	
		//2.create a sql query
			Statement mystmt=connect.createStatement();
			//Statement mystmt1=connect.createStatement();
			//Statement mystmt2=connect.createStatement();
		//3.execute sql query
			
			//ResultSet flag=mystmt1.executeQuery("select flag from products.test ;");
			//ResultSet id=mystmt2.executeQuery("select id from products.test ;");
			
		//4.process the result set			
			
			/*while (flag.next() && id.next()) 
			{	
				x=id.getString("id");
				X=Integer.parseInt(x);
				System.out.println(X);
				y=flag.getString("flag");
				//Y=Integer.parseInt(y);
				System.out.println(y);
				if(X==Id && status != 1)
				{
					status=1;
					break;			
				}
			}
			if(Y!=1)
			{
			String sql="insert into test"
					+"(id,start_,end_,flag)"
					+"values('0','"+time+"',' ','1')";	
				mystmt.executeUpdate(sql);
			}
			else if(Y==1)
			{
				String sql="insert into test"
						+"(id,start_,end_,flag)"
						+"values('0','',"+time+"','0')";	
					mystmt.executeUpdate(sql);	
			}
			*/
			String sql="insert into attendance"
					+"(id,entry_time,entry_date)"
					+"values(1660446,TIME_FORMAT("+time+","+"%H:%i %p"+"),'"+formatter.format(date)+"')";	
				mystmt.executeUpdate(sql);
	} catch (SQLException ex) 
	{
		ex.printStackTrace();
	}
	
	//String y=x;
	System.out.println(time);  
}
}
