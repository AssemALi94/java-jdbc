package com.jdbc.dao;

//curd operation
//create
//update
//read
//delete

public interface DAO<T> {
    public int create();
    public int update();
    public T read();
    public int delete();
}
