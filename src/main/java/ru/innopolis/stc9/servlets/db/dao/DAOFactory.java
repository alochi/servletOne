package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DAOFactory<T> implements GenericDAO<T>{
    private ConnectionManager connectionManager;

    public abstract String getSelectQuery();

    protected abstract List<T> parseResultSet(ResultSet rs);

/*    @Override
    public T getById(int id) throws SQLException {
        List<T> list;
        String sql =getSelectQuery();
        sql += "WHERE id = ?";
        try(PreparedStatement statement = connectionManager.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id)
        }
    }*/
}
