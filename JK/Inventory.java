package com.JK;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Inventory {
	Statement stmt;
	ResultSet rs;
	String qry = null;
	dbutil db = new dbutil();
	Connection con;
	int count;
    private List<Esteem> list = new ArrayList<>();

    public void add(Esteem e1) {
        list.add(e1); // Add new products to the inventory
        try {

    		Connection con=db.getDBConnection();

    		stmt=con.createStatement();

    		qry = "INSERT INTO bookings_shoes (Brand, Size, Type, No_of_Shoes, Id, Order_Name, Order_Brand, Order_Size, Order_No_of_Shoes, Order_Type, Amount) VALUES ('" 
    			      + e1.getBrand() + "', '" 
    			      + e1.getSize() + "', '" 
    			      + e1.getType() + "', '" 
    			      + e1.getNo_of_shoes() + "', '" 
    			      + e1.getId() + "', '" 
    			      + e1.getO_name() + "', '" 
    			      + e1.getO_brand() + "', '" 
    			      + e1.getO_size() + "', '" 
    			      + e1.getO_no_of_shoes() + "', '" 
    			      + e1.getO_type() + "', '" 
    			      + e1.getAmt() + "')";


    	    count=stmt.executeUpdate(qry);

    		if(count==1)

    			System.out.println("Inserted Successfully");

    		else

    			throw new Exception();

    	}

    	catch(Exception ex) {

    		System.out.println(ex.getMessage());

    	}
    }

    public String generate_id(Esteem e) {
        return e.getO_brand() + e.getO_name().substring(e.getO_name().length() - 2);
    }

    public void show_orders() {
        if (list.isEmpty()) {
            System.out.println("No clients available.");
        } else {
            for (Esteem e1 : list) {
            	if(e1.getId()!=null)
            		System.out.println("Id of the customer is: " +e1.getId()+"\nBrand: "+e1.getO_brand()+"\nCustomer Name: "+e1.getO_name()+"\nNo of Shoes he/she ordered: "+e1.getO_no_of_shoes()+"\nSize of the shoe he/she ordered: "+e1.getO_size()+"\nType of the shoe: "+e1.getO_type());
            }
        }
    }
    
    
    public void show_products() {
    /*	if(list.isEmpty()) {
    		System.out.println("No products available");
    	}
    	else {
    		for(Esteem e1: list) {
    			if(e1.getBrand()!=null)
    				System.out.println("Brand:" +e1.getBrand()+"\nType of Shoe: "+e1.getType()+"\nSize of the Shoes: "+e1.getSize()+"\nNo of Shoes includes: "+e1.getNo_of_shoes());
    		}
    	}*/
    	try {
    		con = db.getDBConnection();
    		stmt = con.createStatement();
    		rs = stmt.executeQuery("select * from bookings_shoes");
    		while(rs.next())
    			System.out.println("Brand: "+rs.getString(1)+"\nType of Shoe: "+rs.getString(3)+"\nSize of the Shoes: "+rs.getInt(2)+"\nNo of Shoes includes: "+rs.getInt(4));
    	}
    	catch(Exception ex) {
    		System.out.print(ex.getMessage());
    	}
    }

    public Esteem search(String id) {
        for (Esteem e : list) {
            if (id.equals(e.getId()) || id.equals(e.getBrand())) {
                return e;
            }
        }
        return null;
    }

    public void update(String id) 

	{

		Scanner sc=new Scanner(System.in);

		int ch;

		try

		{

		  con=db.getDBConnection();

		  stmt=con.createStatement();

		  System.out.print("Enter to update 1.Size 2.Type 3.Number of Shoes 4.exit");

		  ch=sc.nextInt();

		  switch(ch)

		  {

		    case 1:

		    {

			   //b.setCusname(sc.next());

			   qry="update bookings_shoes set Size='"+sc.next()+"' where Brand='"+id+"'";

			   break;

		    }

		    case 2:

		    {

			  // b.setBrand(sc.next());

			   qry="update details set Type='"+sc.next()+"' where Brand='"+id+"'";

			   break;

		    }

		    case 3:

		    {

			   //b.setModel(sc.next());

			   qry="update details set No_of_Shoes='"+sc.next()+"' where Brand='"+id+"'";

			   break;

		    }
		    default:

		    {

			   System.out.println("Invalid choice");

		    }

		  }

		  int count=stmt.executeUpdate(qry);

		  if(count==1)

			  System.out.println("1 row is updated");

		  else

			  throw new Exception("No row is updated");

		}

		catch(Exception e)

		{

			System.out.println(e);

		}

   }

	public void delete(String id) {
        /*Esteem toRemove = null;
        for (Esteem e : list) {
            if (id.equals(e.getId())) {
                toRemove = e;
                break;
            }
        }
        if (toRemove != null) {
            list.remove(toRemove);
            System.out.println("Removed successfully.");
        } else {
            System.out.println("Product not found.");
        }*/
        boolean sts=false;
    	try {
    		con = db.getDBConnection();
    		stmt = con.createStatement();
    		qry = "delete from bookings_shoes where Type='"+id+"'";
    		count=stmt.executeUpdate(qry);
    	    if(count==1)
    	    sts=true;
    	}
    	catch(Exception ex)
        {
    	    System.out.println(ex.getMessage());
    	   
    	    }

    }
    
    public void showID() {
        if (list.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Esteem e : list) {
                System.out.println("Name: " + e.getO_name() + " | Credentials ID: " + e.getId());
            }
        }
    }
}
