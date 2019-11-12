package com.training.entity;

public class Tour {

	private long tourCode;
	private String tourName;
	private String description;
	private String sourcePlace;
	private String destinationPlace;
	private long price;
	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tour(long tourCode, String tourName, String description, String sourcePlace, String destinationPlace,
			long price) {
		super();
		this.tourCode = tourCode;
		this.tourName = tourName;
		this.description = description;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.price = price;
	}
	public long getTourCode() {
		return tourCode;
	}
	public void setTourCode(long tourCode) {
		this.tourCode = tourCode;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Tour [tourCode=" + tourCode + ", tourName=" + tourName + ", description=" + description
				+ ", sourcePlace=" + sourcePlace + ", destinationPlace=" + destinationPlace + ", price=" + price + "]";
	}
}
