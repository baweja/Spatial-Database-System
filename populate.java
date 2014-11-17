import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;
/*import oracle.sdoapi.OraSpatialManager;
import oracle.sdoapi.geom.*;
import oracle.sdoapi.adapter.*;
import oracle.sdoapi.sref.*;
//import oracle.sql.STRUCT;
*/
public class populate
{
	
	
	//Connection Variables
  	static Connection mainConnection = null;
  	static Statement mainStatement = null;
  	static ResultSet mainResultset = null;


  	public static void main(String[] args) throws Exception
    {
  		hw2 pop1=new hw2();
  		//hw2 pop1=new hw2();
  		populate pop = new populate();
//ConnectToDB();
    	pop.Read_Input_File(args[0]);
    	pop.Read_AS_File(args[1]);
    	pop.Read_Students_File(args[2]);
    	
    	
    	
    
    	//hw2 g =new hw2();
    	//System.out.println(query);
    	// pop.Create_Table_Query(query);
    	//pop.Insert_Buildings_Data();
        
    
    }
  
  	public void Read_Input_File(String var)
  	{
  		String query1="";  
  		try  
  		{  
  		//make a 'file' object   
  		File file = new File("C:/Users/Garima/Desktop/EXTRA/HW2/"+var);     
  		FileReader fr = new FileReader(file);  
  		BufferedReader br = new BufferedReader(fr);                                                   
  		mainStatement.executeUpdate("DELETE from BUILDINGS");
  		while((query1=br.readLine( ))!= null)   
  		{  
  		//query1 = br.readLine( ); 
  		
  		Insert_Buildings_Data(query1);
  	  
  		}
  		
  		}
  		
  		catch(IOException e){System.out.println("1a !");} 
  		//return query1;
  		catch(SQLException e)
  		{
  			System.out.println(" Error : " + e.toString() );
  		}	
  	}
  	

  	
  	public void Read_AS_File(String var1)
  	{
  		String query2="";  
  		try  
  		{  
  		//make a 'file' object   
  		File file1 = new File("C:/Users/Garima/Desktop/EXTRA/HW2/"+var1);     
  		FileReader fr1 = new FileReader(file1);  
  		BufferedReader br1 = new BufferedReader(fr1);                                                   
  		mainStatement.executeUpdate("DELETE from ANNOUNCEMENTSYSTEMS");
  		while((query2=br1.readLine( ))!= null)   
  		{  
  		//query1 = br.readLine( );    
  		Insert_AS_Data(query2);
  	  
  		} 
  		
  		}
  		catch(IOException e){System.out.println("1 !");} 
  		catch(SQLException e)
  		{
  			System.out.println(" Error : " + e.toString() );
  		}
  		//return query1;
  		}   
  	
	public void Read_Students_File(String var2)
  	{
  		String query3="";  
  		try  
  		{  
  		//make a 'file' object   
  		File file2 = new File("C:/Users/Garima/Desktop/EXTRA/HW2/"+var2);     
  		FileReader fr2 = new FileReader(file2);  
  		BufferedReader br2 = new BufferedReader(fr2);                                                   
  		mainStatement.executeUpdate("DELETE from STUDENTS");
  		while((query3=br2.readLine( ))!= null)   
  		{  
  		//query1 = br.readLine( );
  			
  		
  		Insert_Students_Data(query3);
  		//System.out.println(query2);  
  		}
  		
  		}
  		catch(IOException e){System.out.println("2");} 
  		//return query1;
  		
	catch(SQLException e)
	{
		System.out.println(" Error : " + e.toString() );
	}
  	}    
  	
	
	public void Insert_Students_Data(String query3)
 	{
 	try
 	{
 		
    
 	System.out.print("STUDENTS Details");
    System.out.print( " ** Inserting Data ..." );
 		
 	String StudElem[]=query3.split(",");
 	//System.out.println(query3);
   mainStatement.executeUpdate("insert into STUDENTS values('"+StudElem[0]+"',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE("+StudElem[1]+","+StudElem[2]+",NULL),NULL,NULL)) ");
     
   System.out.println("Students inserted");
            System.out.println();
 	}
 
catch(SQLException e)
{
	System.out.println(" Error : " + e.toString() );
}

 	
 	finally
 	{
 	}
         
 	}
  	
  	
  	public void Insert_AS_Data(String query2)
 	{
 	try
 	{
 		//populate pop=new populate();
    
/* 	System.out.print("ANNOUNCEMENT SYSTEMS Details");
    System.out.print( " ** Inserting Data ..." );*/
 		
 	String ASElem[]=query2.split(",");
 	//System.out.println(query2);
   mainStatement.executeUpdate("insert into ANNOUNCEMENTSYSTEMS values('"+ASElem[0]+"',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE("+ASElem[1]+","+ASElem[2]+",NULL),NULL,NULL),"+ASElem[3]+") ");
           
 	      
   System.out.println("AS inserted");
 	}
 
catch(SQLException e)
{
	System.out.println(" Error : " + e.toString() );
}

 	
 	finally
 	{
 	}
         
 	}
  		
  		  
 	public void Insert_Buildings_Data(String query1)
 	{
 	try
 	{
 		
 		
 		//System.out.print( " ** Inserting Data ..." );
 		
 	
 	
 	String buildingElem[]=query1.split(",");
   String query="insert into BUILDINGS values('"+buildingElem[0]+"','"+buildingElem[1]+"',"+buildingElem[2]+", SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(";
 			
 	 for(int i=3;i<buildingElem.length;i++)
 	 {
 		//String shape=buildingElem[i].trim();
 		if(i==buildingElem.length-1)
 		{
 	      query=query+buildingElem[i]+")))";
 		}
 			else
 			{
 				query=query+buildingElem[i]+",";
 			}  
 		}
 		
 	

           
 	      
            mainStatement.executeUpdate(query);
            System.out.println("BUILDINGS inserted");
 	}
 
catch(SQLException e)
{
	System.out.println(" Error : " + e.toString() );
}

 	
 	finally
 	{
 	
 	}
        
        
 	}

	
 
 	
 		
 public populate()
 {   
	 ConnectToDB();
  //pop1.Display_Tuples(mainStatement,mainConnection);
//	pop1.displayAS(mainStatement,mainConnection);
	//pop1.B_display(mainStatement,mainConnection);
 }
    
      
     	
 		
 	
 	
 	
 	
	public void ConnectToDB()
	{
	
		try
		{
			// loading Oracle Driver
    		System.out.print("Looking for Oracle's jdbc-odbc driver ... ");
	    	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    	System.out.println(", Loaded.");

	    	String URL = "jdbc:oracle:thin:@localhost:1521:garimaDB";
	    	String userName = "sys as SYSDBA";
	    	String password = "Garima07";
	    	
	    	/*String URL = "jdbc:oracle:thin:@localhost:1521:hw2";
	    	String userName = "system";
	    	String password = "hw2";*/

	    	System.out.print("Connecting to DB...");
	    	mainConnection = DriverManager.getConnection(URL, userName, password);
	    	System.out.println(", Connected!");

    		mainStatement = mainConnection.createStatement();

   		}
   		catch (Exception e)
   		{
     		System.out.println( "Error while connecting to DB: "+ e.toString() );
     		e.printStackTrace();
     		System.exit(-1);
   		}
 	


    }
}

