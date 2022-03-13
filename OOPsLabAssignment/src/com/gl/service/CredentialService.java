package com.gl.service;

import com.gl.model.Employee;

public class CredentialService {

	// method to generate password of 8 characters
	public void generatePassword(Employee employee) {
		String numbers = "0123456789";
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$%&";

		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 2; i++) {
			sb.append(smallLetters.charAt((int) (Math.random() * smallLetters.length())));
			sb.append(capitalLetters.charAt((int) (Math.random() * capitalLetters.length())));
			sb.append(numbers.charAt((int) (Math.random() * numbers.length())));
			sb.append(specialCharacters.charAt((int) (Math.random() * specialCharacters.length())));
		}

		String generatedPassword = sb.toString();
		String password = "";

		// shuffle the generated password
		while (generatedPassword.length() != 0) {
			int index = (int) (Math.random() * generatedPassword.length());
			char c = generatedPassword.charAt(index);
			generatedPassword = generatedPassword.substring(0, index) + generatedPassword.substring(index + 1);
			password += c;

		}
		employee.setPassword(password);

	}

	/*
	 * method to generate the email address as
	 * firstNamelastName@department.company.com Here compamy name is taken as "gl"
	 */
	public void generateEmailAddress(Employee employee) {
		String department = employee.getDepartment();
		if (department.equals("Technical")) {
			department = "tech";
		} else if (department.equals("Admin")) {
			department = "adm";
		} else if (department.equals("Human Resource")) {
			department = "hr";
		} else {
			department = "lgl";
		}
		employee.setEmailId(employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() + "@"
				+ department + ".gl.com");

	}

	// method to display the generated emailId and password
	public void showCredentials(Employee employee) {
		System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email    --->  " + employee.getEmailId());
		System.out.println("Password --->  " + employee.getPassword());

	}

}
