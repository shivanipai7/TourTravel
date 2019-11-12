package com.training.entity;
import java.time.LocalDate;
public class BookTour {

	private long userId;
	private long tourCode;
	private LocalDate bookingDate;
	private long totalTickets;
	private double totalAmount;
	public BookTour(long userId, long tourCode, LocalDate bookingDate, long totalTickets, double totalAmount) {
		super();
		this.userId = userId;
		this.tourCode = tourCode;
		this.bookingDate = bookingDate;
		this.totalTickets = totalTickets;
		this.totalAmount = totalAmount;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTourCode() {
		return tourCode;
	}
	public void setTourCode(long tourCode) {
		this.tourCode = tourCode;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public long getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(long totalTickets) {
		this.totalTickets = totalTickets;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
