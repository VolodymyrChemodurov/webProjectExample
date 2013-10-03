package main.java.com.epam.controller.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.controller.service.FacultyService;

import org.apache.log4j.Logger;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(WelcomeServlet.class);
	private FacultyService facultyService;
       
	public void init() {
		facultyService = new FacultyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("faculties", facultyService.getFaculties());
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
	}
}
