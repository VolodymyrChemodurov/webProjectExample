package main.java.com.epam.controller.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	int createItem(T item);
	
	T getItemById(int id);
	
	List<T> getAllItems();

}
