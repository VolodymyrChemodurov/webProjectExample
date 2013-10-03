package main.java.com.epam.controller.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.controller.comparator.UserAVGMarkComparator;
import main.java.com.epam.controller.comparator.UserStatusComparator;
import main.java.com.epam.controller.service.FacultyService;
import main.java.com.epam.model.faculty.Faculty;
import main.java.com.epam.model.user.User;

public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacultyService service;

	public void init() {
		service = new FacultyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int facultyId = Integer.parseInt(request.getParameter("faculty"));
		Faculty faculty = service.getFacultyById(facultyId);
		sortEntrants(faculty.getEntrants());
		request.getSession(false).setAttribute("facultyId", faculty.getId());
		request.setAttribute("faculty", faculty);
		if ((request.getSession(false).getAttribute("userFacultyId")) != null) {
			request.setAttribute("allreadyRegistred", true);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/faculty.jsp");
		dispatcher.forward(request, response);
	}

	private void sortEntrants(List<User> entrants) {
		Collections.sort(entrants, new UserAVGMarkComparator());
		Collections.sort(entrants, new UserStatusComparator());
	}

}
