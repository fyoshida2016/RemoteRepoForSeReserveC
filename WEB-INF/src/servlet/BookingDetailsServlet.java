package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.BookingManager;
import model.BookingDetails;

@WebServlet(name = "BookingDetailsServlet", urlPatterns = { "/BookingDetailsServlet" })
public class BookingDetailsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	public void doMain(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session=req.getSession();

		int rid = Integer.parseInt(req.getParameter("RID"));

		BookingManager bm = new BookingManager();
		BookingDetails bd =  bm.getBookingDetails(rid);

		session.setAttribute("BookingDetails", bd);
		req.getRequestDispatcher("ReservationDetails.jsp").forward(req, res);
	}
}
