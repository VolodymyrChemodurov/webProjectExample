package main.java.com.epam.controller.dao.transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.com.epam.controller.dao.concrete.MarkSheetDAOImpl;
import main.java.com.epam.model.marksheet.MarkSheet;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

import org.apache.log4j.Logger;

public class UserTransformer implements GenericTransformer<User> {
	private static final Logger LOGGER = Logger.getLogger(UserTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO users"
			+ "(firstName, lastName, login, password, status) VALUES(?, ?, ?, ?, ?)";
	private MarkSheetDAOImpl markSheetDAO;

	public UserTransformer() {
		markSheetDAO = new MarkSheetDAOImpl();
	}

	@Override
	public PreparedStatement forObjectToStatement(User object, Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, object.getFirstName());
			statement.setString(2, object.getLastName());
			statement.setString(3, object.getLogin());
			statement.setString(4, object.getPassword());
			statement.setString(5, object.getStatus().toString());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public User fromResultSetToObject(ResultSet resultSet) {
		User user = new User();
		try {
			user.setId(resultSet.getInt("id"));
			user.setFirstName(resultSet.getString("firstName"));
			user.setLastName(resultSet.getString("lastName"));
			user.setLogin(resultSet.getString("login"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(Status.valueOf(resultSet.getString("status").toUpperCase()));
			user.setMarkSheetId(resultSet.getInt("marks_id"));
			user.setFacultyId(resultSet.getInt("fac_id"));
			setMarks(user, resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

	private void setMarks(User user, ResultSet resultSet) {
		MarkSheet marks = markSheetDAO.getItemById(user.getMarkSheetId());
		if (marks != null) {
			user.setMarks(marks);
			if (user.getStatus() == Status.ENTRANT) {
				user.getMarks().setAvgMark(0);
			}
		}
	}
	
}
