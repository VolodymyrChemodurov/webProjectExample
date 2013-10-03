package main.java.com.epam.controller.dao.transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.com.epam.controller.dao.concrete.UserDAOImpl;
import main.java.com.epam.model.faculty.Faculty;

import org.apache.log4j.Logger;

public class FacultyTransformer implements GenericTransformer<Faculty> {
	private static final Logger LOGGER = Logger.getLogger(FacultyTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO faculties(name, seatsCount) VALUES(? , ?)";
	private UserDAOImpl userDAO;

	public FacultyTransformer() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public PreparedStatement forObjectToStatement(Faculty object, Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, object.getName());
			statement.setInt(2, object.getSeatsCount());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Faculty fromResultSetToObject(ResultSet resultSet) {
		Faculty currentFaculty = new Faculty();
		try {
			currentFaculty.setName(resultSet.getString("name"));
			currentFaculty.setSeatsCount(resultSet.getInt("seatsCount"));
			currentFaculty.setId(resultSet.getInt("id"));
			currentFaculty.setReception(resultSet.getString("reception"));
			currentFaculty.setEntrants(userDAO.getUsersByFaculty(currentFaculty.getId()));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentFaculty;
	}

}
