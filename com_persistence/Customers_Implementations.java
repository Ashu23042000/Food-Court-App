package com_persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.STRING;

import com_entity.Customer;
import com_entity.Menu;
import com_entity.Order;
import com_entity.Restaurant;

public class Customers_Implementations implements Customers_Declerations {
	
	@Override
	public Customer login(long PhoneNo, String userPassword) throws ClassNotFoundException, SQLException {
		
		Customer cust1=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
		String selectQuery = "select * from customer where phone_number = ? and password = ?";
		PreparedStatement pst1 = con.prepareStatement(selectQuery);
		pst1.setLong(1, PhoneNo);
		pst1.setString(2, userPassword);
		ResultSet rs = pst1.executeQuery();
		
		while (rs.next()) {
			if(rs.getLong("phone_number")==PhoneNo && rs.getString("password").equals(userPassword)) {
				   int id = rs.getInt("customer_id");
	                String name = rs.getString("name");
	                String address = rs.getString("address");
	                long phone = rs.getLong("phone_number");
	                String city = rs.getString("city");
	                String email = rs.getString("email");
	                String password = "Encrypted";
	                return cust1= new Customer(id,name, address, phone,email,password,city);
			}
		}
		
		return cust1;
		
	}

	public boolean signup(Customer cust) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
		if(!validatePhoneNumber(cust.getCustomerPhone())) {
			  throw new Exception("Invalid phone number format.");
		}
		if(!validateEmail(cust.getCustomerEmail()))
		{
			throw new Exception("Invalid email format.");
		}
		if(!validatePassword(cust.getCustomerPassword())){
			  throw new Exception("Password must be at least 6 characters long.");

		}
		String selectQuery = "select count(*) from Customer where phone_number = ?";
		PreparedStatement pst1 = con.prepareStatement(selectQuery);
		pst1.setLong(1, cust.getCustomerPhone());
		
		ResultSet rs = pst1.executeQuery();
		int i =0; 
		while(rs.next()) {
		 i += rs.getInt(1);	
		}
		
		if(i>=1) {
			return false;
		}else {
		
	            String insertQuery = "insert into customer(name,address,phone_number,email,password,city) values (?,?,?,?,?,?)";
		    		PreparedStatement pst2 = con.prepareStatement(insertQuery);
		    		pst2.setString(1, cust.getCustomerName());
		    		pst2.setString(2, cust.getCustomerAddress());
		    		pst2.setLong(3, cust.getCustomerPhone());
		    		pst2.setString(4, cust.getCustomerEmail());
		    		pst2.setString(5, cust.getCustomerPassword());
		    		pst2.setString(6, cust.getCustomerCity());
		    		int count = pst2.executeUpdate(); 
		    		
		    		if(count>=1) {
		    			return true;
		    		}
		    }
		
		return false;
	}

		
	public  boolean validateEmail(String email) throws Exception {
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new Exception("Invalid email format.");
        }
		return true;
    }
    
    public  boolean validatePhoneNumber(long phoneNumber) throws Exception {
    	String phone =Long.toString(phoneNumber);
    	
        if (!phone.matches("\\d{10}")) {
        	throw new Exception("Invalid phone number format.");
        }
		return true;
    }
    
//    public  boolean validatePassword(String password) throws Exception  {
//        if (password.length() < 6) {
//            
//        	throw new Exception("Password must be at least 6 characters long.");
//        }
//		return true;
    	public  boolean validatePassword(String password) throws Exception {
    	    // Check if password length is at least 6 characters
    	    if (password.length() < 6) {
    	        //return false;
    	    	throw new Exception("Password must be at least 6 characters long.");
    	    }

    	    // Check if password contains at least one capital letter
    	    boolean containsCapitalLetter = false;
    	    for (int i = 0; i < password.length(); i++) {
    	        if (Character.isUpperCase(password.charAt(i))) {
    	            containsCapitalLetter = true;
    	            break;
    	        }
    	    }
    	    if (!containsCapitalLetter) {
    	        //return false;
    	    	throw new Exception("Password must contain atleast one Capital Letter");
    	    }

    	    // Check if password contains at least one special symbol
    	    boolean containsSpecialSymbol = false;
    	    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
    	    Matcher matcher = pattern.matcher(password);
    	    if (matcher.find()) {
    	        containsSpecialSymbol = true;
    	    }
    	    if (!containsSpecialSymbol) {
    	        //return false;
    	    	throw new Exception("Password must be contain Special Symbols.");
    	    }

    	    return true;
    	}

    //}
	@Override
	public int updateDetails(Customer customer) throws Exception {
		Scanner scan=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
		System.out.println("**********Welcome to the Updation Page*******");
		System.out.println("Please enter your choice for updating your details  1-Name Updation,2-Address Updation,3-Email Updation,4-Password Updation,5-City Updation,6-exit");
	
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:System.out.println("Please enter the Name you want to change:  ");
		customer.setCustomerName(scan.next());
		System.out.println("Please enter the your Phone Number:");
		customer.setCustomerPhone(scan.nextLong());
     	PreparedStatement ps=con.prepareStatement("update customer  set name=? where phone_number=?");
     	ps.setString(1,customer.getCustomerName());
     	ps.setLong(2, customer.getCustomerPhone());
    	int i=ps.executeUpdate();
    	return i;
    	case 2:System.out.println("Please enter the Address you want to  change:");
		customer.setCustomerAddress(scan.next());
		System.out.println("Please enter the your Phone Number:");
        customer.setCustomerPhone(scan.nextLong());
    	PreparedStatement ps1=con.prepareStatement("update customer  set address=? where phone_number=?");
    	ps1.setString(1,customer.getCustomerAddress());
    	ps1.setLong(2, customer.getCustomerPhone());
    	int i1=ps1.executeUpdate();
    	return i1;
    	case 3:System.out.println("Please enter the Email-Address you want to  change");
		String emailadd=scan.next();
		System.out.println("Please enter the your Phone Number:");
        customer.setCustomerPhone(scan.nextLong());
		if (!emailadd.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            System.out.println("Invalid email format.");
            return 0;
        }
		else {
			customer.setCustomerEmail(emailadd);
		PreparedStatement ps2=con.prepareStatement("update customer  set email=? where phone_number=?");
    	ps2.setString(1,customer.getCustomerEmail());
    	ps2.setLong(2, customer.getCustomerPhone());
    	int i2=ps2.executeUpdate();
    	return i2;
		}
    	case 4:System.out.println("Please enter the Password you want to  change");
    	String pass_word=scan.next();
    	System.out.println("Please enter the your Phone Number:");
        customer.setCustomerPhone(scan.nextLong());
    	if(!validatePassword(pass_word))
    	{
    		System.out.println("Invalid Password Format");
    	
    	}
    	else {
		customer.setCustomerPassword(scan.next());
		PreparedStatement ps3=con.prepareStatement("update customer  set password=? where phone_number=?");
    	ps3.setString(1,customer.getCustomerPassword());
    	ps3.setLong(2, customer.getCustomerPhone());
    	int i3=ps3.executeUpdate();
    	return i3;
    	}
    	case 5:System.out.println("Please enter the City you want to  change");
		customer.setCustomerCity(scan.next());
		System.out.println("Please enter the your Phone Number:");
        customer.setCustomerPhone(scan.nextLong());
    	PreparedStatement ps4=con.prepareStatement("update customer  set city=? where phone_number=?");
    	ps4.setString(1,customer.getCustomerCity());
    	ps4.setLong(2, customer.getCustomerPhone());
    	int i4=ps4.executeUpdate();
    	return i4;
    	case 6: System.exit(0);
		default:System.out.println("Invalid choice!!");
		}
		
		scan.close();
		return 0;
	}

	@Override
	public ArrayList<Restaurant> getRestaurants() throws SQLException, ClassNotFoundException {
	
			ArrayList<Restaurant> restaurantList=new ArrayList<Restaurant>();
			Restaurant t=null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
			
			String query="select * from Restaurant";
			Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery(query);
		    
		    while(rs.next())
		    {
		    	t=new Restaurant();
		    	t.setRestautrantId(rs.getInt(1));
		    	t.setRestautrantName(rs.getString(2));
		    	restaurantList.add(t);
		    }
		    
		    con.close();
		    
		    return restaurantList;
	}

	@Override
	public ArrayList<Menu> getItems(int restaurantId) throws SQLException, ClassNotFoundException {
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		Menu m=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
		String query="select * from menu where restaurant_id=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, restaurantId);
	    ResultSet rs=st.executeQuery();
	    while(rs.next())
	    {
	    	
	    	
	    	m=new Menu();
	    	m.setItemId(rs.getInt(1));
	    	m.setItemName(rs.getString(2));
	    	m.setItemPrice(rs.getInt(3));
	    	m.setRestaurantId(rs.getInt(4));
	    	menuList.add(m);
	    }
	    con.close();
	    return menuList;
	}
	
	
	@Override
	public Order getOrderStatus() {
		// TODO Auto-generated method stub
		return null;
	}


	
//	@Override
//	public boolean placeOrder(int restaurantId,int customerId) {
//		boolean flag= true;
//		try{
//			String choice;
//			HashMap<Menu, Integer>userCart =new HashMap<>();
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root","Ashu123");
//			Scanner scanner =new Scanner(System.in);
//			
////			Addressing items to cart
//			do {
//				
//					System.out.println("Select item");
//					String itemName= scanner.nextLine();
//					System.out.println("Enter quantity");
//					int quantity =scanner.nextInt();
//					
//								
//					String query="select * from menu where item_name=? and restaurant_id=?";
//					PreparedStatement preparedStatement = connection.prepareStatement(query);
//					preparedStatement.setString(1, itemName);
//					preparedStatement.setInt(2,restaurantId );
//					
//					ResultSet resultSet =preparedStatement.executeQuery();
//					
//					if(resultSet.next()){
//						Menu menu= new Menu();
//						menu.setItemId(resultSet.getInt(1));
//						menu.setItemName(resultSet.getString(2));
//						menu.setItemPrice(resultSet.getInt(3));
//						menu.setRestaurantId(resultSet.getInt(4));
//						userCart.put(menu, quantity);
//					}else{
//						System.out.println("Enter wrong item name!!");
//					}
//					
//					System.out.println("Want to add more item? (Yes/No)");
//					choice = scanner.next();
//					scanner.nextLine();    //to get \n character
//				
//			} while (choice.equalsIgnoreCase("yes"));
//			
//		
////			storing items in order tables
//			
//			int min = 1000; 
//		    int max = 9999; 
//		      
//		    int order_id= (int)Math.floor(Math.random() * (max - min + 1) + min);
//		    
//		   
//		    System.out.println(userCart.size());
//		    if(userCart.size()>0){
//		    	
//		    String paymentType =paymentMode();
//		    	
//		    userCart.forEach((key,value)->{
//		    	
//		    	String query = "insert into orders values(?,?,?,?,curdate(),curtime(),?,?,?);";
//				try {
//					PreparedStatement preparedStatement = connection.prepareStatement(query);
//					preparedStatement.setInt(1, order_id);
//					preparedStatement.setInt(2, key.getItemId());
//					preparedStatement.setInt(3, customerId);
//					preparedStatement.setInt(4, key.getRestaurantId());
//					preparedStatement.setInt(5, value);
//					preparedStatement.setString(6, "Ordered");
//					preparedStatement.setString(7, paymentType);
//						
//					preparedStatement.executeUpdate();
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		    });
//		    
//		    }else{
//		    	System.out.println("No item is present inside cart");
//		    	flag= false;
//		    }
//		    
//			scanner.close();
//			connection.close();
//			return flag;
//						
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}	
//	}
	
	@Override
	public boolean placeOrder(int restaurantId,int customerId) throws ClassNotFoundException, SQLException {
		
		boolean flag= true;
		String choice;
		HashMap<Menu, Integer>userCart =new HashMap<>();
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
		Scanner scanner =new Scanner(System.in);
			
//			Addressing items to cart
		do {
				System.out.println("Select item");
				String itemName= scanner.nextLine();
				System.out.println("Enter quantity");
				int quantity =scanner.nextInt();
							
				String query="select * from menu where item_name=? and restaurant_id=?";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, itemName);
				preparedStatement.setInt(2,restaurantId );
				
				ResultSet resultSet =preparedStatement.executeQuery();
					
				if(resultSet.next()){
					Menu menu= new Menu();
					menu.setItemId(resultSet.getInt(1));
					menu.setItemName(resultSet.getString(2));
					menu.setItemPrice(resultSet.getInt(3));
					menu.setRestaurantId(resultSet.getInt(4));
					userCart.put(menu, quantity);
				}else{
					System.out.println("Enter wrong item name!!");
				}
					
				System.out.println("Want to add more item? (Yes/No)");
				choice = scanner.next();
				scanner.nextLine();    //to get \n character
				
		} while (choice.equalsIgnoreCase("yes"));
				
//			storing items in order tables
			
			int min = 1000; 
		    int max = 9999; 
		      
		    int order_id= (int)Math.floor(Math.random() * (max - min + 1) + min);
		    
		    if(userCart.size()>0){
			    String paymentType =paymentMode();
			    for(Map.Entry<Menu, Integer> entry:userCart.entrySet()){
			    	String query = "insert into orders values(?,?,?,?,curdate(),curtime(),?,?,?);";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, order_id);
					preparedStatement.setInt(2, entry.getKey().getItemId());
					preparedStatement.setInt(3, customerId);
					preparedStatement.setInt(4, entry.getKey().getRestaurantId());
					preparedStatement.setInt(5, entry.getValue());
					preparedStatement.setString(6, "Ordered");
					preparedStatement.setString(7, paymentType);
					preparedStatement.executeUpdate();
			    }
			    
			    int totalBill=generateBill(order_id);
			    
			    String bill= "Your bill for order id : "+order_id+" is Rs. "+totalBill;
			    System.out.println(bill);
		    
		    }else{
		    	System.out.println("No item is present inside cart");
		    	flag= false;
		    }
		    
			scanner.close();
			connection.close();
			
			
			return flag;	
	}


	public int generateBill(int orderId) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_court","root","Ashu123");
			
		int total=0;
		String query="select orders.quantity*menu.item_price as total from menu join orders on menu.item_id=orders.item_id where order_id=?";
			
			PreparedStatement ps=con.prepareStatement(query); 
			ps.setInt(1, orderId);
		    ResultSet rs1=ps.executeQuery();

			while(rs1.next()){
				total+=rs1.getInt(1);
			}
			
			con.close();
			
		return total;
	}
	
	public String paymentMode() {
		Scanner scanner =new Scanner(System.in);
		boolean flag=true;
		
		String paymentChoice="";
    	do {
    		System.out.println("Select payment mode/n 1. Cash on delivery/n 2.Online Payment");
    		int choice =scanner.nextInt();
    		switch (choice) {
    		case 1:
    			paymentChoice="COD";
    			flag=false;
    			break;
    		case 2:
    			paymentChoice="Online";
    			flag=false;
    			break;
    		default:
    			System.out.println("Invalid option");
    			break;
    		}
		} while (flag);
    	
    	scanner.close();
    	
    	return paymentChoice;
	}



	@Override
	public Customer createCustomer() {
		
		Scanner sc =new Scanner(System.in);
		Customer c=new Customer();
		System.out.println("Enter Your Name  :");
		c.setCustomerName(sc.next());
		System.out.println("Enter Your Phone :");
		c.setCustomerPhone(sc.nextLong());
		System.out.println("Enter Your Address:");
		c.setCustomerAddress(sc.next());
		System.out.println("Enter Your Email :");
		c.setCustomerEmail(sc.next());
		System.out.println("Enter Your Password:");
		c.setCustomerPassword(sc.next());
		System.out.println("Enter Your City :");
		c.setCustomerCity(sc.next());
		sc.close();
		
		return c;
	}


	
}
