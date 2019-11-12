package com.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.dao.BookTourDao;
import com.training.dao.TourDao;
import com.training.utils.DbConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.training.entity.BookTour;
import com.training.entity.Tour;


/**
 * Servlet implementation class TourServlet
 */
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TourDao tourDao;
	private BookTourDao bookTourDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection con;
    public TourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException
    {
    	con = DbConnection.getOracleConnection();
    
		tourDao = new TourDao(con);
		bookTourDao = new BookTourDao(con);
    	
    }
    
    public void destroy() {
		
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Destroy Method Called");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servletPath = request.getServletPath();
		
		switch(servletPath) {
		
		case "/AddTour" :
			addTour(request, response);
			break;		
		case "/UpdateTour" :
			updateTour(request, response);
			break;
		case "/Filter" :
			tourFilter(request, response);
			break;
		case "/ByTourName" :
			filterByTourName(request, response);
			break;	
		case "/Filter1" :
			request = tourFilter(request, response);
			try {
				request.setAttribute("bookTourList", bookTourDao.findById((Long)request.getSession().getAttribute("sessionId")));
			} catch (SQLException e) {

				e.printStackTrace();
			}
			request.getRequestDispatcher("BookTours.jsp").forward(request, response);
			break;
		case "/Book" :
			book(request, response);
			break;
		}
	}
	
protected void addTour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		long tourCode = Long.parseLong(request.getParameter("tourCode"));
		String tourName = request.getParameter("tourName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String description = "startDate : " + startDate + ", endDate : " + endDate;
		String sourcePlace = request.getParameter("sourcePlace");
		String destinationPlace = request.getParameter("destinationPlace");
		long price = Long.parseLong(request.getParameter("price"));
		
		Tour tour = new Tour(tourCode,tourName,description,sourcePlace,destinationPlace,price);
		
		
		//TourDao database = new TourDao(con);
		
		
		try {
			
			tourDao.add(tour);
			request.setAttribute("tourList", tourDao.findAllDetails());
			request.setAttribute("bookTourList", bookTourDao.findAllBookings());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ToursChanges.jsp").forward(request, response);

	}
	
	private void updateTour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long tourCode = Long.parseLong(request.getParameter("tourCode"));
		String tourName = request.getParameter("tourName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String description = "startDate : " + startDate + ", endDate : " + endDate;
		String sourcePlace = request.getParameter("sourcePlace");
		String destinationPlace = request.getParameter("destinationPlace");
		long price = Long.parseLong(request.getParameter("price"));
		
		Tour tour = new Tour(tourCode,tourName,description,sourcePlace,destinationPlace,price);
		
		
		//TourDao database = new TourDao(con);
		
		try {
			tourDao.update(tour);
			request.setAttribute("tourList", tourDao.findAllDetails());
			request.setAttribute("bookTourList", bookTourDao.findAllBookings());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ToursChanges.jsp").forward(request, response);
		
	}
	


	public void addTableEnteries(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	
	

	
	private HttpServletRequest tourFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String sourcePlace = request.getParameter("sourcePlace");
	String destinationPlace = request.getParameter("destinationPlace");
	
	List<Tour> tourList = new ArrayList<>();
	//TourDao database = new TourDao(con);

	try {
		
		if(sourcePlace.equals("")&&destinationPlace.equals(""))
			tourList = tourDao.findAllDetails();
		
		else if(!sourcePlace.equals("")&&destinationPlace.equals(""))
			tourList = tourDao.findBySourcePlace(sourcePlace);
		
		else if(sourcePlace.equals("")&&!destinationPlace.equals(""))
			tourList = tourDao.findByDestinationPlace(destinationPlace);
		
		else
			tourList = tourDao.findBySourceAndDestination(sourcePlace, destinationPlace);
		
		
		request.setAttribute("tourList", tourList);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return request;
	
}
	
	private void filterByTourName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tourName = request.getParameter("tourName2");
		
		try {
			request.setAttribute("tourList", tourDao.findAllDetails());
			if(tourName.equals(""))
				request.setAttribute("bookTourList", bookTourDao.findAllBookings());
			else
				request.setAttribute("bookTourList", bookTourDao.findByTourName(tourName));
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ToursChanges.jsp").forward(request, response);
		
	}

	private void book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	{
		
		long tourCode = Long.parseLong(request.getParameter("tourCode"));
		long userId = Long.parseLong(request.getParameter("userId"));
		LocalDate bookingDate = LocalDate.parse(request.getParameter("bookingDate"));
		long totalTickets = Long.parseLong(request.getParameter("totalTickets"));
		double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
		
		BookTour booktour = new BookTour(userId, tourCode, bookingDate, totalTickets, totalAmount);
	
//		BookTourDao dao = new BookTourDao(con);
		
		try {
			bookTourDao.addBookings(booktour);
			request.setAttribute("tourList", tourDao.findAllDetails());
			request.setAttribute("bookingList", bookTourDao.findById(userId));
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("BookTours.jsp").forward(request, response);
	}




}

}
