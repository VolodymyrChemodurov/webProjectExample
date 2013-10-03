package main.java.com.epam.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.epam.controller.service.UserService;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void init() {
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = null;
		if ((user = userService.getUser(login, password)) != null) {
			userSessionBuilder(request.getSession(), user);
			LOGGER.info(user.getLastName() + " log in.");
			if (user.getStatus() == Status.ADMINISTRATOR) {
				adminProcess(request, response);
			} else {
				userProcess(request, response);
			}
		} else {
			LOGGER.info("Fail to log in.");
			request.getSession().setAttribute("message", "Wrong login or password");
			response.sendRedirect("jsp/login.jsp");
		}
	}

	private void userSessionBuilder(HttpSession session, User user) {
		session.setAttribute("userLastName", user.getLastName());
		session.setAttribute("userFirstName", user.getFirstName());
		session.setAttribute("userId", user.getId());
		if (user.getFacultyId() != 0)
			session.setAttribute("userFacultyId", user.getFacultyId());
	}

	private void adminProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().setAttribute("admin", "true");
			response.sendRedirect("/SelectionCommittee/entrants");
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	private void userProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().setAttribute("user", "true");
			response.sendRedirect("/SelectionCommittee/faculties");
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
}
