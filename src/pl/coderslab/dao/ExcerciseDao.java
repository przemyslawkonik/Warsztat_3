package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.Excercise;

public class ExcerciseDao {

	public static final List<Excercise> loadAll() throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.selectAllExcercises());
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final Excercise loadById(int id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs).get(0);
		}
	}

	public static final Excercise save(Excercise e) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, "id")) {
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				e.setId(rs.getInt(1));
				return e;
			}
		}
	}

	public static final Excercise update(Excercise e) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.updateExcercise())) {
			ps.executeUpdate();
			return e;
		}
	}

	public static final Excercise delete(Excercise e) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.deleteExcercise())) {
			ps.executeUpdate();
			e.setId(0);
			return e;
		}
	}

	private static final List<Excercise> load(ResultSet rs) throws SQLException {
		List<Excercise> excercises = new ArrayList<>();
		while (rs.next()) {
			excercises.add(new Excercise(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
		}
		return excercises;
	}

	private static final PreparedStatement create(Connection conn, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.selectExcerciseById());
		ps.setInt(1, id);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String... genCol) throws SQLException {
		return conn.prepareStatement(Query.insertExcercise(), genCol);
	}
}
