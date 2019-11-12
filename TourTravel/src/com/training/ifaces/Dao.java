package com.training.ifaces;
import java.sql.SQLException;
import com.training.entity.Login;
public interface Dao<T> {

	public int add(T t) throws SQLException;
    public Login findById(long userId) throws SQLException;
}
