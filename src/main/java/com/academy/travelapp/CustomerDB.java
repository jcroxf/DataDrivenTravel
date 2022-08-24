package com.academy.travelapp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerDB extends BaseDB implements Customer {

	private static final String SQL_QUERY = "SELECT ticket.Price, ticket.TravelType, ticket.StationStart, ticket.StationEnd, ticket.CustomerId, ticket.TicketId FROM Ticket ticket, Customer customer WHERE customer.Id = '%s' AND ticket.CustomerId = customer.Id"; 
	
	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return null;
	}

}
