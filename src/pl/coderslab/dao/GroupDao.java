package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.Group;

public class GroupDao {

	public static final List<Group> loadAll() throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = conn.prepareStatement(Query.selectAllGroups());
				ResultSet rs = ps.executeQuery()) {
			return load(rs);
		}
	}

	public static final Group loadById(int id) throws SQLException {
		try (Connection conn = DbUtil.getConn();
				PreparedStatement ps = create(conn, Query.selectGroupById(), id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs).get(0);
		}
	}

	public static final Group save(Group g) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, g, "id")) {
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				g.setId(rs.getInt(1));
				return g;
			}
		}
	}

	public static final Group update(Group g) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, g)) {
			ps.executeUpdate();
			return g;
		}
	}

	public static final Group delete(Group g) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, Query.deleteGroup(), g.getId())) {
			ps.executeUpdate();
			g.setId(0);
			return g;
		}
	}

	private static final List<Group> load(ResultSet rs) throws SQLException {
		List<Group> groups = new ArrayList<>();
		while (rs.next()) {
			groups.add(new Group(rs.getInt("id"), rs.getString("name")));
		}
		return groups;
	}

	private static final PreparedStatement create(Connection conn, Group g) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.updateGroup());
		ps.setString(1, g.getName());
		ps.setInt(2, g.getId());
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String query, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, Group g, String... genCol) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.insertGroup(), genCol);
		ps.setString(1, g.getName());
		return ps;
	}

}
