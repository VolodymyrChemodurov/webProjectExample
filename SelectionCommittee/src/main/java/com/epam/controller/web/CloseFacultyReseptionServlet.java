package main.java.com.epam.controller.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.controller.comparator.UserAVGMarkComparator;
import main.java.com.epam.controller.service.FacultyService;
import main.java.com.epam.controller.service.UserService;
import main.java.com.epam.model.faculty.Faculty;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

import org.apache.log4j.Logger;

public class CloseFacultyReseptionServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(CloseFacultyReseptionServlet.class);
	private static final long serialVersionUID = 1L;
	private FacultyService facultyService;
	private UserService userService;

	public void init() {
		facultyService = new FacultyService();
		userService = new UserService();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int facultyId = Integer.parseInt(request.getParameter("fac_id"));
		Faculty faculty = facultyService.getFacultyById(facultyId);
		List<User> entrants = faculty.getEntrants();
		determineAcceptedEntrants(faculty, entrants);
		facultyService.setFacultyReceptionStatus(facultyId, "NO");
		response.sendRedirect("/SelectionCommittee/entrants");
	}

	private void determineAcceptedEntrants(Faculty faculty, List<User> entrants) {
		int seatCounter = 0;
		boolean freeSeatsflag = true;
		Collections.sort(entrants, new UserAVGMarkComparator());
		for (User entrant : entrants) {
			if (seatCounter == faculty.getSeatsCount()) {
				freeSeatsflag = false;
			}
			if (freeSeatsflag && entrant.getStatus() == Status.ENROLLED) {
				userService.setUserStatus(entrant.getId(), Status.ACCEPTED);
				seatCounter++;
			} else {
				userService.setUserStatus(entrant.getId(), Status.REJECTED);
			}
			LOGGER.info(entrant.getLastName() + " status changed");
		}
	}
}
