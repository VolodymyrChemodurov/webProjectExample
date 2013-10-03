package main.java.com.epam.controller.service;

import java.util.List;

import main.java.com.epam.controller.dao.concrete.FacultyDAOImpl;
import main.java.com.epam.model.faculty.Faculty;

public class FacultyService {
	private FacultyDAOImpl dao;
	
	public FacultyService() {
		dao = new FacultyDAOImpl();
	}

	public List<Faculty> getFaculties() {
		List<Faculty> faculties = dao.getAllItems();
		return faculties;
	}
	
	public Faculty getFacultyById(int id) {
		Faculty faculty = dao.getItemById(id);
		return faculty;
	}
	
	public void setFacultyReceptionStatus(int id, String status) {
		dao.setFacultyReceptionStatus(id, status);
	}
}
