package main.java.com.epam.controller.dao.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.java.com.epam.controller.dao.MarkSheetDAO;
import main.java.com.epam.controller.dao.connection.ConnectionManager;
import main.java.com.epam.controller.dao.transformer.MarkSheetTransformer;
import main.java.com.epam.controller.dao.utils.DAOUtils;
import main.java.com.epam.model.marksheet.MarkSheet;

import org.apache.log4j.Logger;

public class MarkSheetDAOImpl implements MarkSheetDAO {
	private static final Logger LOGGER = Logger.getLogger(MarkSheetDAOImpl.class);
	private final static String GET_BY_ID = "SELECT * FROM mark_sheets WHERE id = ?";
	private MarkSheetTransformer transformer;

	public MarkSheetDAOImpl() {
		this.transformer = new MarkSheetTransformer();
	}

	@Override
	public MarkSheet getItemById(int id) {
		Connection connection = ConnectionManager.getConnection();
		MarkSheet markSheet = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				markSheet = transformer.fromResultSetToObject(result);
				return markSheet;
			}
		} catch (SQLException e) {
			LOGGER.equals(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return markSheet;
	}

	@Override
	public int createItem(MarkSheet item) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet generatedId = null;
		try {
			statement = transformer.forObjectToStatement(item, connection);
			if(statement != null) {
				statement.executeUpdate();
				generatedId = statement.getGeneratedKeys();
				generatedId.next();
				return generatedId.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(generatedId, statement, connection);
		}
		return 0;
	}

	@Override
	public List<MarkSheet> getAllItems() {
		throw new UnsupportedOperationException();
	}

}
