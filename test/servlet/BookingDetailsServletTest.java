package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.BookingDetails;

public class BookingDetailsServletTest extends TestServlet {

	@Test
	public void 管理者ログインに成功する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story09/BookingDetailsServlet_test.xls");

		// POSTメソッドを指定
		setPost();

		// テキストボックスに入力値を設定
		webRequest.setParameter("RID", "1");

		// Servletを呼び出す。
		callServlet();

		assertThat(session.getAttribute("BookingDetails"),notNullValue());

		BookingDetails bd = (BookingDetails)session.getAttribute("BookingDetails");
		assertThat(bd.getStartYear(),is(2016));
		assertThat(bd.getStartMonth(),is(12));
		assertThat(bd.getStartDay(),is(5));
		assertThat(bd.getStartHour(),is(13));
		assertThat(bd.getStartMinute(),is(0));
		assertThat(bd.getPeriodHour(),is(1));
		assertThat(bd.getPeriodMinute(),is(30));

	}
}
