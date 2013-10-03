package main.java.com.epam.controller.service;

import main.java.com.epam.controller.dao.concrete.MarkSheetDAOImpl;
import main.java.com.epam.model.marksheet.MarkSheet;

public class MarkSheetService {
	private MarkSheetDAOImpl dao;
	
	public MarkSheetService() {
		dao =  new MarkSheetDAOImpl();
	}

	public MarkSheet getMarkSheetById(int id) {
		return dao.getItemById(id);
	}
	
	public int createMarkSheet(MarkSheet markSheet) {
		return dao.createItem(markSheet);
	}
}
