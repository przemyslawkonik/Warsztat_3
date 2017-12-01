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
				PreparedStatement ps = create(conn, id);
				ResultSet rs = ps.executeQuery()) {
			return load(rs).get(0);
		}
	}

	public static final Group save(Group g) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = create(conn, "id")) {
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				g.setId(rs.getInt(1));
				return g;
			}
		}
	}

	public static final Group update(Group g) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = conn.prepareStatement(Query.updateGroup())) {
			ps.executeUpdate();
			return g;
		}
	}

	public static final Group delete(Group g) throws SQLException {
		try (Connection conn = DbUtil.getConn(); PreparedStatement ps = conn.prepareStatement(Query.deleteGroup())) {
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

	private static final PreparedStatement create(Connection conn, int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(Query.selectGroupById());
		ps.setInt(1, id);
		return ps;
	}

	private static final PreparedStatement create(Connection conn, String... genCol) throws SQLException {
		return conn.prepareStatement(Query.insertGroup(), genCol);
	}

}
