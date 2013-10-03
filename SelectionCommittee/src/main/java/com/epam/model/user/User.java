package main.java.com.epam.model.user;

import main.java.com.epam.model.marksheet.MarkSheet;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Status status;
	private MarkSheet marks;
	private int markSheetId;
	private int facultyId;
	
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public MarkSheet getMarks() {
		return marks;
	}
	public void setMarks(MarkSheet marks) {
		this.marks = marks;
	}
	public int getMarkSheetId() {
		return markSheetId;
	}
	public void setMarkSheetId(int markSheetId) {
		this.markSheetId = markSheetId;
	}

	
}
