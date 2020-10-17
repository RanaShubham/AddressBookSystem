package AddressBookSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	static Scanner input = new Scanner (System.in);
	
	//Initializing an AddressBook
	static Map<String,AddressBookSystem> AddressBook1 = new HashMap<String,AddressBookSystem>();
	
	//Main method
	public static void main(String[] args) 
	{
		System.out.println("Welcome to address book system program");
		collectDetails();
		moreOptions();
		input.close();
	}

	//To display and execute more options for the address book
	private static void moreOptions() 
	{
		System.out.println("Select more options");
		System.out.println("Enter 1 to edit a record"
				+ "\nEnter 3 to exit");
		int response = input.nextInt();
		
		switch (response)
		{
			case 1: System.out.println("Enter the first name of the person whose record you want to edit");
					String nameToEdit = input.next();
					editRecord(nameToEdit);
					break;
			case 2: System.out.println("Enter first name of the person whose record you want to delete");
					String nameToDelete = input.next();
			 		deleteRecord(nameToDelete);
			 		break;
			case 3: System.exit(0);
		}
		
	}


	//Asking user for details of the record to be added
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
						
			String firstName = input.next();
			String lastName = input.next();
			String address = input.next();
			String city = input.next();
			String state = input.next();
			String email = input.next();
			int pin = input.nextInt();
			long phoneNumber = input.nextLong();
	
			addRecord(AddressBook1, firstName, lastName, address, city, state, email, pin, phoneNumber);
			
			System.out.println("Enter y to add one more person record. Otherwise enter n.");
			String response = input.next();
			
			if (response.equals("n"))
			{
				break;
			}
		}
	}
		

	//Adding person details into address book.
	private static void addRecord(Map<String,AddressBookSystem> record, String firstName, String lastName, String address, String city, String state, String email, int pin, long phoneNumber)
	{
		record.put(firstName,new AddressBookSystem(firstName, lastName, address, city, state, email, pin, phoneNumber));
	}
	
	//Deleting a record using first name
	private static void deleteRecord(String nameToDelete) 
	{
		AddressBook1.remove(nameToDelete);
	}
	
	
	//Editing a record using first name
	private static void editRecord(String nameToEdit)
	{
		AddressBookSystem recordToEdit = AddressBook1.get(nameToEdit);
		
		System.out.println("Pick a feild to edit"+
				"Enter 1 to edit firstName\n" + 
				"Enter 2 to edit lastName\n" + 
				"Enter 3 to edit address\n" + 
				"Enter 4 to edit city\n" + 
				"Enter 5 to edit state\n" + 
				"Enter 6 to edit email\n" +
				"Enter 7 to edit pin\n" +
				"Enter 8 to edit phoneNumber");
		
		int response = input.nextInt();
		
		switch(response)
		{
			case 1: editFirstname(recordToEdit);
					break;
			case 2: editLastname(recordToEdit);
					break;
			case 3: editAddress(recordToEdit);
					break;
			case 4: editCity(recordToEdit);
					break;
			case 5: editState(recordToEdit);
					break;
			case 6: editEmail(recordToEdit);
					break;
			case 7: editPin(recordToEdit);
					break;
			case 8: editPhoneNumber(recordToEdit);
					break;
		}
	}

	//To change pin of existing record
	private static void editPin(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new zip number");
		int response = input.nextInt();
		
		recordToEdit.zip = response;		
	}

	//To change last name of existing record
	private static void editLastname(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new last name");
		String response = input.next();
		
		recordToEdit.lastName = response;
	}

	//To change phone number of existing record
	private static void editPhoneNumber(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new phone number");
		long response = input.nextLong();
		
		recordToEdit.phoneNumber = response;
	}

	//To change email of existing record
	private static void editEmail(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new email");
		String response = input.next();
		
		recordToEdit.email = response;
	}

	//To change state name of existing record
	private static void editState(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new state");
		String response = input.next();
		
		recordToEdit.state = response;		
	}

	//To change city name of existing record
	private static void editCity(AddressBookSystem recordToEdit) 
	{

		System.out.println("Enter new city");
		String response = input.next();
		
		recordToEdit.city = response;
	}

	//To change address of existing record
	private static void editAddress(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new address");
		String response = input.next();
		
		recordToEdit.address = response;		
	}

	//To change first name of existing record
	private static void editFirstname(AddressBookSystem recordToEdit) 
	{
		System.out.println("Enter new firstName");
		String response = input.next();
		
		recordToEdit.firstName = response;
	}
	

}
