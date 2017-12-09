package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.SolutionDto;

public class SolutionDtoDao {

	public static final List<SolutionDto> loadAll() throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.selectAllSolutionsUsersExercise());
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final List<SolutionDto> loadAll(int limit) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectAllSolutionsUsersExerciseWithLimit(), limit);
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final List<SolutionDto> loadAllByUserId(long id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectAllSolutionsUsersExerciseByUserId(), id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	private static final List<SolutionDto> load(ResultSet rs) throws SQLException {
		List<SolutionDto> solutions = new ArrayList<>();
		while (rs.next()) {
			solutions.add(new SolutionDto(rs.getInt("solution.id"), rs.getString("solution.updated"),
					rs.getInt("exercise.id"), rs.getString("exercise.title"), rs.getLong("users.id"),
					rs.getString("users.username")));
		}
		return solutions;
	}

	private static final PreparedStatement create(Connection conn, String query, int limit) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, limit);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String query, long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, id);
		return ps;
	}

}
