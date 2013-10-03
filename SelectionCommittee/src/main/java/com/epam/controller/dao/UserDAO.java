package main.java.com.epam.controller.dao;

import java.util.List;

import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

public interface UserDAO extends GenericDAO<User> {

	List<User> getUserByStatus(Status status);

	User getAccount(String login, String password);

	List<User> getUsersByFaculty(int id);

	void setUserMarks(int userId, int markSheetId);

	void setUserStatus(int userId, Status status);

	void setFaculty(int userId, int facultyId);

}
