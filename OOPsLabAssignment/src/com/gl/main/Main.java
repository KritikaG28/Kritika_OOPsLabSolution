package com.gl.main;

import java.util.Scanner;

import com.gl.model.Employee;
import com.gl.service.CredentialService;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Welcome to GL IT Depatment\n");
		System.out.println("Please Enter Firstname:: ");
		String firstname = scanner.next();
		System.out.println("Please Enter Lastname:: ");
		String lastname = scanner.next();
		Employee employee = new Employee(firstname, lastname);

		do {
			System.out.println("\n\nPlease enter the department from the following \n1. Technical"
					+ "\n2. Admin\n3. Human Resource\n4. Legal");
			option = scanner.nextInt();
			switch (option) {
			case 1: {
				employee.setDepartment("Technical");
				break;
			}
			case 2: {
				employee.setDepartment("Admin");
				break;
			}
			case 3: {
				employee.setDepartment("Human Resource");
				break;
			}
			case 4: {
				employee.setDepartment("Legal");
				break;
			}
			default:
				System.out.println("Invalid input");
			}
		} while (option < 1 || option > 4);

		scanner.close();

		CredentialService cs = new CredentialService();

		cs.generateEmailAddress(employee);
		cs.generatePassword(employee);
		cs.showCredentials(employee);

		System.out.println("\nThank you");

	}

}
