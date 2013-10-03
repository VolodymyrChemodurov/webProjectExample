package main.java.com.epam.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.controller.service.FacultyService;
import main.java.com.epam.controller.service.UserService;
import main.java.com.epam.model.faculty.Faculty;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private FacultyService facultyService;

	public void init() {
		userService = new UserService();
		facultyService = new FacultyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> entrants = userService.getUsersByStatus(Status.ENTRANT);
		request.setAttribute("entrants", entrants);
		List<Faculty> faculties = facultyService.getFaculties();
		request.setAttribute("faculties", faculties);
		request.getRequestDispatcher("jsp/index_admin.jsp").forward(request, response);
	}

}
