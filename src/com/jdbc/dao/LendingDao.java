package com.jdbc.dao;

import com.jdbc.model.Lending;
import com.jdbc.utility.DBConnection;
import lombok.Builder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
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
        Lending lending = Lending.builder().build();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                lending.setBookId(res.getLong("book_id"));
                lending.setBorrowerId(res.getLong("borrower_id"));
                lending.setStaffId(res.getLong("staff_id"));
                lending.setLendDate(res.getString("lend_date"));
                lending.setReturnDate(res.getString("return_date"));
                lending.setBookStatus(res.getBoolean("book_status"));
                lending.setId(id);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(lending);
    }

    @Override
    public List<Lending> getAll() {
        List<Lending> lending = new ArrayList<Lending>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {

                Lending lend =  Lending.builder().build();

                lend.setId(res.getLong("id"));
                lend.setBookId(res.getLong("book_id"));
                lend.setBorrowerId(res.getLong("borrower_id"));
                lend.setStaffId(res.getLong("staff_id"));
                lend.setLendDate(res.getString("lend_date"));
                lend.setReturnDate(res.getString("return_date"));
                lend.setBookStatus(res.getBoolean("book_status"));

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
            statement.setBoolean(6,lending.isBookStatus());
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
            statement = DBConnection.getConnection().prepareStatement(UPDATE);

            statement.setLong(1, lending.getBookId());
            statement.setLong(2, lending.getBorrowerId());
            statement.setLong(3, lending.getStaffId());
            statement.setString(4, lending.getLendDate());
            statement.setString(5, lending.getReturnDate());
            statement.setBoolean(6, lending.isBookStatus());
            statement.setLong(7, id);

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
