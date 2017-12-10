package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class SolutionAdd
 */
@WebServlet("/solutionAdd")
public class SolutionAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionAdd() {
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
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("users", UserDao.loadAll());
            request.setAttribute("exercises", ExerciseDao.loadAll());
            getServletContext().getRequestDispatcher("/solutionAdd.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}