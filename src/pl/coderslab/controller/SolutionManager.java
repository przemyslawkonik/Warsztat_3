package pl.coderslab.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;
import pl.coderslab.utils.MyDate;

/**
 * Servlet implementation class SolutionManager
 */
@WebServlet("/solutionManager")
public class SolutionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolutionManager() {
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
				int id = Integer.parseInt(idStr);
				SolutionDao.delete(SolutionDao.loadById(id));
			}

			request.setAttribute("solutions", SolutionDao.loadAll());
			getServletContext().getRequestDispatcher("/solutionManager.jsp").forward(request, response);
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
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			if (id == 0) {
				String description = request.getParameter("description");
				int exerciseId = Integer.parseInt(request.getParameter("exercise_id"));
				long userId = Long.parseLong(request.getParameter("user_id"));
				SolutionDao.save(new Solution(MyDate.get(), MyDate.get(), description, exerciseId, userId));
			} else {
				Solution s = SolutionDao.loadById(id);
				s.setUpdated(MyDate.get());
				s.setDescription(request.getParameter("description"));
				SolutionDao.update(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/Warsztat_3/solutionManager");
	}

}