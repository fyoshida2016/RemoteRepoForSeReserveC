package db;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import common.TestDataBase;
import model.BookingDetails;
import model.Room;
import model.TestDataFactory;
import model.User;

public class BookingManagerTest {

	@Test
	public void 予約を読み込む() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story09/dbaccess_test.xls");

		// データベースから予約を読み込み
		BookingManager rm=new BookingManager();
		BookingDetails bookingDetails=rm.getBookingDetails(1);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(bookingDetails.getRid(),is(1));
		assertThat(bookingDetails.getUser().getRid(),is(1));
		assertThat(bookingDetails.getRoom().getRid(),is(1));
		assertThat(bookingDetails.getStartYear(),is(2016));
		assertThat(bookingDetails.getStartMonth(),is(12));
		assertThat(bookingDetails.getStartDay(),is(20));
		assertThat(bookingDetails.getStartHour(),is(10));
		assertThat(bookingDetails.getStartMinute(),is(10));
		assertThat(bookingDetails.getPeriodHour(),is(20));
		assertThat(bookingDetails.getPeriodMinute(),is(20));
	}

}