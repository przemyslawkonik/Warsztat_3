package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.User;

public class UserDao {

	public static final List<User> loadAll() throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.selectAllUsers());
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final List<User> loadAllByGroupId(int id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final User loadById(long id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectUserById(), id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs).get(0);
		}
	}

	public static final User save(User u) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, u, "id")) {
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				u.setId(rs.getLong(1));
				return u;
			}
		}
	}

	public static final User update(User u) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, u)) {
			ps.executeUpdate();
			return u;
		}
	}

	public static final User delete(User u) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, Query.deleteUser(), u.getId())) {
			ps.executeUpdate();
			u.setId(0);
			return u;
		}
	}

	private static final List<User> load(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			users.add(new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"),
					rs.getString("password"), rs.getInt("user_group_id")));
		}
		return users;
	}

	private static final PreparedStatement create(Connection conn, User u, String... genCol) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.insertUser(), genCol);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		ps.setInt(4, u.getUserGroupId());
		return ps;
	}

	private static final PreparedStatement create(Connection conn, User u) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.updateUser());
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		ps.setInt(4, u.getUserGroupId());
		ps.setLong(5, u.getId());
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String query, long id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, id);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.selectAllUsersByGroupId());
		ps.setInt(1, id);
		return ps;
	}
}
