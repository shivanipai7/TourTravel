package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import com.training.dao.BookTourDao;
import com.training.dao.LoginDao;
import com.training.dao.TourDao;
import com.training.entity.Login;
import com.training.utils.DbConnection;

/**
 * Servlet implementation class LoginAndRegister
 */
public class LoginAndRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private LoginDao dao;
	private TourDao tourDao;
	private BookTourDao bookTourDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAndRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException
    {
    	con = DbConnection.getOracleConnection();
    	dao = new LoginDao(con);
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
        String servletPath = request.getServletPath();
		switch(servletPath) 
		{
		  case "/Register" :
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String servletPath = request.getServletPath();
		
		switch(servletPath) {
		
		case "/Registration" :
			userRegister(request, response);
			break;		
		case "/Login" :
			userLogin(request, response);
			break;
		}
	}
private void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  {
		
		long userId = Long.parseLong(request.getParameter("userId"));
//		String userEmail = request.getParameter("userEmail");
		String passWord = request.getParameter("passWord");
		String userType = request.getParameter("userType");
		
		Login log = new Login(userId, passWord, userType);
		
		try {
			dao.add(log);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		Long userId = Long.parseLong(request.getParameter("userId"));
		String passWord = request.getParameter("passWord");
		
		Login log = null;
		
		try {
			log = dao.findById(userId);
			request.setAttribute("tourList", tourDao.findAllDetails());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(log==null) {
			
			request.setAttribute("errorMessage", "User ID does not exsist");
			request.getRequestDispatcher("/").forward(request, response);
			
		}
		else if(log.getPassWord().equals(passWord)) {
			
			request.getSession().setAttribute("sessionId", log.getUserId());
			request.getSession().setAttribute("sessionDate", LocalDate.now());
			
			if(log.getUserType().equals("customer")) {
				try {
					request.setAttribute("bookingList", bookTourDao.findById(userId));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("BookTours.jsp").forward(request, response);
			}
			
			if(log.getUserType().equals("employee")) {
				try {
					request.setAttribute("bookingList", bookTourDao.findAllBookings());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("ToursChanges.jsp").forward(request, response);
			}			
		}
		else {
			
			request.setAttribute("errorMessage", "User details incorrect");
			request.getRequestDispatcher("/").forward(request, response);
		}
	
	}

}
