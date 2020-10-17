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
	
	/**Initializing an Address book collection to store multiple address books.
	Address book collection is of type hash map. This hash map stores name of the address book and the address book as value in form of inner hash map.
	The inner hash map (Or the address book) contains the list of objects of type AddressBookSystem as value and the first name of the person as key.
	 */
	static Map<String, HashMap<String, AddressBookSystem>> AddressBookCollection = new HashMap<String, HashMap<String, AddressBookSystem>>();
	
	//Main method
	public static void main(String[] args) 
	{
		System.out.println("Welcome to address book system program");
		Options();
		input.close();
		System.out.println("CHECKING: "+AddressBookCollection.get(book).get(shubham));
	}

	//To display and execute more options for the address book
	private static void Options() 
	{
		System.out.println("Select an option\n"+
				  "Enter 1 to edit a record\n"+
				  "Enter 2 to delete a record\n"+
				  "Enter 3 to add new record\n"+
				  "Enter 4 to exit");
		int response = input.nextInt();
		
		switch (response)
		{
			case 1: System.out.println("Enter the name fo the record you want to edit\n"
					+ "and then Enter the first name of the person whose record you want to edit");
					String recordToEdit = input.next();
					String nameToEdit = input.next();
					editRecord(nameToEdit,recordToEdit);
					break;
			case 2: System.out.println("Enter name of the record you want to delete record in\n"
					+ "and then Enter first name of the person whose record you want to delete");
					String recordToDeleteIn = input.next();
					String nameToDelete = input.next();
			 		deleteRecord(nameToDelete,recordToDeleteIn);
			 		break;
			case 3: System.out.println("Enter name of the record you want to create");
			 		String recordName = input.next();
			 		createRecord(recordName);
			 		break;
			case 4: System.exit(0);
		}
		
	}


	private static void createRecord(String recordName) 
	{
		AddressBookCollection.put(recordName, new HashMap<String,AddressBookSystem>());
		
		//Asking details for the record with name recordName
		collectDetails(recordName);
	}

	//Asking user for details of the record to be added
	private static void collectDetails(String recordName)
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
	
			addRecord(AddressBookCollection.get(recordName), firstName, lastName, address, city, state, email, pin, phoneNumber);
			
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
	private static void deleteRecord(String nameToDelete, String recordToDeleteIn) 
	{
		AddressBookCollection.get(recordToDeleteIn).remove(nameToDelete);
	}
	
	
	//Editing a record using first name
	private static void editRecord(String nameToEdit, String recordToEdit)
	{
		AddressBookSystem record = (AddressBookSystem) AddressBookCollection.get(recordToEdit).get(nameToEdit);
		
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
			case 1: editFirstname(record);
					break;
			case 2: editLastname(record);
					break;
			case 3: editAddress(record);
					break;
			case 4: editCity(record);
					break;
			case 5: editState(record);
					break;
			case 6: editEmail(record);
					break;
			case 7: editPin(record);
					break;
			case 8: editPhoneNumber(record);
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
