package com.jdbc.dao;

import com.jdbc.model.Category;
import com.jdbc.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao implements Dao<Category> {
    private PreparedStatement statement;

    private static final String CATEGORY_TABLE_NAME = TableNames.CATEGORY.name();
    private static final String FIND_BY_ID = "select * from " + CATEGORY_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + CATEGORY_TABLE_NAME;
    private static final String INSERT = "insert into " + CATEGORY_TABLE_NAME + " (category_name) values(?)";
    private static final String UPDATE = "update " + CATEGORY_TABLE_NAME + " set category_name=? where( id = ?)";
    private static final String DELETE = "delete from " + CATEGORY_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Category> get(long id) {
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
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Category category = new Category();
                category.setId(res.getLong("id"));
                category.setCategoryName(res.getString("category_name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public int save(Category category) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, category.getCategoryName());
            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {

        }

        return -1;
    }

    @Override
    public int update(Category category, long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, category.getCategoryName());
            statement.setLong(2, category.getId());

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
