package AddressBookSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {
	
	//AddressBook fields
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String email;
	int zip;
	long phoneNumber;
	
	//Constructor
	public AddressBookSystem(String firstname, String lastName, String address, String city, String state, String email, int zip, long phoneNumber) 
	{
		this.firstName = firstname;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}
	
	//Initializing an AddressBook
	static List<AddressBookSystem> AddressBook1 = new ArrayList<AddressBookSystem>();
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to address book system program");
		collectDetails();			
	}

	
	//Asking user for details
	private static void collectDetails()
	{
		while(true)
		{
		System.out.println("Enter details of one user in following order"
				+ "\n1. First Name"
				+ "\n2. Last Name"
				+ "\n3. Address"
				+ "\n4. City"
				+ "\n5. State"
				+ "\n6. email"
				+ "\n7. Pincode"
				+ "\n8. Phone number");
			
			Scanner input = new Scanner (System.in);
			
			String firstName = input.next();
			String lastName = input.next();
			String address = input.next();
			String city = input.next();
			String state = input.next();
			String email = input.next();
			int pin = input.nextInt();
			long phoneNumber = input.nextLong();
	
			addContact(AddressBook1, firstName, lastName, address, city, state, email, pin, phoneNumber);
			
			System.out.println("Enter y to add one more person record. Otherwise enter n.");
			String response = input.next();
			
			if (response.equals("n"))
			{
				input.close();
				break;
			}
		}
	}
		

	//Adding person details into address book.
	private static void addContact(List book, String firstName, String lastName, String address, String city, String state, String email, int pin, long phoneNumber)
	{
		book.add(new AddressBookSystem(firstName, lastName, address, city, state, email, pin, phoneNumber));
	}
		
}
