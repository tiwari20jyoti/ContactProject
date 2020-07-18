package testpackage;

import java.util.*;

import modelpackage.Contact;



public class ContactTest {

	public static void main(String[] args) throws Exception {

		int choice = 0;
		System.out.println("Enter your choice:");
		try (Scanner sc = new Scanner(System.in)) {
			choice =  Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.print("Your selection can only be an integer!");
		}

		Contact c = new Contact();
		switch (choice) {
		case 1:
			System.out.println("Displaying values of table");
			c.displayValues();
			break;

		case 2:
			System.out.println("Inserting into the table");
			c.insertValues();
			break;

		case 3:
			System.out.println("Updating the table");
			c.updateValues();
			break;

		case 4:
			System.out.println("Deleting from table");
			c.deleteValues();
			break;

		default:
			break;
		}
	}

}
