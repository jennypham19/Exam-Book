package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.BookDao;
import model.Book;





/**
 * Servlet implementation class BookController
 */
@WebServlet("/book")
public class BookController extends HttpServlet implements IBaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String url = request.getServletPath();
		switch (url) {
		case "book/add":
			this.add(request, response);
		case "/book/create":
			this.create(request, response);
			break;
		default:
			break;
		}
		this.findAll(request, response);
		this.view("book.jsp", request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookDao dao = new BookDao();

			List<Book> list = dao.findAll();

			request.setAttribute("book", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}

	}
	protected void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		this.view("input.jsp",request,response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Book book = new Book();
			BeanUtils.populate(book,request.getParameterMap());
			BookDao bookDao = new BookDao();
			bookDao.insert(book);
			request.setAttribute("mess", "Book inserted");
		} catch (Exception e) {
			request.setAttribute("error", "ERROR: " + e.getMessage());
		}
		
	}

}
