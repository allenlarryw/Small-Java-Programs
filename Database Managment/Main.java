package mySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connection connection = null; // connection test
		PersonDaoImpl pdi = new PersonDaoImpl();
		pdi.createPersonTable(); // creates table
		Person person = new Person("tom", "johnson"); // person Constructor
		pdi.insert(person); // pass person object into the personDaoClass //
							// Method insert
		System.out.println();
		person.setFirstName("tim");
		person.setLastName("fohnson");
		pdi.update(person, 3);
		System.out.println();

		Person aPerson = pdi.selectById(7); // select the person by there id
											// number method
		System.out.println("You have selected this person by id " + aPerson.getId() + " " + aPerson.getFirstName() + " "
				+ aPerson.getLastName());
		System.out.println();
		pdi.delete(8); // delete method deletes a record based on the id
		System.out.println();

		List<Person> persons = pdi.selectAll();
		System.out.println("The Current Information in the Database is\n");
		for (Person x : persons) {

			System.out.println(
					"id Number: " + x.getId() + " First Name: " + x.getFirstName() + " Last Name: " + x.getLastName());

		}
	}

}