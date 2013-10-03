package main.java.com.epam.controller.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import main.java.com.epam.controller.exception.UserParameterNotSetException;
import main.java.com.epam.controller.service.UserService;
import main.java.com.epam.controller.setters.UserSetter;
import main.java.com.epam.model.user.Status;
import main.java.com.epam.model.user.User;

public class RegistrationServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);
	private static final long serialVersionUID = 1L;
	private UserService service;
	
	public void init() {
		service = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		try {
			user = createUser(request.getParameterMap());
		} catch (UserParameterNotSetException e) {
			LOGGER.error(e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/registration.jsp");
			request.setAttribute("message", "Not all required fields are set");
			dispatcher.forward(request, response);
			return;
		}
		if(service.registerUser(user) != 0) {
			response.sendRedirect("jsp/login.jsp");
		} else {
			response.sendRedirect("jsp/registration.jsp");
		}
	}
	
	private User createUser(Map<String, String[]> parameters) throws UserParameterNotSetException{
		User user = new User();
		for(UserSetter field: UserSetter.values()) {
			String value = parameters.get(field.getValue())[0];
			if(value != "")
				field.setField(user, value);
			else throw new UserParameterNotSetException(field.getValue() + " not set");
		}
		user.setStatus(Status.USER);
		return user;
	}

}
