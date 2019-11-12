package com.training.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.training.entity.Login;
import com.training.entity.Tour;
import com.training.ifaces.Dao;
public class LoginDao implements Dao<Login> {

private Connection con;
	
	public LoginDao(Connection con) {
		super();
		this.con = con;
	}

	public int add(Login t) throws SQLException{
		System.out.println("***Adding user to db***");
		String sql ="insert into user1 values(?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql); 	
		pstmt.setLong(1, t.getUserId());
		pstmt.setString(2, t.getPassWord());
		pstmt.setString(3, t.getUserType());
	
		int rowAdded = pstmt.executeUpdate();
		return rowAdded;
	}

	public List<Login> findAll() throws SQLException {

		return null;
	}

	@Override
	public Login findById(long userId) throws SQLException {
		
		String sql = "select * from user1 where userId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, userId);
		ResultSet resultSet = pstmt.executeQuery();
		Login log = null;
		
		if(resultSet.next()) {
			log = mapLogin(resultSet);
		}
		return log;
		
	}
	
	private Login mapLogin(ResultSet resultSet ) throws SQLException {
		
		long userId = resultSet.getLong("USERID");
		String passWord = resultSet.getString("PASSWORD");
		String userType = resultSet.getString("USERTYPE");

		Login log = new Login(userId, passWord, userType);
		
		return log;
	}

	public int add(Tour t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Tour> findAllDetails() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Tour findByTourCode(long tourCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Tour t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(long tourCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
