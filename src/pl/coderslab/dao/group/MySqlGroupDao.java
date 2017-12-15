package pl.coderslab.dao.group;

import pl.coderslab.db.DbUtil;
import pl.coderslab.db.Query;
import pl.coderslab.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlGroupDao implements GroupDao {

    @Override
    public List<Group> findAll() throws SQLException {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(Query.selectAllGroups());
             ResultSet rs = ps.executeQuery()) {
            return load(rs);
        }
    }

    @Override
    public Group findById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = prepare(conn, Query.selectGroupById(), id);
             ResultSet rs = ps.executeQuery()) {
            return load(rs).get(0);
        }
    }

    @Override
    public Group save(Group entity) throws SQLException {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = prepareInsert(conn, entity)) {
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                entity.setId(rs.getInt(1));
                return entity;
            }
        }
    }

    @Override
    public Group update(Group entity) throws SQLException {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = prepareUpdate(conn, entity)) {
            ps.executeUpdate();
            return entity;
        }
    }

    @Override
    public Group delete(Group entity) throws SQLException {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = prepare(conn, Query.deleteGroup(), entity.getId())) {
            ps.executeUpdate();
            entity.setId(0);
            return entity;
        }
    }

    private List<Group> load(ResultSet rs) throws SQLException {
        List<Group> groups = new ArrayList<>();
        while (rs.next()) {
            groups.add(new Group(rs.getInt("id"), rs.getString("name")));
        }
        return groups;
    }

    private PreparedStatement prepare(Connection conn, String query, int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        return ps;
    }

    private PreparedStatement prepareInsert(Connection conn, Group g) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Query.insertGroup(), new String[]{"id"});
        ps.setString(1, g.getName());
        return ps;
    }

    private PreparedStatement prepareUpdate(Connection conn, Group g) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Query.updateGroup());
        ps.setString(1, g.getName());
        ps.setInt(2, g.getId());
        return ps;
    }

}
