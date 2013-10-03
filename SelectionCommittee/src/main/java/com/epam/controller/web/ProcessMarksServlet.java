package main.java.com.epam.controller.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.epam.controller.exception.MarkSheetParameterNotSetException;
import main.java.com.epam.controller.service.FacultyService;
import main.java.com.epam.controller.service.MarkSheetService;
import main.java.com.epam.controller.service.UserService;
import main.java.com.epam.controller.setters.MarkSheetSetter;
import main.java.com.epam.model.marksheet.MarkSheet;
import main.java.com.epam.model.user.Status;

import org.apache.log4j.Logger;

public class ProcessMarksServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ProcessMarksServlet.class);
	private static final long serialVersionUID = 1L;
	private MarkSheetService markSheetService;
	private UserService userService;
	private FacultyService facultyService;
	
	public void init() {
		markSheetService = new MarkSheetService();
		userService = new UserService();
		facultyService = new FacultyService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MarkSheet markSheet = createMarkSheet(request);
			int markSheetId = markSheetService.createMarkSheet(markSheet);
			updateUser(request.getSession(false), markSheetId);
			request.setAttribute("faculties", facultyService.getFaculties());
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index_entrant.jsp");
			dispatcher.forward(request, response);
		} catch (MarkSheetParameterNotSetException e) {
			LOGGER.error(e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/marks_form.jsp");
			request.setAttribute("message", "Please enter all marks");
			dispatcher.forward(request, response);
		}
	}

	private MarkSheet createMarkSheet(HttpServletRequest request)  throws MarkSheetParameterNotSetException {
		MarkSheet markSheet = new MarkSheet();
		for(MarkSheetSetter field: MarkSheetSetter.values()) {
			String value = request.getParameter(field.getValue());
			if(value != "") {
				field.setField(markSheet, value);
			} else throw new MarkSheetParameterNotSetException(field.getValue() + " not set");
		}
		return markSheet;
	}
	
	private void updateUser(HttpSession session, int markSheetId ) {
		int userId = (Integer)session.getAttribute("userId");
		userService.setUserMarks(userId, markSheetId);
		int facultyId = (Integer)session.getAttribute("facultyId");
		userService.setFaculty(userId, facultyId);
		session.setAttribute("userFacultyId", facultyId);
		userService.setUserStatus(userId, Status.ENTRANT);
	}
}
