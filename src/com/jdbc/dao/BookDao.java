package com.jdbc.dao;

import com.jdbc.model.Book;
import com.jdbc.utility.DBConnection;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class BookDao implements Dao<Book> {
    private PreparedStatement statement;

    private static final String BOOK_TABLE_NAME = TableNames.BOOK.name();
    private static final String FIND_BY_ID = "select * from " + BOOK_TABLE_NAME + " where id = ?";
    private static final String FIND_ALL = "select * from " + BOOK_TABLE_NAME;
    private static final String INSERT = "insert into " + BOOK_TABLE_NAME + " (name, author_name,category_id,book_status) values(?,?,?,?)";
    private static final String UPDATE = "update " + BOOK_TABLE_NAME + " set name=?, author_name=?, category_id=?, book_status=? where( id = ?)";
    private static final String DELETE = "delete from " + BOOK_TABLE_NAME + " where id=?";

    @Override
    public Optional<Book> get(long id) {
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
    public List<Book> getAll() {
        List<Book> books = new ArrayList<Book>();
        try {
            statement = DBConnection.getConnection().prepareStatement(FIND_ALL);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Book book = new Book();
                book.setId(res.getLong("id"));
                book.setBookName(res.getString("name"));
                book.setAuthorName(res.getString("author_name"));
                book.setIdCategory(res.getString("category_id"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int save(Book book) {
        try {
            statement = DBConnection.getConnection().prepareStatement(INSERT);
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthorName());
            statement.setString(3, book.getIdCategory());
            int res = statement.executeUpdate();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return -1;
    }

    @Override
    public int update(Book book, long id) {
        try {
            statement = DBConnection.getConnection().prepareStatement(UPDATE);
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getAuthorName());
            statement.setString(3, book.getIdCategory());
            statement.setLong(4, book.getId());

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
