package main.java.com.epam.controller.dao.transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import main.java.com.epam.model.marksheet.MarkSheet;

public class MarkSheetTransformer implements GenericTransformer<MarkSheet> {
	private static final Logger LOGGER = Logger.getLogger(MarkSheetTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO mark_sheets(certificate, " +
			"mathematics, physics, english, ukrainian) VALUES(?, ?, ?, ?, ?)";

	@Override
	public PreparedStatement forObjectToStatement(MarkSheet object, Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, object.getCertificate());
			statement.setInt(2, object.getMathematics());
			statement.setInt(3, object.getPhysics());
			statement.setInt(4, object.getEnglish());
			statement.setInt(5, object.getUkrainian());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public MarkSheet fromResultSetToObject(ResultSet resultSet) {
		MarkSheet markSheet = new MarkSheet();
		try {
			markSheet.setCertificate(resultSet.getInt("certificate"));
			markSheet.setEnglish(resultSet.getInt("english"));
			markSheet.setMathematics(resultSet.getInt("mathematics"));
			markSheet.setPhysics(resultSet.getInt("physics"));
			markSheet.setUkrainian(resultSet.getInt("ukrainian"));
			markSheet.setAvgMark(calculateAVGMark(markSheet));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return markSheet;
	}
	
	private double calculateAVGMark(MarkSheet markSheet) {
		double avg = markSheet.getCertificate() + markSheet.getEnglish() 
				+ markSheet.getMathematics() + markSheet.getPhysics() + markSheet.getUkrainian();
		return avg/5;
	}
}
