package pl.coderslab.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<E> {
    List<E> findAll() throws SQLException;
    E findById(int id) throws SQLException;
    E save(E entity) throws SQLException;
    E update(E entity) throws SQLException;
    E delete(E entity) throws SQLException;
}
