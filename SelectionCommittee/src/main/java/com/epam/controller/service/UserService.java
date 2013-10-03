package main.java.com.epam.controller.service;

import java.util.List;

import main.java.com.epam.controller.dao.concrete.UserDAOImpl;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

public class UserService {
	private UserDAOImpl dao;
	
	public UserService() {
		dao = new UserDAOImpl();
	}

	public User getUser(String login, String password) {
		User user = dao.getAccount(login, password);
		return user;
	}

	public List<User> getUsersByStatus(Status status) {
		return dao.getUserByStatus(status);
	}
	
	public int registerUser(User user) {
		return dao.createItem(user);
	}
	
	public void setUserStatus(int userId, Status status) {
		dao.setUserStatus(userId, status);
	}
	
	public void setUserMarks(int userId, int markSheetId) {
		dao.setUserMarks(userId, markSheetId);
	}

	public void setFaculty(int userId, int facultyId) {
		dao.setFaculty(userId, facultyId);
	}
	
	public User getUserById(int id) {
		return dao.getItemById(id);
	}
	
}