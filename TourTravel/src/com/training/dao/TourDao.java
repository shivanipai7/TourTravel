package com.training.dao;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Login;
import com.training.entity.Tour;
import java.sql.*;

public class TourDao {

private Connection con;
	
	public TourDao(Connection con) 
	{
		super();
		this.con = con;
	}

	public int add(Tour t) throws SQLException 
	{

		String sql = "insert into tour2 values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, t.getTourCode());
		pstmt.setString(2, t.getTourName());
		pstmt.setString(3, t.getDescription());
		pstmt.setString(4, t.getSourcePlace());
		pstmt.setString(5, t.getDestinationPlace());
		//description  =   "startdate" + startdate + ", enddate" + enddate;
		pstmt.setLong(6, t.getPrice());

		int rowAdded = pstmt.executeUpdate();
		return rowAdded;
	}


	public List<Tour> findAllDetails() throws SQLException 
	{
		String sql = "select * from tour2";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet resultSet = pstmt.executeQuery();
		
		List<Tour> tourList = new ArrayList<>();
		
		while(resultSet.next())
		{
			long tourCode = resultSet.getLong(1);
			String tourName = resultSet.getString(2);
			String description = resultSet.getString(3);
			String sourcePlace = resultSet.getString(4);
			String destinationPlace = resultSet.getString(5);
			Long price = resultSet.getLong(6);
		
			Tour tour = new Tour(tourCode,tourName,description,sourcePlace,destinationPlace,price);
			tourList.add(tour);
		}
		return tourList;
	}

	public Tour findByTourCode(long tourCode) throws SQLException 
	{
		String sql = "select * from tour2 where tourCode=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, tourCode);
		ResultSet resultSet = pstmt.executeQuery();
		
		if(resultSet.next()) {
			String tourName = resultSet.getString(2);
			String description = resultSet.getString(3);
			String sourcePlace = resultSet.getString(4);
			String destinationPlace = resultSet.getString(5);
			Long price = resultSet.getLong(6);
			
			Tour tour = new Tour(tourCode,tourName,description,sourcePlace,destinationPlace,price);
			return tour;
			}
		return null;
	}
	

	public List<Tour> findBySourcePlace(String sourcePlace) throws SQLException {
		
		String sql = "select * from tour2 where sourcePlace=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sourcePlace);
		ResultSet resultSet = pstmt.executeQuery();
		
		List<Tour> tourList = new ArrayList<>();
		
		while(resultSet.next()) {
			
			long tourCode = resultSet.getLong(1);
			String tourName = resultSet.getString(2);
			String destinationPlace = resultSet.getString(4);
			String description = resultSet.getString(5);
			long price = resultSet.getLong(6);
			
			tourList.add(new Tour(tourCode, tourName, sourcePlace, destinationPlace, description, price));
		}
		
		return tourList;
	}
	

	public List<Tour> findByDestinationPlace(String destinationPlace) throws SQLException {
		
		String sql = "select * from tour2 where destinationPlace=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, destinationPlace);
		ResultSet resultSet = pstmt.executeQuery();
		
		List<Tour> tourList = new ArrayList<>();
		
		while(resultSet.next()) {
			
			long tourCode = resultSet.getLong(1);
			String tourName = resultSet.getString(2);
			String sourcePlace = resultSet.getString(3);
			String description = resultSet.getString(5);
			long cost = resultSet.getLong(6);
			
			tourList.add(new Tour(tourCode, tourName, sourcePlace, destinationPlace, description, cost));
		}
		
		return tourList;
	}

	public List<Tour> findBySourceAndDestination(String sourcePlace, String destinationPlace) throws SQLException 
	{
		
		String sql = "select * from tour2 where sourcePlace=? and destinationPlace=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sourcePlace);
		pstmt.setString(2, destinationPlace);
		ResultSet resultSet = pstmt.executeQuery();
		
		List<Tour> tourList = new ArrayList<>();
		
		while(resultSet.next()) 
		{
			long tourCode = resultSet.getLong(1);
			String tourName = resultSet.getString(2);
			String description = resultSet.getString(5);
			long price = resultSet.getLong(6);
			tourList.add(new Tour(tourCode,tourName,description,sourcePlace,destinationPlace,price));
		}
		return tourList;
	}
	
	

	
	public int update(Tour t) throws SQLException 
	{
		String sql = "update tour2 set tourName=?, description=?, sourcePlace=?,destinationPlace=?,price=? where tourCode=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		pstmt.setString(1, t.getTourName());
		pstmt.setString(2, t.getDescription());
		pstmt.setString(3, t.getSourcePlace());
		pstmt.setString(4, t.getDestinationPlace());
	    pstmt.setLong(5, t.getPrice());
	    pstmt.setLong(6, t.getTourCode());
	    
		int rowAdded = pstmt.executeUpdate();
		return rowAdded;
	}

	
	public int remove(long tourCode) throws SQLException 
	{
		String sql = "delete from tour2 where tourCode=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, tourCode);
		
		int rowAdded = pstmt.executeUpdate();
		return rowAdded;
	}

	public int add(Login t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Login> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
