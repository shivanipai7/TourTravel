package com.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.BookTour;

public class BookTourDao {

private Connection con;
	
	public BookTourDao(Connection con) {
		super();
		this.con = con;
	}

	

	public int addBookings(BookTour t) throws SQLException {

		String sql = "insert into booktour3 values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, t.getUserId());
		pstmt.setLong(2, t.getTourCode());
	
		Date date = Date.valueOf(t.getBookingDate());
		pstmt.setDate(3, date);
		
		pstmt.setLong(4, t.getTotalTickets());
		pstmt.setDouble(5, t.getTotalAmount());
		
		int rowAdded = pstmt.executeUpdate();
		return rowAdded;
	}

	
	public List<BookTour> findById(long userId) throws SQLException {
		

		String sql = "select * from booktour3 where userId=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, userId);
		ResultSet resultSet = pstmt.executeQuery();
		
		long tourCode;
		LocalDate bookingDate;
		long totalTickets;
		double totalAmount;
		
		List<BookTour> bookTourList = new ArrayList<>();
		
		while(resultSet.next()) {
			
			tourCode = resultSet.getLong(2);
			bookingDate = resultSet.getDate(3).toLocalDate();
			totalTickets = resultSet.getLong(4);
			totalAmount = resultSet.getDouble(5);
		
		
			
			bookTourList.add(new BookTour(userId, tourCode, bookingDate,totalTickets,totalAmount ));
			}
		
		return bookTourList;
			}
		

	public List<BookTour> findByTourName(String tourName) throws SQLException {
		
		String sql = "select * from tour2 where tourName=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, tourName);
		ResultSet resultSet = pstmt.executeQuery();
		
		long tourCode = 0;
		
		if(resultSet.next())
			tourCode = resultSet.getLong(1);;
		
		sql = "select * from booktour3 where tourCode=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, tourCode);
		resultSet = pstmt.executeQuery();
		
		List<BookTour> bookTourList = new ArrayList<>();
		
		while(resultSet.next()) {
			
			Long userId = resultSet.getLong(1);
			LocalDate bookingDate = resultSet.getDate(3).toLocalDate();
			long totalTickets = Long.parseLong(resultSet.getString(4));
			double totalAmount = Double.parseDouble(resultSet.getString(5));
			
			BookTour booktour = new BookTour(userId, tourCode, bookingDate, totalTickets, totalAmount);
			
			bookTourList.add(booktour);
		}
		
		return bookTourList;
		
	}


	public List<BookTour> findAllBookings() throws SQLException {
		
		String sql = "select * from booktour3";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet resultSet = pstmt.executeQuery();
		
		List<BookTour> bookTourList = new ArrayList<>();
		
		while(resultSet.next()) {
			
			Long userId = resultSet.getLong(1);
			long tourCode = Long.parseLong(resultSet.getString(2));
			LocalDate bookingDate = resultSet.getDate(3).toLocalDate();
			long totalTickets = Long.parseLong(resultSet.getString(4));
			double totalAmount = Double.parseDouble(resultSet.getString(5));
			
			BookTour booktour = new BookTour(userId, tourCode, bookingDate, totalTickets, totalAmount);
			
			bookTourList.add(booktour);
		}
		
		return bookTourList;
	}
}
