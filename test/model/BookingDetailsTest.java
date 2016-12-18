package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookingDetailsTest {
	@Test
	public void test() {
		BookingDetails bookingDetails=TestDataFactory.getTestBookingDetails();

		assertThat(bookingDetails.getRid(),is(1));
		assertThat(bookingDetails.getUser().getRid(),is(1));
		assertThat(bookingDetails.getRoom().getRid(),is(1));
		assertThat(bookingDetails.getStartMonth(),is(12));
		assertThat(bookingDetails.getStartDay(),is(20));
		assertThat(bookingDetails.getStartHour(),is(10));
		assertThat(bookingDetails.getStartMinute(),is(10));
		assertThat(bookingDetails.getPeriodHour(),is(20));
		assertThat(bookingDetails.getPeriodMinute(),is(20));

	}
}
