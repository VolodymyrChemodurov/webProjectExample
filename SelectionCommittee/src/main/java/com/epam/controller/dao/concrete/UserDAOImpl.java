package main.java.com.epam.controller.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.epam.controller.dao.UserDAO;
import main.java.com.epam.controller.dao.connection.ConnectionManager;
import main.java.com.epam.controller.dao.transformer.UserTransformer;
import main.java.com.epam.controller.dao.utils.DAOUtils;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

import org.apache.log4j.Logger;

public class UserDAOImpl implements UserDAO {
	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	private final static String GET_BY_ID = "SELECT * FROM users WHERE id = ?";
	private final static String GET_BY_FACULTY_ID = "SELECT * from users WHERE fac_id = ?";
	private final static String VERIFY_USER = "SELECT * FROM users WHERE login = ? AND password = ?";
	private final static String SET_STATUS = "UPDATE users SET status = ? WHERE id = ?";
	private final static String SET_MARKS = "UPDATE users SET marks_id = ? WHERE id = ?";
	private final static String SET_FACULTY = "UPDATE users SET fac_id = ? WHERE id = ?";
	private final static String GET_BY_STATUS = "SELECT * FROM users WHERE status = ?";
	private UserTransformer transformer;

	public UserDAOImpl() {
		transformer = new UserTransformer();
	}

	@Override
	public User getItemById(int id) {
		User user = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				user = transformer.fromResultSetToObject(result);
				return user;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return user;
	}

	@Override
	public List<User> getAllItems() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int createItem(User item) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = transformer.forObjectToStatement(item, connection);
			if(statement != null) {
				statement.executeUpdate();
				generatedKeys = statement.getGeneratedKeys();
				generatedKeys.next();
				return generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(generatedKeys, statement, connection);
		}
		return 0;
	}

	@Override
	public List<User> getUsersByFaculty(int id) {
		List<User> users = new ArrayList<User>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_FACULTY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while (result.next()) {
				users.add(transformer.fromResultSetToObject(result));
			}
			return users;
		} catch (SQLException e) {
			LOGGER.equals(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return users;
	}

	@Override
	public List<User> getUserByStatus(Status status) {
		List<User> users = new ArrayList<User>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_STATUS);
			statement.setString(1, status.toString());
			result = statement.executeQuery();
			while (result.next()) {
				users.add(transformer.fromResultSetToObject(result));
			}
			return users;
		} catch (SQLException e) {
			LOGGER.equals(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return users;
	}

	@Override
	public User getAccount(String login, String password) {
		User user = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(VERIFY_USER);
			statement.setString(1, login);
			statement.setString(2, password);
			result = statement.executeQuery();
			if (result.next()) {
				user = transformer.fromResultSetToObject(result);
				return user;
			}
		} catch (SQLException e) {
			LOGGER.equals(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return user;
	}

	@Override
	public void setUserMarks(int userId, int markSheetId) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SET_MARKS);
			statement.setInt(2, userId);
			statement.setInt(1, markSheetId);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
	}

	@Override
	public void setUserStatus(int userId, Status status) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SET_STATUS);
			statement.setInt(2, userId);
			statement.setString(1, status.toString());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
	}

	@Override
	public void setFaculty(int userId, int facultyId) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SET_FACULTY);
			statement.setInt(2, userId);
			statement.setInt(1, facultyId);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
	}

}
