package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.Solution;

public class SolutionDao {

	public static final List<Solution> loadAll() throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.selectAllSolutions());
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final List<Solution> loadAll(int limit) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectAllSolutionsWithLimit(), limit);
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final Solution loadById(int id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectSolutionById(), id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs).get(0);
		}
	}

	public static final List<Solution> loadAllByUserId(long id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final List<Solution> loadAllByExcerciseId(int id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectAllSolutionsByExerciseId(), id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final Solution save(Solution s) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, "id")) {
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				s.setId(rs.getInt(1));
				return s;
			}
		}
	}

	public static final Solution update(Solution s) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = conn.prepareStatement(Query.updateSolution())) {
			ps.executeUpdate();
			return s;
		}
	}

	public static final Solution delete(Solution s) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = conn.prepareStatement(Query.deleteSolution())) {
			ps.executeUpdate();
			s.setId(0);
			return s;
		}
	}

	private static final List<Solution> load(ResultSet rs) throws SQLException {
		List<Solution> solutions = new ArrayList<>();
		while (rs.next()) {
			solutions.add(new Solution(rs.getInt("id"), rs.getString("created"), rs.getString("updated"),
					rs.getString("description"), rs.getInt("exercise_id"), rs.getLong("users_id")));
		}
		return solutions;
	}

	private static final PreparedStatement create(Connection conn, String query, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String... genCol) throws SQLException {
		return conn.prepareStatement(Query.insertSolution(), genCol);
	}

	private static final PreparedStatement create(Connection conn, long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.selectAllSolutionsByUserId());
		ps.setLong(1, id);
		return ps;
	}

}
