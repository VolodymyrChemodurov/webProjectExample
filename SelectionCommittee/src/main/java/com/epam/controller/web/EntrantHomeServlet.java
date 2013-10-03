package main.java.com.epam.controller.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.com.epam.controller.service.FacultyService;

public class EntrantHomeServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(EntrantHomeServlet.class);
	private static final long serialVersionUID = 1L;
	private FacultyService facultyService;

	public void init() {
		facultyService = new FacultyService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getFaculties(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getFaculties(request, response);
	}

	private void getFaculties(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("faculties", facultyService.getFaculties());
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index_entrant.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
	}

}
