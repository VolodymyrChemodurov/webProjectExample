package main.java.com.epam.controller.dao;

import main.java.com.epam.model.faculty.Faculty;

public interface FacultyDAO extends GenericDAO<Faculty> {
	
	public void setFacultyReceptionStatus(int id, String status);
	
}
