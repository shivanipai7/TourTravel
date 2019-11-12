package com.training.entity;
import java.util.*;
public class TourList {

	private List<Tour> TourList;

	public List<Tour> getTourList() {
		return TourList;
	}

	public void addTour(Tour tour) {
		TourList.add(tour);
	}
	
}
