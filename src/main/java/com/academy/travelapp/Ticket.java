package com.academy.travelapp;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public interface Ticket extends base {

	public int getPrice();
	public String getTravelType();
	public String GetStationStart();
	public String GetStationEnd();
}
