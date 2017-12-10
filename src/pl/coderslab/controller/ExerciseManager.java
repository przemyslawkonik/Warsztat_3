package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ExerciseManager
 */
@WebServlet("/exerciseManager")
public class ExerciseManager extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseManager() {
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
                ExerciseDao.delete(ExerciseDao.loadById(id));
            }

            request.setAttribute("exercises", ExerciseDao.loadAll());
            getServletContext().getRequestDispatcher("/exerciseManager.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        try {
            if (id == 0) {
                ExerciseDao.save(new Exercise(title, description));
            } else {
                Exercise e = ExerciseDao.loadById(id);
                e.setTitle(title);
                e.setDescription(description);
                ExerciseDao.update(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Warsztat_3/exerciseManager");
    }

}
