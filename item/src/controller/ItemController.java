package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Item;
import service.ItemService;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemService itemService;

	public ItemController() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();	

		// action is separated by detecting url.
		try {
			switch (action) {
			case "/new":
				create(request, response);
				break;
			case "/show":
				show(request, response);
				break;
			case "/insert":
				add(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				edit(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	// Showing Item list
	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		itemService = new ItemService();
		List<Item> listItems = itemService.findItemEntities();		
		
		request.setAttribute("listItems", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("item/list.jsp");
		dispatcher.forward(request, response);

	}

	// Item is created form return by created method
	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("item/create.jsp");
		dispatcher.forward(request, response);

	}

	//Showing Item information by show method
	private void show(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		itemService = new ItemService();
		RequestDispatcher dispatcher;

		Long id = Long.valueOf(request.getParameter("id"));
		Item item = itemService.findItemById(id);

		if (item == null) {
			dispatcher = request.getRequestDispatcher("item/show.jsp");
			request.setAttribute("error", "Not Find Item");
		} else {
			dispatcher = request.getRequestDispatcher("item/show.jsp");
			request.setAttribute("item", item);
		}
		dispatcher.forward(request, response);
	}

	// new Item is saved by add method
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		itemService = new ItemService();

		String name = request.getParameter("name");
		String description = request.getParameter("description");

		Item item = new Item(name, description);
		RequestDispatcher dispatcher;
		try {
			itemService.create(item);

			dispatcher = request.getRequestDispatcher("item/show.jsp");
			request.setAttribute("success", "created Successfully");
			request.setAttribute("item", item);
			dispatcher.forward(request, response);

		} catch (Exception exception) {
			dispatcher = request.getRequestDispatcher("item/create.jsp");
			request.setAttribute("error", "not created");
			dispatcher.forward(request, response);
		}

	}

	// edit method 
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		itemService = new ItemService();

		Long id = Long.valueOf(request.getParameter("id"));
		Item item = itemService.findItemById(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("item/edit.jsp");
		request.setAttribute("item", item);
		dispatcher.forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		itemService = new ItemService();

		Long id = Long.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Item item = itemService.findItemById(id);		
		item.setName(name);
		item.setDescription(description);

		RequestDispatcher dispatcher;
		try {
			itemService.update(item);
			dispatcher = request.getRequestDispatcher("item/show.jsp");
			request.setAttribute("update", "Updated Successfully");
			request.setAttribute("item", item);
			dispatcher.forward(request, response);
		} catch (Exception exception) {
			dispatcher = request.getRequestDispatcher("item/edit.jsp");
			request.setAttribute("error", item);
			dispatcher.forward(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		itemService = new ItemService();
		Long id = Long.parseLong((request.getParameter("id")));
		
		itemService.destroy(id);
		
		List<Item> listItem = itemService.findItemEntities();
		RequestDispatcher dispatcher = request.getRequestDispatcher("item/list.jsp");
		request.setAttribute("delete", "Deleted Successfully");
		request.setAttribute("listItems", listItem);

		dispatcher.forward(request, response);
	}
}
