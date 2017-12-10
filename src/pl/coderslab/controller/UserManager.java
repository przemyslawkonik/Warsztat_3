package pl.coderslab.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

/**
 * Servlet implementation class UserManager
 */
@WebServlet("/userManager")
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String idStr = request.getParameter("id");
			if (idStr != null) {
				long id = Long.parseLong(idStr);
				UserDao.delete(UserDao.loadById(id));
			}

			request.setAttribute("users", UserDao.loadAll());
			getServletContext().getRequestDispatcher("/userManager.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int userGroupId = Integer.parseInt(request.getParameter("group_id"));

		try {
			if (id == 0) {
				UserDao.save(new User(username, email, password, userGroupId));
			} else {
				User u = UserDao.loadById(id);
				u.setUsername(username);
				u.setEmail(email);
				u.setPassword(password);
				u.setUserGroupId(userGroupId);
				UserDao.update(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/Warsztat_3/userManager");
	}

}
