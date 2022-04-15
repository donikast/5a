package controllers;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repositories.Repository;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Repository collection;
 
	public void init(ServletConfig config) throws ServletException {
		collection = Repository.getInstance();
	}

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int id = Integer.parseInt(request.getParameter("id"));
		User updatedUser = collection.getUserById(id);
		
		updatedUser.setPersonalName(request.getParameter("personal-name"));
		updatedUser.setJobTitle(request.getParameter("job-title"));
		updatedUser.setDescription(request.getParameter("description"));
		updatedUser.setEmail(request.getParameter("email"));
		updatedUser.setPhone(request.getParameter("phone"));

		
	}

}
