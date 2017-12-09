package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.Exercise;

public class ExerciseDao {

	public static final List<Exercise> loadAll() throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.selectAllExercises());
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final Exercise loadById(int id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs).get(0);
		}
	}

	public static final Exercise save(Exercise e) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, "id")) {
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				e.setId(rs.getInt(1));
				return e;
			}
		}
	}

	public static final Exercise update(Exercise e) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.updateExercise())) {
			ps.executeUpdate();
			return e;
		}
	}

	public static final Exercise delete(Exercise e) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.deleteExercise())) {
			ps.executeUpdate();
			e.setId(0);
			return e;
		}
	}

	private static final List<Exercise> load(ResultSet rs) throws SQLException {
		List<Exercise> excercises = new ArrayList<>();
		while (rs.next()) {
			excercises.add(new Exercise(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
		}
		return excercises;
	}

	private static final PreparedStatement create(Connection conn, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.selectExerciseById());
		ps.setInt(1, id);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String... genCol) throws SQLException {
		return conn.prepareStatement(Query.insertExercise(), genCol);
	}
}
