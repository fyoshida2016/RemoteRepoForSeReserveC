package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.BookingDetails;
import model.Room;
import model.User;


public class BookingManager extends DataBaseManager{

	protected Object copyRecord(ResultSet rs) throws Exception{
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setRid(rs.getInt("RID"));
		int userRid=rs.getInt("UserRID");
		int roomRid=rs.getInt("RoomRID");
		bookingDetails.setStartYear(rs.getInt("StartYear"));
		bookingDetails.setStartMonth(rs.getInt("StartMonth"));
		bookingDetails.setStartDay(rs.getInt("StartDay"));
		bookingDetails.setStartHour(rs.getInt("StartHour"));
		bookingDetails.setStartMinute(rs.getInt("StartMinute"));
		bookingDetails.setPeriodHour(rs.getInt("PeriodHour"));
		bookingDetails.setPeriodMinute(rs.getInt("PeriodMinute"));

		UserManager um=new UserManager();
		User user=um.getUser(userRid);
		bookingDetails.setUser(user);

		RoomManager rm=new RoomManager();
		Room room=rm.getRoom(roomRid);
		bookingDetails.setRoom(room);

		return bookingDetails;
	}

	public BookingDetails getBookingDetails(int rid){
		String sql = "";
		sql += "Select * from ReservationInfo Where ";
		sql += " RID = "+rid;
		return (BookingDetails)getRecord(sql);
	}
}
