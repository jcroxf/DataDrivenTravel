package com.academy.travelapp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerDB extends BaseDB implements Customer {

	private static final String SQL_QUERY = "SELECT ticket.Price, ticket.TravelType, ticket.StationStart, ticket.StationEnd, ticket.CustomerId, ticket.TicketId FROM Ticket ticket, Customer customer WHERE customer.Id = '%s' AND ticket.CustomerId = customer.Id"; 
	private static final String SQL_RELATE ="UPDATE Ticket SET customerId ='%s' WHERE Id = '%s'";
	private static final String SQL_WRITE_OWNER = "INSERT INTO Customer (Id, Name) VALUES ('%s', '%s')";
	
	private List<Ticket> transport = new ArrayList<Ticket>();
	
	protected CustomerDB(String name) {
		this.name = validate(name,MAX_NAME);
		this.write(String.format(SQL_WRITE_OWNER,this,uuid.toString(),this.name));
		}
		
	@Override
	public void buyTicket(Ticket ticket) {
		write(String.format(SQL_RELATE, this.uuid.toString(),((TicketDB)ticket).uuid.toString()));
		}
		
	@Override
	public List<Ticket> getTickets() {
		this.transport.clear();
		read(String.format(SQL_QUERY, this.uuid.toString()));
		return this.transport;
		}
	
	@Override
	public void process(ResultSet results) {
		try {
				while(results.next()) {
					int price = results.getInt("ticket.Price");
					UUID uuid = UUID.fromString(results.getString("ticket.TicketId"));
					String TravelType = results.getString("ticket.TravelType");
					String StationStart = results.getString("ticket.StationStart");
					String StationEnd = results.getString("ticket.StationEnd");
					
					if (TravelType.equals("T")) {
						this.transport.add(Factory.loadedTrainTickets(uuid,price,StationStart,StationEnd));
						}else if (TravelType.equals("B")) {
							this.transport.add(Factory.loadedBusTickets(uuid,price,StationStart,StationEnd));
							}
				}
			}catch(Exception ex) {
				throw new RuntimeException("Failed to query transport", ex);
			}
	}

}
