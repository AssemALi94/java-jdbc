package com.jdbc.dao;

import com.jdbc.model.Rate;
import com.jdbc.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RateDao implements Dao<Rate> {
    private PreparedStatement statement;

    private static final String RATE_TABLE_NAME = TableNames.RATE.name();
    private static final String FIND_BY_ID = "select * from " + RATE_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + RATE_TABLE_NAME;
    private static final String INSERT = "insert into " + RATE_TABLE_NAME + " (user_id, book_id,rate) values(?,?,?)";
    private static final String UPDATE = "update " + RATE_TABLE_NAME + " set user_id=?,book_id =?,rate=? where( id = ?)";
    private static final String DELETE = "delete from " + RATE_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Rate> get(long id) {
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
    public List<Rate> getAll() {
        List<Rate> rates = new ArrayList<Rate>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Rate rate = new Rate();
                rate.setId(res.getLong("id"));
                rate.setUserId(res.getString("user_id"));
                rate.setBookId(res.getString("book_id"));
                rate.setRate(res.getString("rate"));

                rates.add(rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rates;
    }

    @Override
    public int save(Rate rate) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, rate.getUserId());
            statement.setString(1, rate.getBookId());
            statement.setString(1, rate.getRate());
            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    @Override
    public int update(Rate rate, long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, rate.getUserId());
            statement.setString(1, rate.getBookId());
            statement.setLong(2, rate.getId());

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
