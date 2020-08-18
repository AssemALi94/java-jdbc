package com.jdbc.dao;

import com.jdbc.model.Lending;
import com.jdbc.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LendingDao implements Dao<Lending> {
    private PreparedStatement statement;

    private static final String LENDING_TABLE_NAME = TableNames.LENDING.name();
    private static final String FIND_BY_ID = "select * from " + LENDING_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + LENDING_TABLE_NAME;
    private static final String INSERT = "insert into " + LENDING_TABLE_NAME + " (book_id, borrower_id, staff_id, lend_date, return_date, book_status) values(?,?,?,?,?,?)";
    private static final String UPDATE = "update " + LENDING_TABLE_NAME + " set book_id=?, borrower_id=?, staff_id=?, lend_date=?, return_date=?, book_status=? where( id = ?)";
    private static final String DELETE = "delete from " + LENDING_TABLE_NAME + " where id = ?";

    @Override
    public Optional<Lending> get(long id) {
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
    public List<Lending> getAll() {
        List<Lending> lending = new ArrayList<Lending>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Lending lend = new Lending();
                lend.setId(res.getLong("id"));
                lend.setBookId(res.getLong("book_id"));
                lend.setBorrowerId(res.getLong("borrower_id"));
                lend.setStaffId(res.getLong("staff_id"));
                lend.setLendDate(res.getString("lend_date"));
                lend.setReturnDate(res.getString("return_id"));
                lend.setBookStatus(res.getString("book_status"));

                lending.add(lend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lending;
    }

    @Override
    public int save(Lending lending) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setLong(1, lending.getBookId());
            statement.setLong(2, lending.getBorrowerId());
            statement.setLong(3, lending.getStaffId());
            statement.setString(4, lending.getLendDate());
            statement.setString(5, lending.getReturnDate());
            statement.setString(6, lending.getBookStatus());

            int res = statement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;
    }

    @Override
    public int update(Lending lending, long id) {
        try {
            statement.setLong(1, lending.getBookId());
            statement.setLong(2, lending.getBorrowerId());
            statement.setLong(3, lending.getStaffId());
            statement.setString(4, lending.getLendDate());
            statement.setString(5, lending.getReturnDate());
            statement.setString(6, lending.getBookStatus());
            statement.setLong(7, lending.getId());

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
