package com.jdbc.dao;

import com.jdbc.model.Role;
import com.jdbc.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDao implements Dao<Role> {
    private PreparedStatement statement;

    private static final String ROLE_TABLE_NAME = TableNames.ROLE.name();
    private static final String FIND_BY_ID = "select * from " + ROLE_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + ROLE_TABLE_NAME;
    private static final String INSERT = "insert into " + ROLE_TABLE_NAME + " (role_name) values(?)";
    private static final String UPDATE = "update " + ROLE_TABLE_NAME + " set role_name=? where( id = ?)";
    private static final String DELETE = "delete from " + ROLE_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Role> get(long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = new ArrayList<Role>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Role role = new Role();
                role.setId(res.getLong("id"));
                role.setRoleName(res.getString("role_name"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public int save(Role role) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, role.getRoleName());
            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    @Override
    public int update(Role role, long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, role.getRoleName());
            statement.setLong(2, role.getId());

            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(DELETE);
            statement.setLong(1, id);
            int res = statement.executeUpdate();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return -1;
    }
}