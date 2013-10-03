package main.java.com.epam.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.controller.service.UserService;
import main.java.com.epam.model.user.Status;

import org.apache.log4j.Logger;

public class SubmitToRollServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(SubmitToRollServlet.class);
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void init() {
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] checkedIds = request.getParameterValues("checkedRows");
		if (checkedIds != null) {
			for (int i = 0; i < checkedIds.length; i++) {
				userService.setUserStatus(Integer.parseInt(checkedIds[i]), Status.ENROLLED);
				LOGGER.info(userService.getUserById(Integer.parseInt(checkedIds[i])).getLastName() + " status was changed to " + Status.ENROLLED);
			}
		}
		response.sendRedirect("/SelectionCommittee/entrants");
	}

}
