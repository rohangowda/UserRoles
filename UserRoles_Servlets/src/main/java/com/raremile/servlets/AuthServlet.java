package com.raremile.servlets;

import java.io.IOException;
import java.util.List;

import com.raremile.common.CommonConstants;
import com.raremile.common.DatabaseManager;
import com.raremile.common.PropertiesManager;
import com.raremile.dal.UserDAL;
import com.raremile.dal.UserProfileDAL;
import com.raremile.entities.User;
import com.raremile.entities.UserProfile;
import com.raremile.exception.NonFatalException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authentication Servlet, validates the details
 * 
 * @author RohanV
 *
 */

public class AuthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int priority[] = new int[10];
		int maximum = -1;
		String priorityRole = null;
		for (int count = 0; count < 10; count++) {
			priority[count] = -1;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		List<UserProfile> userProfile = null;
		UserDAL userDal = new UserDAL();
		UserProfileDAL userProfileDal = new UserProfileDAL();
		user = userDal.getUserData(username);
		if (password.equals(user.getUserPassword())) {
			request.setAttribute("username", username);
			userProfile = userProfileDal.getRoleData(user.getUserID());

			// assigning priorities
			for (int counter = 0; counter < userProfile.size(); counter++) {
				if (userProfile.get(counter).getUserRole().equals("admin")) {
					priority[counter] = 3;
				} else if (userProfile.get(counter).getUserRole()
						.equals("manager")) {
					priority[counter] = 2;
				} else {
					priority[counter] = 1;
				}
			}

			for (int count = 0; count < 10; count++) {
				if (priority[count] > maximum) {
					maximum = priority[count];
				}
			}

			if (maximum == 3) {
				priorityRole = "admin";
			} else if (maximum == 2) {
				priorityRole = "manager";
			} else if (maximum == 1) {
				priorityRole = "coder";
			}
			request.setAttribute("primaryRole", priorityRole);
			request.setAttribute("roles", userProfile);
		} else {
			request.setAttribute("username", "Invalid password");
			request.setAttribute("roles", "No roles to fetch.");
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/view/auth.jsp");
		rd.forward(request, response);
	}
}
