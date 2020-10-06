package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.beans.User;
import practice.services.DatabaseService;

@WebServlet("/test")
public class Main extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try (Connection con = DatabaseService.getConnection()) {
			PreparedStatement query = con.prepareStatement("select * from users");
			ResultSet result = query.executeQuery();
			List<User> users = new ArrayList<User>();

			while (result.next()) {
				users.add(new User(result.getInt(1), result.getString(2)));
			}
			req.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/user.jsp").forward(req, res);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}