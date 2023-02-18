package com_ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com_entity.Customer;
import com_entity.Menu;
import com_entity.Restaurant;
import com_services.Customers_Service_Implementations;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		
		
		System.out.println("Food Court App-------------------------");
		
		Customer loggedInCustomer= null;
		
		Scanner scanner = new Scanner(System.in);
		int choice;
	
			System.out.println("\n1.Customer \n2.Restaurants");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("\n1.Login \n2.Signup");
				int choice2=scanner.nextInt();
				
				switch (choice2) {
				case 1:
					System.out.println("Enter Phone Number and Password");
					long phoneNo = scanner.nextLong(); 
					String userPassword =scanner.next();
					loggedInCustomer = new Customers_Service_Implementations().login(phoneNo,userPassword); 
					
					if(loggedInCustomer != null){
						
						
						System.out.println("\n1. Place new order \n2. View order status \n3. View past orders");
						int choose3= scanner.nextInt();
						
						switch (choose3) {
						case 1:
							ArrayList<Restaurant> restaurants = new Customers_Service_Implementations().getRestaurants();
							for(Restaurant restaurant :restaurants){
								System.out.println(restaurant.getRestautrantId()+" : "+restaurant.getRestautrantName());
							}
							System.out.println("\nSelect restaurants");
							int restaurantId= scanner.nextInt();
							
							ArrayList<Menu> menus = new ArrayList<>();
							menus= new Customers_Service_Implementations().getItems(restaurantId);
							
							for(Menu menu :menus){
								System.out.println(menu.getItemName());
							}
							
							boolean orderPlace= new Customers_Service_Implementations().placeOrder(restaurantId, loggedInCustomer.getCustomerId());
							
							if(orderPlace){
								System.out.println("Order place successfully");
							}else{
								System.out.println("Failed to place order");
							}
							break;
							
						case 2:
//							order status Method here
							break;
					
						case 3:
//							past order fun
							break;

						default:
							System.out.println("Invalid choice");
							break;
						}
						
						break;
					}
					
				case 2:
					Customer customer =new Customers_Service_Implementations().createCustomer();
					boolean userSignup=new Customers_Service_Implementations().signup(customer);
					if(userSignup){
						System.out.println("User signup successfull");
					}else{
						System.out.println("Failed to signup");
					}
					break;
				}
				break;
				
			case 2:
				System.out.println("1. Login\n 2.Signup");
				choice=scanner.nextInt();
				break;
				
			default:
				System.out.println("Invalid choice");
				break;
			}
			
			scanner.close();
		}
				
	}


