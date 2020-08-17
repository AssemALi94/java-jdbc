package com.jdbc.dao;

import com.jdbc.model.Borrow;
import com.jdbc.model.Rate;
import com.jdbc.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BorrowDao implements Dao<Borrow> {
    private PreparedStatement statement;

    private static final String BORROW_TABLE_NAME = TableNames.BORROW.name();
    private static final String FIND_BY_ID = "select * from " + BORROW_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + BORROW_TABLE_NAME;
    private static final String INSERT = "insert into " + BORROW_TABLE_NAME + " (user_id, book_id,b_status) values(?,?,?)";
    private static final String UPDATE = "update " + BORROW_TABLE_NAME + " set user_id=?,book_id =?,b_status=? where( id = ?)";
    private static final String DELETE = "delete from " + BORROW_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Borrow> get(long id) {
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
    public List<Borrow> getAll() {
        List<Borrow> borrows = new ArrayList<Borrow>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Borrow borrow = new Borrow();
                borrow.setId(res.getLong("id"));
                borrow.setUserId(res.getString("user_id"));
                borrow.setBookId(res.getString("book_id"));
                borrow.setBStatus(res.getString("b_status"));

                borrows.add(borrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrows;
    }

    @Override
    public int save(Borrow borrow) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, borrow.getUserId());
            statement.setString(1, borrow.getBookId());
            statement.setString(1, borrow.getBStatus());
            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    @Override
    public int update(Borrow borrow, long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, borrow.getUserId());
            statement.setString(2, borrow.getBookId());
            statement.setString(3, borrow.getBStatus());
            statement.setLong(4, borrow.getId());

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
