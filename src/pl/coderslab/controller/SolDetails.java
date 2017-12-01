package pl.coderslab.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.dao.UserDao;

/**
 * Servlet implementation class SolDetails
 */
@WebServlet("/solDetails")
public class SolDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolDetails() {
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
			int userId = Integer.parseInt(request.getParameter("user_id"));
			int excerciseId = Integer.parseInt(request.getParameter("excercise_id"));
			request.setAttribute("user", UserDao.loadById(userId));
			request.setAttribute("excercise", ExcerciseDao.loadById(excerciseId));
			getServletContext().getRequestDispatcher("/solDetails.jsp").forward(request, response);
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
	}

}
