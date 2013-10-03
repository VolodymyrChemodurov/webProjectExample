package main.java.com.epam.controller.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.epam.controller.dao.FacultyDAO;
import main.java.com.epam.controller.dao.connection.ConnectionManager;
import main.java.com.epam.controller.dao.transformer.FacultyTransformer;
import main.java.com.epam.controller.dao.utils.DAOUtils;
import main.java.com.epam.model.faculty.Faculty;

import org.apache.log4j.Logger;

public class FacultyDAOImpl implements FacultyDAO {
	private static final Logger LOGGER = Logger.getLogger(FacultyDAOImpl.class);
	private final static String GET_ALL_FACULTIES = "SELECT * FROM faculties";
	private final static String GET_BY_ID = "SELECT * FROM faculties WHERE id = ?";
	private final static String SET_RECEPTION_STATUS = "UPDATE faculties SET reception = ? WHERE id = ?";
	private FacultyTransformer transformer;

	public FacultyDAOImpl() {
		transformer = new FacultyTransformer();
	}

	@Override
	public Faculty getItemById(int id) {
		Faculty faculty = new Faculty();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				faculty = transformer.fromResultSetToObject(result);
				return faculty;
			}
		} catch (SQLException e) {
			LOGGER.equals(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return faculty;
	}

	@Override
	public List<Faculty> getAllItems() {
		List<Faculty> faculties = new ArrayList<Faculty>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ALL_FACULTIES);
			result = statement.executeQuery();
			while (result.next()) {
				faculties.add(transformer.fromResultSetToObject(result));
			}
			return faculties;
		} catch (SQLException e) {
			LOGGER.equals(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return faculties;
	}

	@Override
	public int createItem(Faculty item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFacultyReceptionStatus(int id, String status) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SET_RECEPTION_STATUS);
			statement.setString(1, status);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
	}

}
