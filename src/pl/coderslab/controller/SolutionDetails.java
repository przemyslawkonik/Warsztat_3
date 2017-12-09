package pl.coderslab.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;

/**
 * Servlet implementation class SolutionDetails
 */
@WebServlet("/solutionDetails")
public class SolutionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolutionDetails() {
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
			int solutionId = Integer.parseInt(request.getParameter("solution_id"));
			int excerciseId = Integer.parseInt(request.getParameter("exercise_id"));
			request.setAttribute("solution", SolutionDao.loadById(solutionId));
			request.setAttribute("exercise", ExerciseDao.loadById(excerciseId));
			getServletContext().getRequestDispatcher("/solutionDetails.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
