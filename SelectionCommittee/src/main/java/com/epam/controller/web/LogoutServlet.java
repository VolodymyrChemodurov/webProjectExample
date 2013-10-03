package main.java.com.epam.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String userName = (String)session.getAttribute("userLastName");
			session.invalidate();
			LOGGER.info(userName + " logout.");
		}
		response.sendRedirect("jsp/login.jsp");
	}

}
