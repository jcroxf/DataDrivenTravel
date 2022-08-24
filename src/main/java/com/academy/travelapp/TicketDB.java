package com.academy.travelapp;

public class TicketDB extends BaseDB implements Ticket {

	 protected final int pricePerMile = 25;
	    protected int price;
	    protected String travelType;
	    protected String stationStart;
	    protected String stationEnd;
	    protected int distance;



	   @Override
	    public int getPrice() {
	        // TODO Auto-generated method stub
	        this.price = pricePerMile * distance;
	        return this.price;
	    }



	   @Override
	    public String getTravelType() {
	        // TODO Auto-generated method stub
	        
	        return this.travelType;
	    }



	   @Override
	    public String GetStationStart() {
	        // TODO Auto-generated method stub
	        return this.stationStart;
	    }



	   @Override
	    public String GetStationEnd() {
	        // TODO Auto-generated method stub
	        return this.stationEnd;
	    }



	}
