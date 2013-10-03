package main.java.com.epam.controller.dao.transformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface GenericTransformer<T> {

	PreparedStatement forObjectToStatement(T object, Connection connection);
	
	T fromResultSetToObject(ResultSet resultSet);
}
