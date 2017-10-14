package edu.iit.admin.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.iit.bean.OrdersMessage;
import edu.iit.dao.Books;
import edu.iit.dao.Orders;
import edu.iit.dao.OrdersDAO;
import edu.iit.util.BooksAdapter;
import edu.iit.util.OrdersAdapter;

@WebServlet(urlPatterns = "/admin/search/orders")
public class searchOrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("We get the messgae");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The string is " + jb.toString());
		// //decomposite the input json
		JsonElement jelement = new JsonParser().parse(jb.toString());
		JsonObject jobject = jelement.getAsJsonObject();
		String keyWord = decompositeJSON(jobject, "keyword");
		String operation = decompositeJSON(jobject, "operation");
		String pageSize = decompositeJSON(jobject, "pagesize");
		String pageNumber = decompositeJSON(jobject, "pagenumber");
		//
		OrdersMessage msg = process(keyWord, operation, pageNumber, pageSize);

		// send the data
		Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Orders.class, new OrdersAdapter()).create();
		System.out.println("Data we send: " + gson.toJson(msg));

		// send the data
		resp.getWriter().write(gson.toJson(msg));

	}

	public static void main(String[] args) {

		String keyword = "";
		String operation = "closed";
		String pageNumber = "1";
		String pageSize = "3";
		System.out.println("ok");
		OrdersMessage omsg = process(keyword, operation, pageNumber, pageSize);
		for (int i = 0; i < omsg.getContent().size(); i++) {
			System.out.println(omsg.getContent().get(i).getCheckinDate());
		}
		System.out.println(omsg.getTotalNumber());
	}

	public static OrdersMessage process(String keyword, String operation, String pageNumber, String pageSize) {
		OrdersDAO odao = new OrdersDAO();
		OrdersMessage omsg = new OrdersMessage();
		int num_page = Integer.valueOf(pageNumber);
		int num_pagesize = Integer.valueOf(pageSize);
		try {
			if (operation.equals("all")) {
				List<Orders> ol;
				int total_pagenumber;
				if (keyword.equals("")) {// find all order
					ol = odao.findAll(num_page, num_pagesize);
					total_pagenumber = odao.findNumOfOpendOrClosedByorNotByBookID(-1, "all");// find
																								// total
																								// num
					omsg.setTitle("All book");
				} else {// find all order by keywords
					ol = odao.findByBookIdForAll(Integer.valueOf(keyword), num_page, num_pagesize);
					total_pagenumber = odao.findNumOfOpendOrClosedByorNotByBookID(Integer.valueOf(keyword), "all");// find
																													// total
																													// num
				}

				omsg.setStatus("true");
				omsg.setTitle("All book");
				omsg.setTotalNumber(String.valueOf(total_pagenumber));
				omsg.setContent(ol);

			} else if (operation.equals("closed")) {
				List<Orders> ol;
				int total_pagenumber;
				if (keyword.equals("")) {// find all order
					ol = odao.findAllClosed(num_page, num_pagesize);
					total_pagenumber = odao.findNumOfOpendOrClosedByorNotByBookID(-1, "closed");
					omsg.setTitle("All book");
				} else {// find all order by keywords
					ol = odao.findClosedOrderByBookID(Integer.valueOf(keyword), num_page, num_pagesize);
					total_pagenumber = odao.findNumOfOpendOrClosedByorNotByBookID(Integer.valueOf(keyword), "closed");
				}

				omsg.setStatus("true");
				omsg.setTitle("Orders of book found");
				omsg.setTotapage(String.valueOf(Math.round(total_pagenumber / num_pagesize)));
				omsg.setTotalNumber(String.valueOf(total_pagenumber));
				omsg.setContent(ol);
			} else {
				List<Orders> ol;
				int total_pagenumber;
				if (keyword.equals("")) {// find all order
					ol = odao.findAllOpen(num_page, num_pagesize);
					total_pagenumber = odao.findNumOfOpendOrClosedByorNotByBookID(-1, "open");
					omsg.setTitle("All book");
				} else {// find all order by keywords
					ol = odao.findOpenOrderByBookID(Integer.valueOf(keyword), num_page, num_pagesize);
					total_pagenumber = odao.findNumOfOpendOrClosedByorNotByBookID(Integer.valueOf(keyword), "closed");
				} // order
				omsg.setStatus("true");
				omsg.setTitle("Orders of book found");
				omsg.setTotapage(String.valueOf(Math.round(total_pagenumber / num_pagesize)));
				omsg.setTotalNumber(String.valueOf(total_pagenumber));
				omsg.setContent(ol);
			}
			return omsg;
		} catch (Exception e) {
			omsg.setStatus("false");
			omsg.setTitle("error!");
			omsg.setContent(null);
			return omsg;
		}
	}

	public String decompositeJSON(JsonObject jsonObject, String attr) {
		String result = ((jsonObject.get(attr).toString()).split("\""))[1];
		result = result.equals(" ")?"":result;
		return result;
	}
}
