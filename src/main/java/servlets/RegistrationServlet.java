package servlets;

import DAO.DAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null) {
            resp.setStatus(400);
            resp.getWriter().println("Login parameter is null");
            return;
        }

        if (password == null) {
            resp.setStatus(400);
            resp.getWriter().println("Login parameter is null");
            return;
        }

        try {
            User user = new User(login, password);
            DAO.addObject(user);
            resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
        } catch (IllegalArgumentException e) {
            resp.setStatus(400);
            resp.getWriter().println("User with this login have already exist");
        } catch (Exception e) {
            resp.setStatus(400);
            resp.getWriter().println(e.getMessage());
        }
    }
}
